package com.mlt.japl.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;

import com.mlt.japl.ast.AssignmentNode;
import com.mlt.japl.ast.AstNode;
import com.mlt.japl.errors.AxisError;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.IndexError;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.errors.SyntaxError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.errors.ValueError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.parser.AplParser;
import com.mlt.japl.parser.ParseException;
import com.mlt.japl.parser.TokenMgrError;
import com.mlt.japl.utils.PrintConfig;
import com.mlt.japl.workspace.EvalContext;

public class AplInterpreter extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = -4873107378559328877L;
	private JTextArea editor;
	
	public AplInterpreter() throws FontFormatException, IOException {
		super(new BorderLayout());

		InputStream is = AplInterpreter.class.getResourceAsStream("/com/mlt/japl/gui/SImPL.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, is);
		Font derivedFont = font.deriveFont(15f);
		
		JToolBar toolbar = new JToolBar("APL toolbar");
		toolbar.setLayout(new WrapLayout(WrapLayout.LEFT));
		addButtons(toolbar, derivedFont);
				
		editor = new JTextArea();
		editor.setEditable(true);
		editor.addKeyListener(this);
		editor.setFont(derivedFont);
		
		editor.append("*** JAPL Version 0.1 ***\n(C) Marko Lauronen 2015\n\nCLEAR WS\n");
		editor.append("\t");
		
		JScrollPane scrollPane = new JScrollPane(editor);

		add(toolbar, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);		
		
		setPreferredSize(new Dimension(1024,768));
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
		editor.insert(e.getActionCommand(), editor.getCaretPosition());
		editor.grabFocus();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	private EvalContext env = new EvalContext();
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10) {
		  try {
		    int offset=editor.getLineOfOffset(editor.getCaretPosition());
		    int start=editor.getLineStartOffset(offset);
		    int end=editor.getLineEndOffset(offset);

		    String line = editor.getText(start, (end-start)).trim();
		    if(line.length()>0) {
			    AplParser parser = new AplParser(new StringReader(line), env);
			    AstNode ast = parser.apl_expr();
			    System.out.println("AST: " + ast.print());
			    
			    long startTime = System.nanoTime();
			    Array evalResult = ast.eval(env);
				String result = evalResult.asString(new PrintConfig());
				System.out.println("   result type = " + evalResult.getClass());
			    long stopTime = System.nanoTime();
			    System.out.println("   eval() took " + ((stopTime-startTime)/1000.0) + " us");
			    
			    if(!(ast instanceof AssignmentNode)) {
				    editor.append("\n" + result);			    	
			    }
		    }
		  } catch (BadLocationException ex) {
		    System.out.println(ex.getMessage());
		  } catch (ParseException e1) {
			  editor.append("\nPARSE ERROR");
		  } catch(SyntaxError err) {
			  editor.append("\nSYNTAX ERROR");
		  } catch(LengthError err) {
			  editor.append("\nLENGTH ERROR");
		  } catch(DomainError err) {
			  editor.append("\nDOMAIN ERROR");
			  err.printStackTrace();
		  } catch(IndexError err) {
			  editor.append("\nINDEX ERROR");
		  } catch(ValueError err) {
			  editor.append("\nVALUE ERROR");
			  err.printStackTrace();
		  } catch(AxisError err) {
			  editor.append("\nAXIS ERROR");
		  } catch(TokenMgrError err) {
			  editor.append("\nLEXICAL ERROR");
		  } catch(ValenceError err) {
			  editor.append("\nVALENCE ERROR");			  
		  } catch(RankError err) {
			  editor.append("\nRANK ERROR");
		  }
		  
	    e.consume();
	    editor.append("\n\t");
	    editor.setCaretPosition(editor.getText().length());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	public static void createGUI() throws FontFormatException, IOException {
		JFrame frame = new JFrame("APL Interpreter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new AplInterpreter());
		frame.pack();
		frame.setVisible(true);
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
