package textParser;

import java.io.*;
import java.util.*;



public class Parser {
	public int x;
	public char sign;
	public char op;
	public char start;
	public String count;

	public Parser() {
		x = 0;
		sign = ' ';
		op = ' ';
		start = ' ';
		count = " ";
	}
	
	/* !!!IMPORTANT!!!
	 * ------------------------------------------------------------------------------------
	 * 
	 * Parser needs to return string of parsed text
	 * It will have to implement all the classes the commands with each case
	 * 
	 * -------------------------------------------------------------------------------------
	 */
	
	public String parse(String command, String text) {
		//command class used for testing double space and single space
		//command c = new command();
		if (command.charAt(0) == '-') 
		{
			start = command.charAt(0);
			op = command.charAt(1);
			count = command.replaceAll("[^0-9]", "");
		}

		switch (op) {
		case 'n':
			x = Integer.parseInt(count);
			if (x <= 100) {
			} else if (x > 100) {
				System.out.println("Error: number of character per line should exceed 100");
			}
			break;

		case 'r':
			break;

		case 'l':
			break;

		case 'c':
			break;

		case 'w':
			sign = command.charAt(3);
			if (sign == '+') {

			} else if (sign == '-') {

			}
			break;

		case 'e':
			break;

		case 's':
			//c.commands('s', text);
			break;

		case 'd':
			//c.commands('d', text);
			break;

		case 't':
			break;

		case 'p':
			x = Integer.parseInt(count);
			;
			break;

		case 'b':
			x = Integer.parseInt(count);
			;
			break;

		case 'a':
			x = Integer.parseInt(count);
			if (x <= 2) {

			} else if (x > 2) {
				System.out.println("Error: column size should not exceed 2");
			}
			break;
		}
		
		return "";
	}
	
	
}

