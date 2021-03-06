import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ImpossibleDial extends JPanel implements ActionListener {

	static JFrame frame = new JFrame("Impossible Dial");

	public static int centerX1 = 250;
	public static int centerY1 = 273;
	public static int topCenterX2 = 250;
	public static int topCenterY2 = 315;

	static ImpossibleDial ID = new ImpossibleDial();

	private static double angle = 140;

	static double direction = 1.02;
	static double speed = 1.03;

	static boolean gamePlay = true;
	static boolean biggerScore = false;

	Timer timer;

	public ImpossibleDial() {
		timer = new Timer(10, this);
		timer.start();
		setBackground(Color.WHITE);
	}

	public static int score = 0;
	static String displayedScore = Integer.toString(score);

	static Color blue = new Color(28, 144, 255);
	static Color green = new Color(69, 174, 112);
	static Color yellow = new Color(237, 228, 29);
	static Color red = new Color(240, 51, 93);

	static Random rand = new Random();
	static int randomColor = rand.nextInt(4) + 0;
	static Color[] colors = { blue, green, yellow, red };

	static Color actualColor = colors[randomColor];

	static ArrayList<Integer> colorCheck = new ArrayList<Integer>();

	// make a for loop that makes it so that the same color does not reapeat

	int k = 225;

	public void paint(Graphics g) {
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(10));
		super.paint(g);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Bebas Neue", Font.PLAIN, 80));

		g2d.setColor(green);
		g2d.drawArc(100, 110, 300, 300, 90 - k, 90);
		// green arc

		g2d.setColor(blue);
		g2d.drawArc(100, 110, 300, 300, 0 - k, 90);
		// blue arc

		g2d.setColor(yellow);
		g2d.drawArc(100, 110, 300, 300, 180 - k, 90);
		// yellow arc

		g2d.setColor(red);
		g2d.drawArc(100, 110, 300, 300, 270 - k, 90);
		// red arc

		g2d.setColor(Color.black);

		if (score > 9) {

			g2d.drawString(displayedScore, 215, 75);
			biggerScore = true;
		} else
			g2d.drawString(displayedScore, 235, 75);

		g2d.setStroke(new BasicStroke(11.0f, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g2d.setColor(actualColor);

		g2d.drawLine((int) (centerX1 + 120 * Math.sin(Math.toRadians(angle))),
				(int) (centerY1 + 120 * Math.cos(Math.toRadians(angle))),
				centerX1, centerY1);

		g2d.rotate(angle);
	}

	public static void main(String[] args) throws InterruptedException {

		if (speed > 10) {
			speed = speed - .01;
		}
		frame.setVisible(true);
		frame.setSize(500, 490);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(ID);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		// correct placement of the key lister just need to fix static errors
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_R) {
					gamePlay = false;

				}

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					direction *= -1 * speed;
					// { blue, green, yellow, red };
					if (actualColor == red) {
						if (angle >= 140 && angle <= 220) {
							System.out.println("FDSAFAS");
							score++;
							randomColor = rand.nextInt(4) + 0;
							if (randomColor == 3) {
								randomColor = 1;
							}
							actualColor = colors[randomColor];
							// colorCheck.add(Integer.valueOf(actualColor));
							displayedScore = String.valueOf(score);
						} else {
							gamePlay = false;
						}
					} else

					if (actualColor == yellow) {

						if (angle >= 50 && angle <= 135) {
							score++;
							randomColor = rand.nextInt(4) + 0;
							if (randomColor == 2) {
								randomColor = 1;
							}
							actualColor = colors[randomColor];
							displayedScore = String.valueOf(score);
						} else {
							gamePlay = false;
						}
					} else

					if ((actualColor == green)) {

						if (angle >= 315 || angle <= 45) {
							score++;
							randomColor = rand.nextInt(4) + 0;
							if (randomColor == 1) {
								randomColor = 2;
							}
							actualColor = colors[randomColor];
							displayedScore = String.valueOf(score);
						} else {
							gamePlay = false;
						}

					} else if ((actualColor == blue)) {
						score++;
						if (angle >= 230 && angle <= 310) {

							randomColor = rand.nextInt(4) + 0;
							if (randomColor == 0) {
								randomColor = 3;
							}
							actualColor = colors[randomColor];
							displayedScore = String.valueOf(score);
						} else {
							gamePlay = false;
						}

					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (gamePlay == true) {

			if (angle > 360) {
				angle = 0;
			}
			if (angle < 0) {
				angle = 360;
			}

			angle += direction;
			System.out.println(angle);
			ID.repaint();
		}

	}

}
