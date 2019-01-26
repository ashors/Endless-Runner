import java.awt.Color;
import java.awt.Graphics;

public class powerUp {
	
	private int x;
	private int y;
	boolean destroyed = false;
	
	public powerUp(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		if (destroyed == true) {
			g.setColor(new Color(201, 249, 255));
		}
		else {
			g.setColor(new Color(240, 51, 240));
		}
		g.fillOval(x, 200, 20, 20);
	}
	
	public void update() {
		x -= 7;
	}

}
