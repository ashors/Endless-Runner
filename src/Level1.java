import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class Level1 {
	
	private Timer timer;
	private ArrayList<Rectangle> rects = new ArrayList<>(); // add rectangles to array list, and in draw method, cycle
											   // through each rectangle and color each one!!!
	Lives lives = new Lives();
	
	public Level1() {
		int l = 0;
		Random rand = new Random();
		for (int i = 0; i < 20; i++) {
			int y = rand.nextInt(300) + 300; // gives a y value between 300 and 600
			rects.add(new Rectangle(l, y, 150, y)); // adds rectangle to array
			l += 150;
		}
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < 20; i++) {
			Rectangle r = rects.get(i); // cycles through each rectangle in array and draws it
			g.setColor(new Color(20, 199, 180));
			g.fillRect(r.x, r.y, 150, 600);
			g.setColor(new Color(132, 54, 20));
			g.fillRect(r.x, r.y, 150, 20);
			if (i % 3 == 0) { // draws hazards
				Hazard hazard = new Hazard(r.x + 50, r.y);
				hazard.draw(g);
			} 
			if (i % 3 == 2) { // draws power ups
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
			r.x -= 7.5;
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
	
	public boolean getGame() {
		return lives.game_over;
	}
	
	public void setGame(boolean b) {
		lives.game_over = b;
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
