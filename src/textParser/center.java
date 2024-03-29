package textParser;

public class center extends align {
	
	public center(String inText, int inMax, boolean inSpace) {
		super(inText, inMax, inSpace);
	}
	
	public String centerOut() { //builds output lines
		
		String buildStr = "";
		
		for(String temp : this.splitLines(text)) {
			String buildLine = "";
			for (String word : this.splitWord(temp)) { //build string with words
				buildLine = buildLine + "" + word + " ";
				
			}
			
			int charC = buildLine.length();
			String spaceStr = "";
			
			for (int j = 0; j < (lineMax - charC)/2; j++) { //add spaces to a string
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
