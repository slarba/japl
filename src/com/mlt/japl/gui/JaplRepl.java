package com.mlt.japl.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;

@SuppressWarnings("serial")
public class JaplRepl extends JTextPane implements KeyListener, DocumentListener {
	private StyleContext styleContext;
	private Style exprStyle;
	private Style resultStyle;
	private Style errorStyle;
	private ArrayList<String> lineHistory = new ArrayList<String>();
	private int lineHistoryPosition = 0;
	private PipedOutputStream lineOutputStream;
	private PipedInputStream resultInputStream;
	private PipedInputStream pipedInput;
	private PipedOutputStream pipedOutput;

	private PipedOutputStream pipedError;
	private PipedInputStream errorInputStream;
		
	private AplSyntaxHighlighter highlighter = new AplSyntaxHighlighter();
	
	public JaplRepl(Font aplFont) {
		setFont(aplFont);
		
		addKeyListener(this);
		getStyledDocument().addDocumentListener(this);
		
		lineOutputStream = new PipedOutputStream();
		resultInputStream = new PipedInputStream();
		errorInputStream = new PipedInputStream();
		
		try {
			pipedInput = new PipedInputStream(lineOutputStream);
			pipedOutput = new PipedOutputStream(resultInputStream);
			pipedError = new PipedOutputStream(errorInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		styleContext = new StyleContext();
		exprStyle = styleContext.addStyle("expr", null);
		StyleConstants.setForeground(exprStyle, Color.BLUE);
		resultStyle = styleContext.addStyle("result", null);
		StyleConstants.setForeground(resultStyle, Color.BLACK);
		errorStyle = styleContext.addStyle("error", null);
		StyleConstants.setForeground(errorStyle, Color.RED);
		
		insertExpr("*** JAPL Interpreter v0.1 ***\n(c) Marko Lauronen 2015");
		insertExpr("\n\n\t");
		
		startOutputThread();
		startErrorThread();
	}
	
	private void startOutputThread() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				BufferedReader reader = new BufferedReader(new InputStreamReader(resultInputStream));
				while(true) {
					try {
						String l = reader.readLine();
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								replaceCurrentLine("");
								insertResult(l);
								setCaretPosition(getLastPosition()-1);
								insertExpr("\n\t");
							}
						});
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
	}

	private void startErrorThread() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				BufferedReader reader = new BufferedReader(new InputStreamReader(errorInputStream));
				while(true) {
					try {
						String l = reader.readLine();
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								replaceCurrentLine("");
								insertError(l);
								setCaretPosition(getLastPosition()-1);
								insertExpr("\n\t");
							}
						});
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
	}
	
	private int getLastPosition() {
		return getStyledDocument().getEndPosition().getOffset();
	}

	private void insert(String s, Style style) {
		try {
			this.getStyledDocument().insertString(getCaretPosition(), s, style);
		} catch (BadLocationException e) {
			throw new RuntimeException("bad document position", e);
		}
	}
	
	public void insertResult(String s) {
		insert(s, resultStyle);
	}

	public void insertExpr(String s) {
		insert(s, exprStyle);
	}

	public void insertError(String s) {
		insert(s, errorStyle);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	private String getCurrentLine() {
		try {
			int caretPos = getCaretPosition();
			int lineStart = Utilities.getRowStart(this, caretPos);
			int lineEnd = Utilities.getRowEnd(this, caretPos);
			return getStyledDocument().getText(lineStart, lineEnd-lineStart);
		} catch (BadLocationException e) {
			throw new RuntimeException("bad document position getting current line", e);
		}
	}

	private void changeFontSize(float multiplier) {
		Font f = this.getFont();
		Font derived = f.deriveFont(f.getSize2D()*multiplier);
		setFont(derived);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()=='+' && e.getModifiers()==4) {
			changeFontSize(1.5f);
		}
		if(e.getKeyChar()=='-' && e.getModifiers()==4) {
			changeFontSize(0.6666666666666666f);
		}
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			if(isCaretOnEditLine()) {
				setCaretPosition(getLastPosition()-1);
				handleEnter(getCurrentLine());
				insertExpr("\n\t");
				setCaretPosition(getLastPosition()-1);				
			} else {
				String lineCursorWasOn = getCurrentLine().trim();
				setCaretPosition(getLastPosition()-1);
				replaceCurrentLine("\t" + lineCursorWasOn);
			}
			e.consume();
			break;
		case KeyEvent.VK_UP:
			historyPrevious();
			e.consume();
			break;
		case KeyEvent.VK_DOWN:
			historyNext();
			e.consume();
			break;
		default:
			lineHistoryPosition = lineHistory.size();
			break;
		}
	}

	private void historyNext() {
		if(lineHistory.size()==0) return;

		lineHistoryPosition++;
		if(lineHistoryPosition>=lineHistory.size()) {
			lineHistoryPosition = lineHistory.size();
			return;
		}
		replaceCurrentLine("\t" + lineHistory.get(lineHistoryPosition));
	}

	private void historyPrevious() {
		if(lineHistory.size()==0) return;
		
		lineHistoryPosition--;
		if(lineHistoryPosition<0) {
			lineHistoryPosition = 0;
			return;			
		}
		replaceCurrentLine("\t" + lineHistory.get(lineHistoryPosition));
	}

	private boolean isCaretOnEditLine() {
		try {
			int caretPos = getCaretPosition();
			int lastPos = getLastPosition();
			int lastLineStart = Utilities.getRowStart(this, lastPos-1);
			return caretPos>=lastLineStart && caretPos<=lastPos;
		} catch(BadLocationException e) {
			throw new RuntimeException("bad location", e);			
		}
	}
	
	private void replaceCurrentLine(String string) {
		try {
			int caretPos = getCaretPosition();
			int lineStart = Utilities.getRowStart(this, caretPos);
			getStyledDocument().remove(lineStart, caretPos-lineStart);
			getStyledDocument().insertString(lineStart, string, exprStyle);
		} catch(BadLocationException e) {
			throw new RuntimeException("bad location when replacing current line", e);
		}
	}

	private void handleEnter(String currentLine) {
		String trimmed = currentLine.trim();
		if(trimmed.length()==0) return;  // don't add empty lines
		lineHistory.add(trimmed);
		lineHistoryPosition = lineHistory.size();
		System.out.println("line entered: " + trimmed);
		PrintWriter p = new PrintWriter(lineOutputStream);
		p.println(trimmed);
		p.flush();
	}

	public InputStream getInputStream() {
		return pipedInput;
	}

	public OutputStream getOutputStream() {
		return pipedOutput;
	}
	
	public OutputStream getErrorStream() {
		return pipedError;
	}
	
	public OutputStream getLineOutputStream() {
		return lineOutputStream;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}

	private void highlightEditLine()
	{
		JaplRepl self = this;
		StyledDocument doc = getStyledDocument();
		doc.removeDocumentListener(this);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					int lineStart = Utilities.getRowStart(self, getLastPosition()-1);
					int lineEnd = getLastPosition();
					highlighter.syntaxHighlight(doc, lineStart, lineEnd);
					doc.addDocumentListener(self);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});			
		
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		highlightEditLine();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		highlightEditLine();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		highlightEditLine();
	}

}
