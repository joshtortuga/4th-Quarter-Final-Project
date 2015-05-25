import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ImpossibleDial extends JPanel {

	public static int center1 = 250;
	public static int center2 = 273;
	public static int topCenter1 = 250;
	public static int topCenter2 = 130;
	

	static String myString = "0";

	static int score = Integer.parseInt(myString);



	Color blue = new Color(28,144,255);
	Color green = new Color(69,174,112);
	Color yellow = new Color(237,228,29);
	Color red = new Color(240,51,93);


	int k = 225;


	static boolean right = true;
	static boolean left = false;

	public void paint(Graphics g)  {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(10));
		super.paint(g);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Bebas Neue", Font.PLAIN, 80));



		//x1 = x1 + (int) Math.sin(angle) + right;


		g2d.setColor(green);
		g2d.drawArc(100,110, 300,300,90-k,90) ;
		// green arc

		g2d.setColor(blue);
		g2d.drawArc(100,110,300,300,0-k,90);
		//blue arc


		g2d.setColor(yellow);
		g2d.drawArc(100,110,300,300,180-k,90) ;
		//yellow arc


		g2d.setColor(red);
		g2d.drawArc(100,110,300,300,270-k,90) ;
		//red arc

		g2d.setColor(Color.black);
		g2d.drawString(myString, 235, 75);
		//score

		
		g2d.setStroke(new BasicStroke(11.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.setColor(red);
		g2d.drawLine(topCenter1 ,topCenter2,center1,center2);
		
	
	
		

		//gameline


	}

	public static void main(String[] args) throws InterruptedException {

		ImpossibleDial ID = new ImpossibleDial();
		JFrame frame = new JFrame ("Impossible Dial");
		frame.setVisible(true);
		frame.setSize(500,490);
		frame.setResizable(false);
		frame.add(ID);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		while(true) {




		}

	}


}



