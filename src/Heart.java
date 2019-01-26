import java.awt.Color;
import java.awt.Graphics;

public class Heart {
	
	public int x;
	public int y;
	
	public Heart(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) { // creates hearts
		g.setColor(new Color(249, 109, 109));
		g.fillOval(x-10, y-5, 10, 10);
		g.fillOval(x, y-5, 10, 10);
		int[] xs = {x-10, x, x+10};
		int[] ys = {y+1, y + 17, y+1};
		g.fillPolygon(xs, ys, 3);
	}

}
