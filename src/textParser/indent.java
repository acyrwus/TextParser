package textParser;

public class indent 
{
	String text;
	int spaces;
	
	public indent(String inText, int inSpaces)
	{
		text = inText;
		spaces = inSpaces;
	}
	
	public String addsIndent()
	{
		String out = "";
		
		for (int i = 0; i < spaces; i++)
		{
			out.concat(" ");
		}
		
		out.concat(text);
		
		return out;
	}

}
