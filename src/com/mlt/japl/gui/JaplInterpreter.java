package com.mlt.japl.gui;

import com.mlt.japl.workspace.AplBusyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class JaplInterpreter extends JPanel implements ActionListener, AplBusyListener {
    private Font font;
    private JaplRepl repl;
    private StatusBar statusBar;

    public JaplInterpreter(JaplRepl repl, Font font) {
        super(new BorderLayout());

        this.font = font;
        this.repl = repl;

        add(new AplToolbar(font, this), BorderLayout.PAGE_START);

        JScrollPane scroll = new JScrollPane(repl);
        add(scroll, BorderLayout.CENTER);
        statusBar = new StatusBar();
        statusBar.setPreferredSize(new Dimension(getWidth(), 20));
        add(statusBar, BorderLayout.PAGE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repl.insertExpr(e.getActionCommand());
        repl.requestFocus();
    }

    @Override
    public void evaluationStarted() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                statusBar.setText("Evaluating...");
            }
        });
    }

    @Override
    public void evaluationEnded() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                statusBar.setText("Ready.");
            }
        });
    }
}
