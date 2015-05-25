import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;


public class hu {

	public static void main(String[] args) {
		

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