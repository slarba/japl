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

	AplSyntaxHighlighter highlighter;
	DocumentListener parentListener;
	
	public JaplEditor(Font font) {
		super();
		highlighter = new AplSyntaxHighlighter();
		setFont(font);
		getStyledDocument().addDocumentListener(this);
	}

	public void addDocumentListener(DocumentListener listener) {
		parentListener = listener;
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

	private void syntaxHighlight() {
		getStyledDocument().removeDocumentListener(this);
		getStyledDocument().removeDocumentListener(parentListener);
		StyledDocument doc = getStyledDocument();
		highlighter.syntaxHighlight(doc);
		getStyledDocument().addDocumentListener(this);
		getStyledDocument().addDocumentListener(parentListener);
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
