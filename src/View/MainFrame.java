package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

import AI.Functions;
import Controller.GameFunctions;
import Controller.Runner;
import Controller.ViewFunctions;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7100419815175830650L;
	private JPanel contentPane;
	public JLabel lblvalue;
	private MainPanel panel = new MainPanel();
	static JButton btnDraw, btnStop;
	private JButton btnRestart;
	static JLabel lblStatus;
	private JLabel lblgames;
	private JLabel lblDataSize;

	/**
	 * Create the frame.
	 */
	public MainFrame(int iteration, int size) {
		GameFunctions gf = new GameFunctions();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(632, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 418, 620, 114);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnDraw = new JButton("Draw");
		btnDraw.setEnabled(false);
		btnDraw.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int oldx = GameFunctions.p2.countHands();
				gf.drawPlayer();
				panel.updateGUI(GameFunctions.p1, GameFunctions.p2);
				lblvalue.setText("Hand Value: "+GameFunctions.p2.countHands());
				gf.checkInstance(oldx,panel);
			}
		});
		btnDraw.setBounds(6, 6, 117, 29);
		panel_1.add(btnDraw);
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				gf.opponentTurn(panel);
			}
		});
		btnStop.setEnabled(false);
		btnStop.setBounds(6, 38, 117, 29);
		panel_1.add(btnStop);
		
		JButton btnStart = new JButton("Start Game");
		btnStart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				gf.startGame();
				panel.updateGUI(GameFunctions.p1, GameFunctions.p2);
				lblvalue.setText("Hand Value: "+GameFunctions.p2.countHands());
				gf.checkInstance(GameFunctions.p2.countHands(),panel);
				btnDraw.setEnabled(true);
				btnStop.setEnabled(true);
				btnStart.setEnabled(false);
			}
		});
		btnStart.setBounds(6, 79, 117, 29);
		panel_1.add(btnStart);
		
		lblvalue = new JLabel("Hand Value: ");
		lblvalue.setBounds(135, 11, 124, 16);
		panel_1.add(lblvalue);
		
		btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runner.restartGame();
			}
		});
		btnRestart.setBounds(429, 79, 117, 29);
		panel_1.add(btnRestart);
		
		lblgames = new JLabel("Games Played: "+Integer.toString(iteration));
		lblgames.setBounds(429, 38, 185, 16);
		panel_1.add(lblgames);
		
		lblDataSize = new JLabel("Data Size: "+Integer.toString(size));
		lblDataSize.setBounds(429, 11, 185, 16);
		panel_1.add(lblDataSize);
		panel.setBounds(6, 6, 620, 400);
		contentPane.add(panel);
		
		lblStatus = new JLabel("New label");
		lblStatus.setBounds(6, 127, 608, 114);
		panel.add(lblStatus);
		lblStatus.setFont(new Font("Arial Black", Font.BOLD, 70));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setVisible(false);
	}
	public static void offControls()
	{
		btnDraw.setEnabled(false);
		btnStop.setEnabled(false);
	}
	public static void displayMessage(String msg)
	{
		lblStatus.setText(msg);
		lblStatus.setVisible(true);
	}
}
