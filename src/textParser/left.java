package textParser;

public class left extends align {
	//String text;
	
	public left(String inText, int inMax, boolean inSpace) {
		super(inText, inMax, inSpace);
	}
	
	public String leftOut() { //builds output lines
		
		int lineC = this.lineLen(text);
		String buildStr = "";
		
		for (int i = 0; i < lineC; i++) {
			String temp = this.splitStr(i, text); //get singular line
			
			for (String word : this.splitWord(temp)) { //build string with words
				buildStr = buildStr.concat(word);
				buildStr = buildStr.concat(" ");
			}
			if (space) //if double spaced 
				buildStr = buildStr.concat("\n");
		}
		
		return buildStr;
	}
	
}
