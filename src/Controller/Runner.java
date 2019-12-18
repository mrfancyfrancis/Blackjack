package Controller;
import AI.Functions;
import View.MainFrame;
public class Runner 
{
	static MainFrame frame;
	public static int iterations = 0;
	public static void main(String[] args) 
	{
		openGame();
	}
	public static void openGame()
	{
		try {
			frame = new MainFrame(iterations,Functions.getDataSize());
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		iterations++;
	}
	public static void closeGame()
	{
		frame.setVisible(false);
		frame.dispose();
		frame = null;
	}
	public static void restartGame()
	{
		closeGame();
		GameFunctions.restart();
		openGame();
	}
}
