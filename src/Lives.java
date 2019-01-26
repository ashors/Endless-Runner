import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Lives {
	
	int num_lives = 5;
	boolean game_over = false;
	Heart l1 = new Heart(700, 50);
	Heart l2 = new Heart(750, 50);
	Heart l3 = new Heart(800, 50);
	Heart l4 = new Heart(850, 50);
	Heart l5 = new Heart(900, 50);
	
	public void draw(Graphics g) {
		if (num_lives == 5) {
			l1.draw(g);
			l2.draw(g);
			l3.draw(g);
			l4.draw(g);
			l5.draw(g);
		}
		else if (num_lives == 4) {
			l2.draw(g);
			l3.draw(g);
			l4.draw(g);
			l5.draw(g);
		}
		else if (num_lives == 3) {
			l3.draw(g);
			l4.draw(g);
			l5.draw(g);
		}
		else if (num_lives == 2) {
			l4.draw(g);
			l5.draw(g);
		}
		else if (num_lives == 1) {
			l5.draw(g);
		}
		else {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.PLAIN, 50));
			g.drawString("GAME OVER", 330, 300);
			game_over = true;
		}
	}
	
	public boolean getGameOver() {
		return game_over;
	}

}
