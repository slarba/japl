package com.mlt.japl.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JaplEditorFrame extends JFrame implements ActionListener, DocumentListener {
	JaplEditor editor;
	private File file;
	private boolean changed;
	private OutputStream replOutput;
	
	public JaplEditorFrame(Font font, OutputStream replOutput) {
		super();
		this.replOutput = replOutput;
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		setJMenuBar(createMenuBar());

		editor = new JaplEditor(font);
		editor.addDocumentListener(this);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(!checkChanged()) dispose();
			}
		});
		
		panel.add(new AplToolbar(font, this), BorderLayout.PAGE_START);
		panel.add(new JScrollPane(editor), BorderLayout.CENTER);
		add(panel);
		setSize(1024, 768);
		setVisible(true);
	}
	
	public JaplEditorFrame(Font aplFont, File file, OutputStream replOutput) {
		this(aplFont, replOutput);

		setTitle(file.getAbsolutePath());
		this.file = file;
		editor.setText(readFile(file));
		clearChanged();
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem saveFile = new JMenuItem("Save");
		saveFile.setAccelerator(KeyStroke.getKeyStroke("meta S"));
		saveFile.setActionCommand("save");
		saveFile.addActionListener(this);
		JMenuItem saveAsFile = new JMenuItem("Save As");	
		saveAsFile.setActionCommand("saveAs");
		saveAsFile.addActionListener(this);
		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.setActionCommand("quit");
		quitItem.addActionListener(this);
		fileMenu.add(saveFile);
		fileMenu.add(saveAsFile);
		fileMenu.add(quitItem);		
		menuBar.add(fileMenu);
		
		JMenu evalMenu = new JMenu("Repl");
		JMenuItem evalMenuItem = new JMenuItem("Evaluate buffer");
		evalMenuItem.setAccelerator(KeyStroke.getKeyStroke("meta E"));
		evalMenuItem.setActionCommand("eval");
		evalMenuItem.addActionListener(this);
		evalMenu.add(evalMenuItem);
		menuBar.add(evalMenu);
		return menuBar;
	}

	private void save(File file) {
		try {
			Writer s = new OutputStreamWriter(new FileOutputStream(file), Charset.forName("UTF-8"));
			s.write(editor.getText());
			s.flush();
			s.close();
			clearChanged();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	private void clearChanged() {
		changed = false;
		setTitle(file!=null ? file.getAbsolutePath() : "");
	}
	
	private String readFile(File f) {
		byte[] encoded;
		try {
			encoded = Files.readAllBytes(f.toPath());
			return new String(encoded, Charset.forName("UTF-8"));
		} catch (IOException e) {
			throw new RuntimeException("could not open file!");
		}
	}

	private void saveAs() {
		JFileChooser chooser = new JFileChooser();
		if(file!=null) chooser.setCurrentDirectory(file);
		if(chooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) {
			save(chooser.getSelectedFile());
		}		
	}
	
	public boolean checkChanged() {
		if(changed) {
			int response = JOptionPane.showConfirmDialog(this, "Unsaved changes, save first?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
			switch(response) {
			case JOptionPane.CANCEL_OPTION:
				return true;
			case JOptionPane.YES_OPTION:
				if(file!=null) save(file); else saveAs();
				break;
			case JOptionPane.NO_OPTION:
				break;
			}
		}		
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "quit":
			checkChanged();
			this.setVisible(false);
			break;
		case "saveAs":
			saveAs();
			break;
		case "save":
			if(file!=null) save(file); else saveAs();
			break;
		case "eval":
			evaluateBuffer();
			break;
		default:
			editor.insert(e.getActionCommand());
			break;
		}
	}

	private void evaluateBuffer() {
		System.out.println("evaluating buffer");
		String code = editor.getText();
		PrintWriter writer = new PrintWriter(replOutput);
		writer.println(code);
		writer.flush();
	}

	public void setChanged() {
		changed = true;
		setTitle("* " + (file!=null ? file.getAbsolutePath() : ""));		
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		setChanged();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		setChanged();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		setChanged();
	}

}
