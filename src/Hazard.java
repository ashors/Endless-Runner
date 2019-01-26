import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.Timer;

public class Hazard {
	
	private int x1, x2 , x3;
	private Timer timer;
	private int start;
	int y;
	
	public Hazard(int start, int y) {
		this.start = start;
		x1 = start;
		x2 = start + 10;
		x3 = start + 20;
		this.y = y;
	}
	
	public void draw(Graphics g) { // draws the spikes
		g.setColor(new Color(154, 154, 154));
		int[] X= {x1, x2, x3};
		int[] Y = {y, y - 100, y};
		g.fillPolygon(X, Y, 3);
	}
	
	public void update() {
		x1 -= 7;
		x2 -= 7;
		x3 -= 7;
	}
	
	public Timer getTimer() {
		return timer;
	}
	
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}
