package com.mlt.japl.gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class StatusBar extends javax.swing.JPanel {
	private JLabel status;

	public StatusBar() {
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		status = new JLabel("Ready.");
		status.setHorizontalAlignment(SwingConstants.LEFT);
		add(status);
	}
	
	public void setText(String text) {
		status.setText(text);
	}
}
