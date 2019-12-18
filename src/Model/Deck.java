package Model;

import java.util.Collections;
import java.util.Stack;

public class Deck extends Stack<Card>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Deck()
	{
		String[] flist = {"Spade","Heart","Clover","Diamond"};
		String[] vlist = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(String f: flist)
		{
			for(String v: vlist)
			{
				push( new Card(f,v));
			}
		}
	}
	public void Shuffle()
	{
		Collections.shuffle(this);
	}
}
