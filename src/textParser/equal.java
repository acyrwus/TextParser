package textParser;

public class equal extends align {

	public equal(String inText, int inMax, boolean inSpace) {
		super(inText, inMax, inSpace);
	}
	
	public String equalOut() { //builds output lines
		
		int lineC = this.lineLen(text);
		String buildStr = "";
		
		for (int i = 0; i < lineC; i++) {
			String temp = this.splitStr(i, text); //get singular line
			String buildLine = "";
			
			int charDiff = lineMax - temp.length();
			
			String[] words = this.splitWord(temp);
			
			int spaceVal = charDiff/(words.length); //calculate correct number of spaces
			
			
			for (String word : words) { //build string with words
				buildLine = buildLine.concat(word);
				for (int j = 0; j < spaceVal; j++)
					buildLine = buildLine.concat(" ");
			}
			
			if (space) //if double spaced 
				buildLine = buildLine.concat("\n");
			
			buildStr = buildStr.concat(buildLine); //add line to total string
		}
		
		return buildStr;
	}
}
