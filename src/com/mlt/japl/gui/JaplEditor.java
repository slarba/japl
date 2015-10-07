package com.mlt.japl.gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import java.awt.*;

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
