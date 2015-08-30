package com.mlt.japl.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.parser.TokenMgrError;
import com.mlt.japl.utils.PrintConfig;
import com.mlt.japl.workspace.Interpreter;

@SuppressWarnings("serial")
public class JaplMainFrame extends JFrame implements ActionListener {
	Font aplFont;
	
	public JaplMainFrame() {
		super("APL Interpreter");
		try {
			createGUI();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Font createFont(String resourcePath) {
		InputStream is = JaplMainFrame.class.getResourceAsStream(resourcePath);
		Font font;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (Exception e) {
			throw new RuntimeException("could not load font", e);
		}
		return font.deriveFont(15f);		
	}

	public void createGUI() throws FontFormatException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		aplFont = createFont("/com/mlt/japl/gui/SImPL.ttf");
		JaplRepl repl = new JaplRepl(aplFont);
		Interpreter i = new Interpreter(repl.getOutputStream());
		JaplInterpreter interpreter = new JaplInterpreter(repl, aplFont);
		i.addBusyListener(interpreter);
		interpreter.setPreferredSize(new Dimension(1024,768));
		
		setJMenuBar(createMenuBar());
		
		getContentPane().add(interpreter);
		pack();
		setVisible(true);
		repl.requestFocus();

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				BufferedReader reader = new BufferedReader(new InputStreamReader(repl.getInputStream()));
				PrintStream ps = new PrintStream(repl.getOutputStream());
				PrintStream es = new PrintStream(repl.getErrorStream());
				while(true) {
					try {
						String line = reader.readLine();
						IValue result = i.eval(line);
						ps.println(result.asString(new PrintConfig()));
						ps.flush();					
					} catch(AplError e) {
						es.println(e.getMessage());
						es.flush();
					} catch(ArithmeticException e) {
						es.println("DIVBYZERO");
						es.flush();
					} catch(TokenMgrError e) {
						e.printStackTrace(es);
						es.flush();
					} catch (Exception e) {
						e.printStackTrace(es);
						es.flush();
					}
				}
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

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JaplMainFrame();
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "newFile":
			new JaplEditorFrame(aplFont);
			break;
		case "quit":
			System.exit(0);
			break;
		case "openFile":
			JFileChooser chooser = new JFileChooser();
			if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
				new JaplEditorFrame(aplFont, chooser.getSelectedFile());
			}
		}
	}

}
