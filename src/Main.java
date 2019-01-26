/* Anna Shors
 * ashors
 * Project 4
 * MW 10:25 Lab
 * I did not collaborate with anyone on this assignment.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JFrame {
	
	double time = 0;
	private Timer timer;
	
	public Main() {
		JFrame frame = new JFrame("Level 1");
		Canvas can = new Canvas();
		frame.add(can);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 600);
		frame.setVisible(true);
		timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time += .1;
				if (time >= 19) { // starts level 2 after 19 seconds
					JFrame frame2 = new JFrame("Level 2");
					Canvas2 can2 = new Canvas2();
					frame2.add(can2);
					frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame2.setSize(1000, 600);
					frame2.setVisible(true);
					timer.stop();
				}
			}	
		});
		timer.start();
	}
	
	public static void main (String[] args){
		new Main();
	}


}