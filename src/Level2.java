import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

// this is for level 2. Code is the same as level 1, but colors are different.
public class Level2 {
	
	private Timer timer;
	private ArrayList<Rectangle> rects = new ArrayList<>();
	Lives lives = new Lives();
	
	public Level2() {
		int l = 0;
		Random rand = new Random();
		for (int i = 0; i < 20; i++) {
			int y = rand.nextInt(300) + 300;
			rects.add(new Rectangle(l, y, 150, y));
			l += 150;
		}
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < 20; i++) {
			Rectangle r = rects.get(i);
			g.setColor(new Color(9, 34, 115));
			g.fillRect(r.x, r.y, 150, 600);
			g.setColor(new Color(197, 208, 245));
			g.fillRect(r.x, r.y, 150, 20);
			if (i % 3 == 0) {
				Hazard hazard = new Hazard(r.x + 50, r.y);
				hazard.draw(g);
			}
			if (i % 3 == 2) {
				powerUp power = new powerUp(r.x + 75, r.y - 200);
				power.draw(g);
			}
			lives.draw(g);
		}
	}
	
	
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	public Timer getTimer() {
		return timer;
	}

	public void update() {
		for (Rectangle r: rects) {
			r.x -= 10;
		}
	}
	
	public ArrayList<Rectangle> getList() {
		return rects;
	}
	
	public void loseLife() {
		lives.num_lives -= 1;
	}
	
	public int getLives() {
		return lives.num_lives;
	}
	
	public void reset() {
		int l = 0;
		Random rand = new Random();
		for (int i = 0; i < 20; i++) {
			int y = rand.nextInt(300) + 300;
			rects.add(new Rectangle(l, y, 150, y));
			l += 150;
		}
	}
}
