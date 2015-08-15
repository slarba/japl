package com.mlt.japl.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

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
		String[] buttons = new String[] {
				"¯"
				,"\u03b1"
				,"\u03c9"
			    ,"\u003f"  // roll ?
				,"\u2208"  // exists
				  ,"\u2308"  // ceil
				  ,"\u230a"  // floor
				  ,"\u2374"  // rho, shape
				  ,"\u223c"  // tilde (not)
				  ,"\u2223"  // abs
				  ,"\u2373"  // iota
				  ,"\u22c6"  // exponential
				  ,"\u2212"  // negation/sub
				  ,"\u002b"  // identity/add
				  ,"\u00d7"  // signum/mul
				  ,"\u00f7"  // reciprocal/divide
				  ,"\u002c"  // ravel,catenate
				  ,"\u2339"  // matrix inverse
				  ,"\u25cb"  // pi times
				  ,"\u235f"  // log
				  ,"\u233d"  // reverse last axis
				  ,"\u2296"  // reverse first axis
				  ,"\u234b"  // grade up
				  ,"\u2352"  // grade down
				  ,"\u234e"  // execute apl expr
				  ,"\u2355"  // format
				  ,"\u2349"  // transpose
				  ,"\u0021"  // factorial
				  ,"\u2208"  // epsilon, membership
				  ,"\u2191"  // take
				  ,"\u2193"  // drop
				  ,"\u22a5"  // decode
				  ,"\u22a4"  // encode
				  ,"\\"      // expand
				  ,"\u002f"  // compress
				  ,"\u2339"  // matrix divide
				  ,"\u2349"  // general transpose
				  ,"\u00a8"  // each
				  ,"\u003c"  // less than
				  ,"\u2264"  // less than or equal
				  ,"\u003d"  // equal
				  ,"\u2265"  // greater than or equal
				  ,"\u2261"  // depth
				  ,"\u2282"  // enclose
				  ,"\u2283"  // disclose
				  ,"\u003e"  // greater than
				  ,"\u2260"  // not equal
				  ,"\u2228"  // logical or
				  ,"\u2227"  // logical and
				  ,"\u2371"  // nor
				  ,"\u2372"  // nand
				  ,"←"  // assign
				  ,"\u2218." // outer product
				  ,"\u22a5"  // decode
				  ,"\u22c4"  // statement separator
				  ,"\u222a"  // union/unique
				  ,"\u233f"  // reduce first axis
				  ,"\u2340"  // scan first axis
				  ,"\u236c"  // zilde
				  ,"\u235d"  // lamp
				  ,"\u2395"
				  ,"\u22a3"  // stop
				  ,"\u22a2"  // pass
				  ,"⍪"  // laminate first axis
				  ,"\u2337"  // index
		};
		for(String s : buttons) {
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
		
	}

}
