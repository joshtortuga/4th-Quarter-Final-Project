import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;


public class hu {

	public static void main(String[] args) {
		

		
		Color blue = new Color(28,144,255);
		Color green = new Color(69,174,112);
		Color yellow = new Color(237,228,29);
		Color red = new Color(240,51,93);
		
		Color[] colors = new Color[4];

	    //Initialize the values of the array
	    colors[0] = blue;
	    colors[1] = green;
	    colors[2] = yellow;
	    colors[3] = red;
	    
	 
	    Random rand = new Random();
	    int i1 = (rand.nextInt(1) +3 );
	    System.out.println(i1);

		
	   
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String score ="0";
		int num = Integer.parseInt(score);
	System.out.println(num);
		
		JFrame frame = new JFrame ("Impossible Dial");
		frame.setVisible(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.addKeyListener(new KeyListener() {


			@Override
			public void keyTyped(KeyEvent e) {	
			}

			@Override
			public void keyPressed(KeyEvent e) {
	

				if(e.getKeyCode() == KeyEvent.VK_SPACE) {

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}});

	 

}

}