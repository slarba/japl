package com.mlt.japl.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
		JaplInterpreter interpreter = new JaplInterpreter(repl, aplFont);
		interpreter.setPreferredSize(new Dimension(1024,768));

		frame.add(interpreter);
		frame.pack();
		frame.setVisible(true);
		repl.requestFocus();
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
