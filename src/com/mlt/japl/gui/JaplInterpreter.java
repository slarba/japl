package com.mlt.japl.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class JaplInterpreter extends JPanel implements ActionListener {
	private Font font;
	private JaplRepl repl;

	public JaplInterpreter(JaplRepl repl, Font font) {
		super(new BorderLayout());
		
		this.font = font;
		this.repl = repl;
		
		add(createToolbar(), BorderLayout.PAGE_START);
		
		JScrollPane scroll = new JScrollPane(repl);		
		add(scroll, BorderLayout.CENTER);
	}

	private JToolBar createToolbar() {
		JToolBar toolbar = new JToolBar("APL toolbar");
		toolbar.setLayout(new WrapLayout(WrapLayout.LEFT));
		addButtons(toolbar, font);
		return toolbar;
	}
	
	private void addButtons(JToolBar toolbar, Font font) {
		for(String s : AplKeymap.SYMBOLS) {
			toolbar.add(createButton(s,font));
		}
	}
	
	private JButton createButton(String title, Font font) {
		JButton button = new JButton();
		button.setFont(font);
		button.addActionListener(this);
		button.setText(title);
		button.setActionCommand(title);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repl.insertExpr(e.getActionCommand());
		repl.requestFocus();
	}

}
