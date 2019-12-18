package Controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import View.MainPanel;


public class ViewFunctions 
{
	public static ImageIcon resizeImage(String url, int w, int h)
	{
		Image image = new ImageIcon(url).getImage();
		image = getScaledImage(image,w,h);
		return new ImageIcon(image);
	}
	private static Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	public static void pauseTime(int ms, String msg)
	{
		try {
			System.out.println("Pausing time for ("+msg+")");
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 JOptionPane jmsg = new JOptionPane(msg, JOptionPane.WARNING_MESSAGE);
		    final JDialog dlg = jmsg.createDialog(msg);
		    dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		    new Thread(new Runnable() {
		      @Override
		      public void run() {
		        try {
		          Thread.sleep(50);
		        } catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		        dlg.setVisible(false);
		      }
		    }).start();
		    dlg.setVisible(true);
	}
}
