package textParser;

public class title {
	String text;
	int lineMax;
	
	public title(String inText, int inMax) {
		String[] lines = inText.split("\\r?\\n");
		text = lines[0];
		//text = inText;
		lineMax = inMax;
	}
	
	public String titleOut() {
		String title = "";
		center ctr = new center(text, lineMax, false); //center text
		title = ctr.centerOut();
		
		//title = title.concat("\n");
		
		for (int i = 0; i < lineMax; i++) { //add dashes
			title = title.concat("-");					
		}
		
		title = title.concat("\n");
		
		return title;
	}
}
