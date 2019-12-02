package textParser;

public class columns {
	
	String text;
	int numOfColumns;
	int lineLength;
	
	public columns(String inText, int inNumOfColumns, int inLineLength)
	{
		text = inText;
		numOfColumns = inNumOfColumns;
		lineLength = inLineLength;
	}
	
	public void adjustColumns()
	{
		if(numOfColumns == 1)
		{
			System.out.print(text);
		}
		else if (numOfColumns == 2)
		{
			int leftLength;
			int rightLength;
			int adjustedLength = lineLength / 2;
			
			String spaceInBetween = "          ";
			
			if(lineLength%2 == 1)
			{
				leftLength = adjustedLength + 1;
				rightLength = adjustedLength;
			}
			else
			{
				leftLength = adjustedLength;
				rightLength = adjustedLength;
			}
			
			int times = text.length() / (lineLength + 10);
			
			int startLeft = 0;
			int startRight = leftLength/2;
			int endLeft = leftLength;
			int endRight = startRight + rightLength;
			
			for(int i = 0; i < times; i++)
			{
				String withColumns = "";
				
				if (i < (times - 1))
				{
					withColumns.concat(text.substring(startLeft, endLeft));
					withColumns.concat(spaceInBetween);
					withColumns.concat(text.substring(startRight, endRight));
					System.out.println(withColumns);
				}
				else
				{
					withColumns.concat(text.substring(startLeft, endLeft));
					withColumns.concat(spaceInBetween);
					withColumns.concat(text.substring(startRight));
					System.out.println(withColumns);
				}
				
				startLeft += leftLength;
				startRight += rightLength;
				endLeft += leftLength;
				endRight += rightLength;
				
			}
				
		}
		
	}
	

}
