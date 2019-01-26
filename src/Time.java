import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Timer;

public class Time {
	
	private Timer timer;
	private double time = 0;
	private int score;
	
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString(Double.toString(time) + " score: " + score, 20, 35); // displays the time on the screen
	}
	
	public void update() {
		time += .1; // increases time by .1 every time timer goes off
	}

	public Timer getTimer() {
		return timer;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	

}
