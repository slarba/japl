package com.mlt.japl.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;

public class JaplRepl extends JTextPane implements KeyListener {
	private StyleContext styleContext;
	private Style exprStyle;
	private Style resultStyle;
	private ArrayList<String> lineHistory = new ArrayList<String>();
	private int lineHistoryPosition = 0;
	
	public JaplRepl(Font aplFont) {
		setFont(aplFont);
		
		addKeyListener(this);
		
		styleContext = new StyleContext();
		exprStyle = styleContext.addStyle("expr", null);
		StyleConstants.setForeground(exprStyle, Color.BLACK);
		resultStyle = styleContext.addStyle("result", null);
		StyleConstants.setForeground(resultStyle, Color.BLUE);
		
		insertResult("*** JAPL Interpreter v0.1 ***\n(c) Marko Lauronen 2015");
		insertExpr("\n\t");
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

	@Override
	public void keyTyped(KeyEvent e) {
	}

	private String getCurrentLine() {
		try {
			int caretPos = getCaretPosition();
			int lineStart = Utilities.getRowStart(this, caretPos);
			return getStyledDocument().getText(lineStart, caretPos-lineStart);
		} catch (BadLocationException e) {
			throw new RuntimeException("bad document position getting current line", e);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			if(isCaretOnEditLine()) {
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
			if(e.getKeyChar()!=KeyEvent.CHAR_UNDEFINED && e.getModifiers()!=0) {
				if(e.getModifiers()==1) {
					System.out.println("Pelkkä shift");
					break;
				}
				System.out.println(KeyEvent.getKeyModifiersText(e.getModifiers()) + KeyEvent.getKeyText(e.getKeyCode()));
				e.consume();
			}
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
		insertResult("\n" + trimmed);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
