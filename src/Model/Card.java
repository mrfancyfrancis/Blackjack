package Model;

public class Card 
{
	public String face;
	public String value;
	public Card(String face, String value)
	{
		this.face = face;
		this.value = value;
	}
	public String getCard()
	{
		return value+face.charAt(0);
	}
	public int getValue()
	{
		if(value.equals("A"))
			return 1;
		if(value.equals("J") || value.equals("Q") || value.equals("K"))
		{
			return 10;
		}
		
		return Integer.parseInt(value);
	}
}
