package com.mlt.japl.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class JaplEditor extends JTextPane implements DocumentListener {
	Pattern numbersPattern = Pattern.compile("[¯]?[0-9]+([\\.][0-9]+)?");
	Pattern keywordPattern = Pattern.compile(":(While)|(Do)|(EndWhile)|(If)|(Then)|(EndIf)|(Repeat)|(EndRepeat)");
	Pattern commentPattern = Pattern.compile("\u235d.*\n");
	Pattern operatorPattern = Pattern.compile("[\u03b1\u03c9\u003f\u2208\u2308"
			+ "\u230a\u2374\u223c\u2223\u2373"
			+ "\u22c6\u2212\u002b\u00d7\u00f7"
			+ "\u002c\u2339\u25cb\u235f\u233d"
			+ "\u2296\u234b\u2352\u234e\u2355"
			+ "\u2349\u0021\u2208\u2191\u2193"
			+ "\u22a5\u22a4\u002f\u2339\u2349"
			+ "\u00a8\u003c\u2264\u003d\u2265"
			+ "\u2261\u2282\u2283\u003e\u2260"
			+ "\u2228\u2227\u2371\u2372\u2190"
			+ "\u2218\u22a5\u22c4\u222a\u233f"
			+ "\u2340\u236c\u2395\u22a3\\."
			+ "\u22a2\u2337]+");
	
	Style numbersStyle;
	Style keywordStyle;
	Style commentStyle;
	Style defaultStyle;
	Style operatorStyle;
	
	public JaplEditor(Font font) {
		super();
		
		StyleContext styleContext = new StyleContext();
		defaultStyle = styleContext.addStyle("defaultStyle", null);
		StyleConstants.setForeground(defaultStyle, Color.BLACK);
		operatorStyle = styleContext.addStyle("operatorStyle", null);
		StyleConstants.setForeground(operatorStyle, new Color(194, 97, 207));		
		numbersStyle = styleContext.addStyle("numberStyle", null);
		StyleConstants.setForeground(numbersStyle, Color.BLUE);
		keywordStyle = styleContext.addStyle("keywordStyle", null);
		StyleConstants.setBold(keywordStyle, true);
		StyleConstants.setForeground(keywordStyle, new Color(77, 111, 122));
		commentStyle = styleContext.addStyle("commentStyle", null);
		StyleConstants.setForeground(commentStyle, Color.DARK_GRAY);
		StyleConstants.setItalic(commentStyle, true);
		getStyledDocument().addDocumentListener(this);
		setFont(font);
	}

	public void addDocumentListener(DocumentListener listener) {
		getStyledDocument().addDocumentListener(listener);		
	}
	
	public void insert(String actionCommand) {
		try {
			getStyledDocument().insertString(getCaretPosition(), actionCommand, null);
			requestFocus();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	private void highlightPattern(StyledDocument doc, Pattern p, Style style) {
		try {
			String text = doc.getText(0, doc.getLength());
			Matcher m = p.matcher(text);
			while(m.find()) {
				doc.setCharacterAttributes(m.start(), m.end()-m.start(), style, true);
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}		
	}
	private void syntaxHighlight() {
		getStyledDocument().removeDocumentListener(this);
		System.out.println("syntax highlight");
		StyledDocument doc = getStyledDocument();
		doc.setCharacterAttributes(0, doc.getLength(), defaultStyle, true);
		highlightPattern(doc, operatorPattern, operatorStyle);
		highlightPattern(doc, commentPattern, commentStyle);
		highlightPattern(doc, numbersPattern, numbersStyle);
		highlightPattern(doc, keywordPattern, keywordStyle);
		getStyledDocument().addDocumentListener(this);
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				syntaxHighlight();
			}
		});
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				syntaxHighlight();
			}
		});
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				syntaxHighlight();
			}
		});
	}
}
