package com.mlt.japl.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AplToolbar extends JToolBar {
    private ActionListener listener;

    public AplToolbar(Font aplFont, ActionListener listener) {
        super("APL Toolbar");
        this.listener = listener;
        setLayout(new WrapLayout(WrapLayout.LEFT));
        addButtons(aplFont);
    }

    private void addButtons(Font font) {
        for (String s : AplKeymap.SYMBOLS) {
            add(createButton(s, font));
        }
    }

    private JButton createButton(String title, Font font) {
        JButton button = new JButton();
        button.setFont(font);
        button.addActionListener(listener);
        button.setText(title);
        button.setActionCommand(title);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }

}
