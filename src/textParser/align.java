package textParser;

public class align {
	String text;
	int lineMax;
	boolean space;
	
	
	public align(String inText, int inMax, boolean inSpace) {
		this.text = inText;
		this.lineMax = inMax;
		this.space = inSpace;
	}
	
	protected int lineLen(String inStr) { //gets number of lines in a given input string
		int count = 0;
		for (int i= 0; i < inStr.length(); i++) {
			if (inStr.charAt(i) == '\n') {
				count++;
			}
		}
		return count;
	}
	
	protected String splitStr(int lineNum, String inStr) { //splits input string by line
		
		
		if (lineNum == 0) {
			return inStr.substring(0,inStr.indexOf('\n'));
		}
		else {
			int count = 0;
			
			for (int i= 0; i < inStr.length(); i++) {
				if (inStr.charAt(i) == '\n') {
					count++;
					if (count == lineNum-1) {
						return (inStr.substring(i+1, inStr.indexOf('\n',i+1)));
					}
				}
			}
		}
		return null;
	}
	
	protected String[] splitWord(String inStr) {
		String[] arr = inStr.split(" ");
		return arr;
	}
	

}