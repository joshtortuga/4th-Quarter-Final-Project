import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class ImpossibleDial extends JPanel implements ActionListener  {

	static JFrame frame = new JFrame ("Impossible Dial");

	public static int centerX1 = 250;
	public static int centerY1 = 273;
	public static int topCenterX2 = 250;
	public static int topCenterY2 = 130;
	static ImpossibleDial ID = new ImpossibleDial();
	private double angle = 170;

	static Random rand = new Random (3);


	static double direction = 1.02;
	static double speed = 1.03;



	Timer timer;

	public ImpossibleDial() {
		timer = new Timer(10, this);
		timer.start();
	}


	public static int score =  0;
	String displayedScore = Integer.toString(score);


	static Color blue = new Color(28,144,255);
	static Color green = new Color(69,174,112);
	static Color yellow = new Color(237,228,29);
	static Color red = new Color(240,51,93);


	Color[] colors = {blue,green,yellow,red};



	int k = 225;


	static boolean right = true;
	static boolean left = false;

	public void paint (Graphics g)  {
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(10));
		super.paint(g);
		int h = getHeight();
		int w = getWidth();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Bebas Neue", Font.PLAIN, 80));



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
		g2d.drawString(displayedScore, 235, 75);
		//score

		g2d.setStroke(new BasicStroke(11.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.setColor(red);
		//g2d.drawLine(topCenterX2,topCenterY2, centerX1,centerY1);
		g2d.drawLine((int)(centerX1+120*Math.sin(Math.toRadians(angle))), 
				(int)(centerY1+120*Math.cos(Math.toRadians(angle))),
				centerX1, centerY1);
		g2d.rotate(angle);
		//gameline



	}


	public static void main(String[] args) throws InterruptedException {

		if (speed > 10) {
			speed = speed -.01;		
		}



		frame.setVisible(true);
		frame.setSize(500,490);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(ID);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.addKeyListener(new KeyListener() {


			@Override
			public void keyTyped(KeyEvent e) {	
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_R) {

				}

				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					direction *= -1*speed;
					score++;
					System.out.println(score);

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}});

	}

	@Override
	public void actionPerformed (ActionEvent e) {

		angle += direction;
		ID.repaint();

	}



}
