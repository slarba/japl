package com.mlt.japl.gui;

import com.mlt.japl.workspace.Interpreter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings("serial")
public class jApl extends JFrame implements ActionListener {
    Font aplFont;
    JaplInterpreter interpreter;
    JaplRepl repl;

    public jApl() {
        super("APL Interpreter");
        try {
            createGUI();
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new jApl();
            }
        });
    }

    private Font createFont(String resourcePath) {
        InputStream is = jApl.class.getResourceAsStream(resourcePath);
        Font font;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception e) {
            throw new RuntimeException("could not load font", e);
        }
        return font.deriveFont(15f);
    }

    public void createGUI() throws FontFormatException, IOException {
        setTitle("jAPL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aplFont = createFont("/com/mlt/japl/gui/SImPL.ttf");
        repl = new JaplRepl(aplFont);
        Interpreter i = new Interpreter(repl.getOutputStream(), repl.getErrorStream());
        interpreter = new JaplInterpreter(repl, aplFont);
        i.addBusyListener(interpreter);
        interpreter.setPreferredSize(new Dimension(1024, 768));

        setJMenuBar(createMenuBar());

        getContentPane().add(interpreter);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        repl.requestFocus();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    i.eval(repl.getInputStream());
            }
        });
        t.start();
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newFile = new JMenuItem("New");
        newFile.setActionCommand("newFile");
        newFile.addActionListener(this);
        JMenuItem openFile = new JMenuItem("Open");
        openFile.setActionCommand("openFile");
        openFile.addActionListener(this);
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.setActionCommand("quit");
        quitItem.addActionListener(this);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(quitItem);
        menuBar.add(fileMenu);
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "newFile":
                new JaplEditorFrame(aplFont, repl.getLineOutputStream());
                break;
            case "quit":
                System.exit(0);
                break;
            case "openFile":
                JFileChooser chooser = new JFileChooser();
                if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    new JaplEditorFrame(aplFont, chooser.getSelectedFile(), repl.getLineOutputStream());
                }
        }
    }

}
