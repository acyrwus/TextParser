package textParser;

public class right extends align{
	
	public right(String inText, int inMax, boolean inSpace) {
		super(inText, inMax, inSpace);
	}
	
	public String rightOut() { //builds output lines
	
		//int lineC = this.lineLen(text);
		String buildStr = "";
		
		/*for (int i = 0; i < lineC; i++) {
			String temp = this.splitStr(i, text); //get singular line
			String buildLine = "";
			
			for (String word : this.splitWord(temp)) { //build string with words
				buildLine = buildLine.concat(word);
				buildLine = buildLine.concat(" ");
			}
			
			int charC = buildLine.length();
			String spaceStr = "";
			
			for (int j = 0; j < lineMax - charC; j++) { //add spaces to a string
				spaceStr = spaceStr.concat(" ");
			}
			
			buildLine = spaceStr.concat(buildLine); //concat spaces to string
			
			if (space) //if double spaced 
				buildLine = buildLine.concat("\n");
			
			buildStr = buildStr.concat(buildLine); //add line to total string
		}*/
		
		for(String temp : this.splitLines(text)) {
			String buildLine = "";
			for (String word : this.splitWord(temp)) { //build string with words
				buildLine = buildLine + "" + word + " ";
				
			}
			
			int charC = buildLine.length();
			String spaceStr = "";
			
			for (int j = 0; j < lineMax - charC; j++) { //add spaces to a string
				spaceStr = spaceStr.concat(" ");
			}
			
			buildLine = spaceStr.concat(buildLine); //concat spaces to string
			
			buildLine = buildLine.concat("\n");
			if (space) //if double spaced 
				buildLine = buildLine.concat("\n");
			
			buildStr = buildStr.concat(buildLine); //add line to total string
		}
		
		return buildStr;
	}
}
