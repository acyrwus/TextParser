package textParser;

import java.io.*;
import java.util.*;

import java.util.Arrays;



public class Parser {
	public int x;
	public char sign;
	public char op;
	public char start;
	public String count;
	private String outputString;
	private String commandList;
	private String stateCommands;
	private int lineLength;
	public String errors;
	

	public Parser() {
		x = 0;
		sign = ' ';
		op = ' ';
		start = ' ';
		count = " ";
		outputString = "";
		buildCommands();
	}
	
	private void buildCommands() {
		commandList = "nrlcewsdtpba";
		stateCommands = "rlceasd";
	}
	
	/* !!!IMPORTANT!!!
	 * ------------------------------------------------------------------------------------
	 * 
	 * Parser needs to return string of parsed text
	 * It will have to implement all the classes the commands with each case
	 * 
	 * -------------------------------------------------------------------------------------
	 */
	
	public String parse(String text) {
		//command class used for testing double space and single space
		//command c = new command();
		
		//Default Line Length
		lineLength = 80;
		int lineCount = 0;
		String finalOutput = "";
		
		String displayText = "";
		ArrayList<String> rawTextList = new ArrayList<String>();
		ArrayList<String> commandList= new ArrayList<String>();
		ArrayList<String> textList= new ArrayList<String>();
		
		ArrayList<String> tempList = new ArrayList<String>();
		
		
		boolean inspace = false;
		
		stringToList(rawTextList, text, lineLength);
		buildCommandAndTextList(rawTextList,commandList,textList);


		
		char cmd = 'z';
		char additional = 'z';
		char additional2 = 'z';

		String originalText = listToString(textList);
		
		String txtToParse = text;
		
		int lineNum = 0;
		

		//Line Counter
		int numberOfLines = 0;
		int firstLineIndex = 0;
		
		for(int currentCommand = 0; currentCommand < commandList.size(); currentCommand++) {
			String ccs = commandList.get(currentCommand);
			
			cmd = commandList.get(currentCommand).charAt(1);
			if(commandList.get(currentCommand).length() > 2) {
				additional = commandList.get(currentCommand).charAt(2);
				additional2 = commandList.get(currentCommand).charAt(3);
				System.out.println(ccs);
				lineNum = Character.getNumericValue(ccs.charAt(ccs.length()-1));
			}
			
			
			for(int i = 0; i < originalText.length(); i++) {
				if (originalText.charAt(i) == '\n') {
					numberOfLines++;
					if(numberOfLines == 1) {
						firstLineIndex = i+1;
					}
				}
				if(numberOfLines == lineNum) {
					txtToParse = originalText.substring(i+1, originalText.length());
					break;
				}
			}
			
			if(numberOfLines < lineNum) {
				txtToParse = "";
			}
			
			
			System.out.println("Parse Text Going in-----\n"+ txtToParse + "\n-------");
			
			switch (cmd) {
				case 'n':
					
					int count = 80;
					if(Character.isDigit(additional2)) {
						String numberString = new StringBuilder().append(additional).append(additional2).toString();
						count = Integer.parseInt(numberString);
					} else {
						count = Character.getNumericValue(additional);
					}
						
					
					
					//Find Necessary Iterations
					
					int charPerLineCounter = 0;
					StringBuilder stb = new StringBuilder(txtToParse);
					System.out.println("TEXT: " + stb.toString());
					
					lineLength = count;
					
					if(count < 100) {
						System.out.println("OUT");
						for(int i = 0; i < txtToParse.length(); i++) {
							if(txtToParse.charAt(i) == '\n') {
								charPerLineCounter = 0;
							} else {
								charPerLineCounter++;
							}
							if(charPerLineCounter >= count) {
								charPerLineCounter = 0;
								int j = i;
								while(stb.charAt(j) != ' ') {
									j--;
								}
								System.out.println("OUT");
								stb.setCharAt(j, '\n');
									
							}
						}
						txtToParse = stb.toString();
					
					
					} else if (x > 100) {
						errors += "Error: number of character per line should exceed 100\n";
						System.out.println("Error: number of character per line should exceed 100");
					}
					break;
		
				case 'r':
					right r = new right(txtToParse, lineLength, inspace);
				 	txtToParse = r.rightOut();
					break;
		
				case 'l':
					left l = new left(txtToParse, lineLength, inspace);
					txtToParse = l.leftOut();
					break;
		
				case 'c':
					center c = new center(txtToParse, lineLength, inspace);
					txtToParse = c.centerOut();
					break;
		
				case 'w':
					if (additional == '+') {
						wrap w = new wrap(txtToParse, lineLength);
						
						txtToParse = w.wrapText();
						

					} else if (additional == '-') {
		
					}
					break;
		
				case 'e':
					equal e = new equal(txtToParse,lineLength,inspace);
					txtToParse = e.equalOut();
					break;
		
				case 's':
					inspace = false;
					//c.commands('s', text);
					break;
		
				case 'd':
					inspace = true;
					//c.commands('d', text);
					break;
		
				case 't':
					//Get First Line
					
					
					String line = txtToParse.substring(0,firstLineIndex);
					
					System.out.println("FIRST LINE----\n" + line);
					title t = new title(txtToParse, lineLength);
					
					String newLine = t.titleOut();
					txtToParse = newLine + txtToParse.substring(firstLineIndex*3, txtToParse.length());
					break;
		
				case 'p':
					//x = Integer.parseInt(count);
					int indents = Character.getNumericValue(additional);
					indent para = new indent(txtToParse, indents);
					
					String pgraph = para.addsIndent();
					
					txtToParse = pgraph;
					
					break;
		
				case 'b':
					//x = Integer.parseInt(count);
					
					int blanks = Character.getNumericValue(additional);
					blank b = new blank(blanks);
					
					
					
					
					txtToParse = b.blankStr() + txtToParse;
					
					

					
					
					break;
		
				case 'a':
					int x = Character.getNumericValue(additional);
					if (x <= 2) {
						
						columns col = new columns(txtToParse, x, lineLength);
						
						//adjust columns doesn't return anything???
						//txtToParse = c.adjustColumns();
		
					} else if (x > 2) {
						errors += "Error: column size should not exceed 2\n";
					}
					break;
					
				
				
			}
			
			System.out.println("POST TEXT PARSE----\n" + txtToParse + "\n------");
			
			//Attach onto originalText and loop back up for new command
			numberOfLines=0;
			for(int i = 0;i < originalText.length(); i++) {
				if(originalText.charAt(i) == '\n') {
					numberOfLines++;
				}
				if(numberOfLines == lineNum) {
					originalText = originalText.substring(0,i+1) + txtToParse;
					break;
				}
			}
			
			if(numberOfLines < lineNum) {
				originalText += txtToParse;
			}
			
			numberOfLines = 0;
			
			System.out.println("POST TEXT PARSE MERGED WITH ORIG:---------\n" + originalText + "\n---------");
			
			//printList(textList);
			

		}
		
		//Decode Next Command
		
		finalOutput = originalText;
		
		System.out.println("\n" + finalOutput);
		return finalOutput;
	}
	
	
	public String nextCommand() {
		return "";
	}
	

	
	public void stringToList(ArrayList<String> arr, String input, int lineLength) {
		
		int currentCharIndex = 0;
		int currentCharArrayIndex = 0;
		int lineCount = 0;
		String carryover = "";
		
		String[] lines = input.split("\\r?\\n");
		
		for(String line : lines)
			if(line.length() <= lineLength) {
				arr.add(line);
			}
			else {
				arr.add(line.substring(0, lineLength));
			}
				
		
	}
	
	public String listToStringIndex(ArrayList<String> str, int index) {
		String out = "";
		for(int i = index; i < str.size(); i++)
			out += str.get(i) + "\n";
		
		return out;
	}
	
	public String listToString(ArrayList<String> str) {
		String out = "";
		for(String s: str)
			out += s.trim() + "\n";
		
		return out;
	}
	

	
	public String get_errors() {
		return errors;
	}
	

	public boolean isCommand(String str) {
		if(str.length() == 0)
			return false;
		
		if(str.charAt(0) == '-')
			if(commandList.indexOf(str.charAt(1)) != -1)
				return true;
		
		
		return false;
	}
	
	public void buildCommandAndTextList(ArrayList<String> original, ArrayList<String> cmdList, ArrayList<String> textList) {
		String previousLine = "";
		for(int i = 0; i < original.size(); i++) {
			
			String currentLine = original.get(i);
			
			if(isCommand(currentLine)) {
				if(isCommand(previousLine))
					cmdList.add(currentLine + " : " + (i-1));
				else
					cmdList.add(currentLine + " : " + (i));
				
				//textList.add("");
			} else {
				textList.add(currentLine);
				//cmdList.add("");
			}
			previousLine = currentLine; 
			
		}
	}
	
	
	public void printList(ArrayList<String> str) {
		System.out.print("PRINTLIST: \n" + listToString(str));
			
	}
	
	
	
}

