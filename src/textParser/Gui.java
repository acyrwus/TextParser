package textParser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Gui {
	
	public String outputText;
	public String inputText = "";
	public Parser parser;

	public static void main(String[] args) {
		Gui gui = new Gui();
		gui.create_gui();
	}
	
	/*
	 * Create GUI constructs the whole of the GUI
	 * It also sets up action listeners for button functionality
	 */
	
	public void create_gui() {
		
		//Make Parser
		parser = new Parser();
		
		//Initialize all Java Swing elements
		JFrame frame = new JFrame();
		JPanel bottomPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		BorderLayout bl = new BorderLayout(0,0);
		BorderLayout blMiddle = new BorderLayout(0,0);
		JTextArea txt = new JTextArea();
		JTextArea errors = new JTextArea();
		BorderLayout bottomBar = new BorderLayout();
		JButton saveBtn = new JButton("Save");
		JButton openBtn = new JButton("Open");
		
		JScrollPane txtSP = new JScrollPane(txt);
		JScrollPane errorSP = new JScrollPane(errors);
		
		
		//Setup Gui with text alignment and borders 
		txt.setBorder(BorderFactory.createBevelBorder(1));
		txt.setAlignmentY(JTextField.LEADING);
		txt.setText("");
		errors.setBorder(BorderFactory.createBevelBorder(1));
		errors.setAlignmentY(JTextField.LEADING);
		
		//Setup GUI elements with dimensions
		
		frame.setMinimumSize(new Dimension(400, 500));
		
		errorSP.setPreferredSize(new Dimension(400,100));
		saveBtn.setPreferredSize(new Dimension(100,60));
		openBtn.setPreferredSize(new Dimension(100,60));
		
		bottomPanel.setLayout(bottomBar);
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		bottomPanel.add(saveBtn, BorderLayout.EAST);
		bottomPanel.add(openBtn, BorderLayout.WEST);
		
		topPanel.setLayout(bl);
		
		topPanel.add(new JLabel("Formatted Text: "), BorderLayout.NORTH);
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		topPanel.add(txtSP);
		topPanel.add(middlePanel, BorderLayout.SOUTH);
		
		middlePanel.setLayout(blMiddle);
		middlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		middlePanel.add(new JLabel("Errors:"), BorderLayout.NORTH);
		middlePanel.add(errorSP, BorderLayout.CENTER);
		
		frame.setSize(400,500);
		
		
		frame.add(topPanel, BorderLayout.CENTER);
		frame.add(bottomPanel, BorderLayout.SOUTH);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		saveBtn.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  
				  
				  JFileChooser j = new JFileChooser();
				  FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
				  j.setFileFilter(filter);
				  int r = j.showSaveDialog(null);
				  
				  File file = j.getSelectedFile();
				  System.out.println(file.getPath());
				  
				  inputText = txt.getText();
				  
				  
				  
				  
				  
				  System.out.println(r);
				  try {
					PrintWriter out = new PrintWriter(file.getPath());
					
					
					out.println(txt.getText());
					out.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  return;
			  }
		});
		
		
		openBtn.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  
				  
				  JFileChooser j = new JFileChooser();
				  FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
				  j.setFileSelectionMode(JFileChooser.FILES_ONLY);
				  j.setFileFilter(filter);
				  int r = j.showSaveDialog(null);
				  
				  File file = j.getSelectedFile();
				  System.out.println(file.getPath());
				  
				  String text = null;
				  
				  
				  
				  System.out.println(r);
				  try {
					  
					  
					  /*!!!IMPORTANT!!!
					   * ------------------------------------------------------------------------------------
					   * This is where the parsing happens, for bug testing these will be the most important lines
					   * to check. Specifically look at the line where the parsing happens.
					   * -------------------------------------------------------------------------------------
					   */
					BufferedReader in = new BufferedReader(new FileReader(file));
					
					txt.setText("");
					
					String strToParse = "";
					
					
					//Copy Text from .txt
					while ((text = in.readLine()) != null) {
						strToParse += text + "\n";
	                    //txt.append(text);
	                    //txt.append("\n");
	                }
					
					
					//This is the line where the string is parsed
					
					String parsedText = "";
					
					//String parsedText = parser.parse("", strToParse);
					
					wrap w = new wrap(strToParse, 20);
					parsedText = w.wrapText();
					
					//System.out.println(parsedText);
					
					//Set the formattedText box to the parsed Text
					txt.setText(parsedText);
					
					//Close Text File
					in.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  return;
			  }
		});
		
			  
		
	}
	
	public String get_Text() {
		
		
		return inputText;
	}
	
	public void set_Text(String txt) {
		outputText = txt;
	}
	
	
}
