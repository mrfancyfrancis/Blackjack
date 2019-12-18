package View;

import javax.swing.JPanel;

import Controller.ViewFunctions;
import Model.Hand;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	final int[] s1xy = {6,6};
	final int[] s2xy = {6,289};
	final int x_motion = 97;
	JLabel[] p1;
	JLabel[] p2;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MainPanel() 
	{
		setBorder(UIManager.getBorder("Button.border"));
		setBackground(new Color(102, 204, 0));
		setLayout(null);
		/*
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(ViewFunctions.resizeImage("Images//Cards//red_back.png", 72, 108));
		lblNewLabel.setBounds(6, 6, 72, 108);
		add(lblNewLabel);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(103, 6, 72, 108);
		add(label_1);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(200, 6, 72, 108);
		add(label_3);
		
		JLabel label = new JLabel("New label");
		label.setBounds(6, 289, 72, 108);
		add(label);
		*/
		p1 = new JLabel[5];
		for(int i = 0; i < p1.length; i++)
		{
			p1[i] = new JLabel("");
			p1[i].setIcon(ViewFunctions.resizeImage("Images//Cards//null.png", 72, 108));
			p1[i].setBounds(s1xy[0]+x_motion*i, s1xy[1], 72, 108);
			add(p1[i]);
		}
		p2 = new JLabel[5];
		for(int i = 0; i < p1.length; i++)
		{
			p2[i] = new JLabel("");
			p2[i].setIcon(ViewFunctions.resizeImage("Images//Cards//null.png", 72, 108));
			p2[i].setBounds(s2xy[0]+x_motion*i, s2xy[1], 72, 108);
			add(p2[i]);
		}
		
	}
	public void updateGUI(Hand p1, Hand p2)
	{
		for(int i = 0; i < 5; i++)
		{
			if(p1.cards[i] == null)
				this.p1[i].setIcon(ViewFunctions.resizeImage("Images//Cards//null.png", 72, 108));
			else
				this.p1[i].setIcon(ViewFunctions.resizeImage("Images//Cards//red_back.png", 72, 108));
			if(p2.cards[i] == null)
				this.p2[i].setIcon(ViewFunctions.resizeImage("Images//Cards//null.png", 72, 108));
			else
				this.p2[i].setIcon(ViewFunctions.resizeImage("Images//Cards//"+p2.cards[i].getCard()+".png", 72, 108));
		}
		revalidate();
		repaint();
	}
	public void showOpponentGUI(Hand p1)
	{
		for(int i = 0; i < 5; i++)
		{
			if(p1.cards[i] == null)
				this.p1[i].setIcon(ViewFunctions.resizeImage("Images//Cards//null.png", 72, 108));
			else
				this.p1[i].setIcon(ViewFunctions.resizeImage("Images//Cards//"+p1.cards[i].getCard()+".png", 72, 108));
		}	
		revalidate();
		repaint();
	}
}
