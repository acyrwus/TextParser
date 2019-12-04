package textParser;

public class left extends align {
	//String text;
	
	public left(String inText, int inMax, boolean inSpace) {
		super(inText, inMax, inSpace);
	}
	
	public String leftOut() { //builds output lines
		
		
		String buildStr = "";
		
		for(String temp : this.splitLines(text)) {
			for (String word : this.splitWord(temp)) { //build string with words
				buildStr = buildStr + "" + word + " ";
				
			}
			buildStr = buildStr.concat("\n");
			if (space) //if double spaced 
				buildStr = buildStr.concat("\n");
		}
		
		return buildStr;
	}
	
}
