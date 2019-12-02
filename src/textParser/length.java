package textParser;

public class length 
{
	String text;
	int lineLength;
	
	public length(String inText, int inLineLength)
	{
		text = inText;
		lineLength = inLineLength;
	}
	
	public String changeLineLength()
	{	
		
		
		String toFormat = text;
		
		if(text.length() > lineLength)
		{
			int howMany = text.length() / lineLength;
			int start = 0;
			int end = lineLength;
			
			for (int i = 0; i < howMany; i++)
			{
				if(i < (howMany - 1))
				{
					System.out.println(toFormat.substring(start, end));
				}
				else
				{
					System.out.println(toFormat.substring(start));
				}
				
				start += lineLength;
				end += lineLength;
			}
		}
		return toFormat;
		
	}
}
