package com.mlt.japl.gui;

import javax.swing.text.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AplSyntaxHighlighter {
    Pattern numbersPattern = Pattern.compile("[¯]?[0-9]+([\\.][0-9]+)?");
    Pattern keywordPattern = Pattern.compile(":(While)|(Do)|(EndWhile)|(If)|(Else)|(EndIf)|(Repeat)|(EndRepeat)|(ElseIf)|(For)|(In)|(EndFor)");
    Pattern commentPattern = Pattern.compile("\u235d.*\n");
    Pattern stringPattern = Pattern.compile("'([^']*)'");

    Pattern operatorPattern = Pattern.compile("[\u237a\u2375\u03b1\u03c9\u003f\u2308"
            + "\u230a\u2374\u223c\u2223\u2373"
            + "\u22c6\u2212\u002b\u00d7\u00f7"
            + "\u002c\u2339\u25cb\u235f\u233d"
            + "\u2296\u234b\u2352\u234e\u2355"
            + "\u2349\u0021\u220a\u2191\u2193"
            + "\u22a5\u22a4\u002f\u2339\u2349"
            + "\u00a8\u003c\u2264\u003d\u2265"
            + "\u2261\u2282\u2283\u003e\u2260"
            + "\u2228\u2227\u2371\u2372\u2190"
            + "\u2218\u22a5\u22c4\u222a\u233f"
            + "\u2340\u236c\u2395\u22a3\\."
            + "\u22a2\u2337\u2207\u2229⍪]+");

    Style numbersStyle;
    Style keywordStyle;
    Style commentStyle;
    Style defaultStyle;
    Style operatorStyle;
    Style stringStyle;

    public AplSyntaxHighlighter() {
        StyleContext styleContext = new StyleContext();
        defaultStyle = styleContext.addStyle("defaultStyle", null);
        StyleConstants.setForeground(defaultStyle, Color.BLACK);
        operatorStyle = styleContext.addStyle("operatorStyle", null);
        StyleConstants.setForeground(operatorStyle, new Color(194, 97, 207));
        numbersStyle = styleContext.addStyle("numberStyle", null);
        StyleConstants.setForeground(numbersStyle, Color.BLUE);
        stringStyle = styleContext.addStyle("stringStyle", null);
        StyleConstants.setForeground(stringStyle, Color.DARK_GRAY);
        keywordStyle = styleContext.addStyle("keywordStyle", null);
        StyleConstants.setBold(keywordStyle, true);
        StyleConstants.setForeground(keywordStyle, new Color(77, 111, 122));
        commentStyle = styleContext.addStyle("commentStyle", null);
        StyleConstants.setForeground(commentStyle, Color.DARK_GRAY);
        StyleConstants.setItalic(commentStyle, true);
    }

    private void highlightPattern(StyledDocument doc, int start, int end, Pattern p, Style style) {
        try {
            String text = doc.getText(start, end - start);
            Matcher m = p.matcher(text);
            while (m.find()) {
                doc.setCharacterAttributes(start + m.start(), m.end() - m.start(), style, true);
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void syntaxHighlight(StyledDocument doc, int start, int end) {
        doc.setCharacterAttributes(start, end - start, defaultStyle, true);
        highlightPattern(doc, start, end, operatorPattern, operatorStyle);
        highlightPattern(doc, start, end, numbersPattern, numbersStyle);
        highlightPattern(doc, start, end, keywordPattern, keywordStyle);
        highlightPattern(doc, start, end, stringPattern, stringStyle);
        highlightPattern(doc, start, end, commentPattern, commentStyle);
    }

    public void syntaxHighlight(StyledDocument doc) {
        syntaxHighlight(doc, 0, doc.getLength());
    }
}
