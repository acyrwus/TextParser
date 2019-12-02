package textParser;

public class wrap {
	String text;
	int lineMax;
	
	public wrap(String inText, int inMax) {
		text = inText; lineMax = inMax;
	}
	
	public String wrapText() {
		
		text = text.replace("\n", " ");
		
		//Necessary for string operations
		StringBuilder stb = new StringBuilder(text);
		
		
		
		//Find Necessary Iterations
		int iter = text.length()/lineMax;
		
		
		//Loop through iterations
		for(int i = 0; i < iter; i++) {
			//CurrentElem to look at
			int currentElem = (lineMax)*(i+1);
			
			//If it is blank then add newline
			if(text.charAt(currentElem) == ' ')
				stb.setCharAt(currentElem, '\n');
			else {
				//Otherwise we need to find the most recent blank
				int characterDecrement = currentElem;
				
				while(characterDecrement > 0 && text.charAt(characterDecrement) != ' ') 
					characterDecrement--;
				
				//System.out.println(stb.toString());
				stb.setCharAt(characterDecrement, '\n');
				//System.out.println(stb.charAt(characterDecrement));
				
				
			}
		}
		text = stb.toString();
		System.out.println("\n\n" + text);
		
		//text = text.replaceAll("(.{"+lineMax+"})", "$1\n");

		return text;

	}
}
