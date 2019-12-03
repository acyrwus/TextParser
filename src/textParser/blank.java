package textParser;

public class blank {
	int num;
	
	public blank(int inNum) {
		num = inNum;
	}
	
	public String blankStr() {
		String out = "";
		
		for(int i = 0; i < num; i++) {
			out += "\n";
		}
		
		return out;
	}
}
