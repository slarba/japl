package com.mlt.japl.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.parser.TokenMgrError;
import com.mlt.japl.utils.PrintConfig;
import com.mlt.japl.workspace.Interpreter;

public class JaplMain {
	private static Font createFont(String resourcePath) {
		InputStream is = JaplMain.class.getResourceAsStream(resourcePath);
		Font font;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (Exception e) {
			throw new RuntimeException("could not load font", e);
		}
		return font.deriveFont(15f);		
	}

	public static void createGUI() throws FontFormatException, IOException {
		JFrame frame = new JFrame("APL Interpreter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font aplFont = createFont("/com/mlt/japl/gui/SImPL.ttf");
		JaplRepl repl = new JaplRepl(aplFont);
		Interpreter i = new Interpreter(repl.getOutputStream());
		JaplInterpreter interpreter = new JaplInterpreter(repl, aplFont);
		interpreter.setPreferredSize(new Dimension(1024,768));

		frame.add(interpreter);
		frame.pack();
		frame.setVisible(true);
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
						Array result = i.eval(line);
						ps.println(result.asString(new PrintConfig()));
						ps.flush();					
					} catch(AplError e) {
						es.println(e.getMessage());
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
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					createGUI();
				} catch (FontFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
