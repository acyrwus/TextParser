package textParser;

public class equal extends align {

	public equal(String inText, int inMax, boolean inSpace) {
		super(inText, inMax, inSpace);
	}
	
	public String equalOut() { //builds output lines
			
		String buildStr = "";
		
		for(String temp : this.splitLines(text)) {
			String buildLine = "";
			
			int charDiff = lineMax - temp.length();
			
			String[] words = this.splitWord(temp);
			int wordsNum = words.length;
			
			double spaceVal = charDiff/(wordsNum-1) + 2; //calculate correct number of spaces
			spaceVal = Math.ceil(spaceVal);
			
			buildLine = buildLine + words[0];
			
			for (int i = 1; i < wordsNum; i++) {
				for (int j = 0; j < spaceVal; j++)
					buildLine = buildLine.concat(" ");
				buildLine = buildLine + "" + words[i];
			}
			
			/*for (String word : words) { //build string with words
				buildLine = buildLine + "" + word;
				for (int j = 0; j < spaceVal; j++)
					buildLine = buildLine.concat(" ");
			}*/
			
			
			buildLine = buildLine.concat("\n");
			if (space) //if double spaced 
				buildLine = buildLine.concat("\n");
			
			buildStr = buildStr.concat(buildLine); //add line to total string
		}
		
		return buildStr;
	}
}
