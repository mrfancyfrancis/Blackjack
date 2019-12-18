package Model;

public class Hand 
{
	int c = 0;
	public Card[] cards = new Card[5];
	public void addCard(Card c)
	{
		cards[this.c++] = c;
	}
	public int size()
	{
		return c;
	}
	public int countHands()
	{
		int v = 0;
		for(int i = 0; i < c; i++)
		{
			int t = cards[i].getValue();
			if(c <= 2 && t == 1)
				v+=11;
			else
				v+=t;
		}
		return v;
	}
}
