import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.Timer;


// this is the character class for level 2. all code is the same as character class
public class Character2 {
	
	private int x;
	private int y;
	private int velocity;
	private int num = 0;
	private Timer timer;
	private Level2 level2 = new Level2();
	private ArrayList<Rectangle> rects = level2.getList();
	int r = 0;
	private boolean stopped = true; // so I can see if the timer is stopped
	
	public Character2() {
		
		Rectangle rect = getRectangle();
		velocity = -20;
		x = 150;
		y = rect.y - 20;
		
	}
	
	public Rectangle getRectangle() {
		for (int i = 0; i < 20; i++) {
			int rectX = level2.getList().get(i).x;
			if (30 <= rectX && rectX <= 330){
				r = i;
			}
		}
		Rectangle rect = rects.get(r);
		return rect;
	}
	
	public Rectangle getNextRect() {
		for (int i = 0; i < 20; i++) {
			int rectX = level2.getList().get(i).x;
			if (30 <= rectX && rectX <= 330){
				r = i;
			}
		}
		Rectangle rect = rects.get(r - 1);
		return rect;
	}
	
	public int getIndex() {
		for (int i = 0; i < 20; i++) {
			int rectX = level2.getList().get(i).x;
			if (30 <= rectX && rectX <= 330){
				r = i;
			}
		}
		return r;
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(133, 55, 235));
		g.fillRect(x, y, 30, 50);
		g.setColor(new Color(93, 38, 165));
		g.drawRect(x, y, 30, 50);
	}
	
	public void update() {
		velocity += 1;
		y += y * velocity / 100;
		num += 1;
		stopped = false;
		if (num >= 40) {
			timer.stop();
			stopped = true;
		}
	}
	
	public void reset() {
		rects = level2.getList();
		Rectangle rect = getRectangle();
		velocity = -20;
		y = rect.y - 20;
		num = 0;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public int getVelocity() {
		return velocity;
	}
	
	public void setVelocity(int v) {
		velocity = v;
	}
	
	public Timer getTimer() {
		return timer;
	}
	
	public void setTimer (Timer timer) {
		this.timer = timer;
	}

	public Level2 getLevel2() {
		return level2;
	}

	public int getY() {
		return y;
	}
	
	public boolean getStopped() {
		return stopped;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}