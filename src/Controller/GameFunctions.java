package Controller;

import javax.swing.JOptionPane;

import AI.Functions;
import Model.Deck;
import Model.Hand;
import View.MainFrame;
import View.MainPanel;

public class GameFunctions 
{
	public static Deck d = new Deck();
	public static Hand p1 = new Hand();
	public static Hand p2 = new Hand();
	public static void restart()
	{
		d = new Deck();
		p1 = new Hand();
		p2 = new Hand();
	}
	public void startGame()
	{
		d.Shuffle();
		Functions.initializeData();
		for(int i = 0; i < 2; i++)
		{
			p1.addCard(d.pop());
			p2.addCard(d.pop());
		}
	}
	public static void drawPlayer()
	{
		p2.addCard(d.pop());
	}
	public void checkInstance(int x, MainPanel panel)
	{
		System.out.println("Estimation");
		System.out.println(p2.countHands()+" "+Functions.predict(p2.countHands()));
		if(p2.countHands() == 21)
		{
			//Winner
			Functions.addData(x,15);
			MainFrame.offControls();
			analyzeGame(panel);
		}
		else if(p2.countHands() > 21)
		{
			//Loser
			Functions.addData(x,-15);
			MainFrame.offControls();
			analyzeGame(panel);
		}
		else if(p2.size() < 3)
		{
			//Functions.addData(x,15);
		}
		if(p2.size() == 5)
		{
			//opponent turn
			opponentTurn(panel);
		}
	}
	public void drawOpponent(MainPanel panel)
	{
		p1.addCard(d.pop());
		panel.updateGUI(GameFunctions.p1, GameFunctions.p2);
	}
	public void analyzeGame(MainPanel panel)
	{
		//ViewFunctions.pauseTime(1500,"Analyze Cards");
		panel.showOpponentGUI(p1);
		String message = "";
		if(p2.countHands() > 21)
		{
			message = "Opponent Wins";
		}
		else if(p1.countHands() > 21)
		{
			message = "Player Wins";
		}
		else if(p1.countHands() == p2.countHands())
		{
			//tie
			message = "Tie";
		}
		else if(p2.countHands() > p1.countHands())
		{
			message = "Player Wins";
		}
		else if(p1.countHands() > p2.countHands())
		{
			message = "Opponent Wins";
		}
		MainFrame.displayMessage(message);
	}
	public void opponentTurn(MainPanel panel)
	{
		ViewFunctions.pauseTime(500,"Opponent Turn");
		MainFrame.offControls();
		while(Functions.decision() && p1.size() < 5)
		{
			int oldx = p1.countHands();
			drawOpponent(panel);
			if(Functions.decision())
				Functions.addData(oldx,15);
			else
				Functions.addData(oldx, -15);
			panel.updateGUI(p1, p2);
			ViewFunctions.pauseTime(1125,"Drawing Card");
			System.out.println("Estimation");
			System.out.println(p1.countHands()+" "+Functions.predict(p1.countHands()));
			System.out.println("Display Data");
			Functions.displayData();
		}
		analyzeGame(panel);
	}
}
