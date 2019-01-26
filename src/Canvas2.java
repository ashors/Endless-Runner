import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.Timer;


// this is the canvas for level 2. All code is the same, with the exception of the draw method,
// which changes the colors of the level.
public class Canvas2 extends JComponent implements MouseListener {
	
	private int score = 0;
	Character2 player = new Character2();
	Level2 level2 = player.getLevel2();
	Time timer = new Time();
	
	public Canvas2() {
		timer.setScore(score);
		addMouseListener(this);
		level2.setTimer((new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				level2.update();
				repaint();
			}
		})));
		level2.getTimer().start();
		timer.setTimer(new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				timer.update();
				repaint();
				level2.lives.getGameOver();
				if (player.getStopped() && player.getY() < player.getNextRect().y - 45) {
					player.setY(player.getNextRect().y - 45);
				}
				if (player.getStopped() && player.getY() > player.getNextRect().y - 25) {
					player.setY(player.getNextRect().y - 45); // puts player in the right place
					level2.loseLife();
					score -= 20;
					timer.setScore(score);
				}
				if ((player.getIndex() % 3 ) == 1 && 225 < (player.getRectangle().x) && (player.getRectangle().x <  235) && player.getY() > (player.getRectangle().y - 100)) {
					level2.loseLife();
					// this subtracts a life when a player hits a spike
					score -= 50;
					timer.setScore(score);
				}
				if (level2.getLives() == 0) {
					level2.getTimer().stop();
					timer.getTimer().stop();
				}
				if (player.getY() > 540) {
					level2.loseLife(); // this makes game end if player falls into an abyss
					score -= 100;
					timer.setScore(score);
				}
				if (player.getIndex() % 3 == 0 && /*200 < (player.getRectangle().x) && (player.getRectangle().x < 260) &&*/ (205 > player.getY()) && (player.getY() > 175)) {
					score += 200;
					timer.setScore(score);
				}
			}
		}));
		timer.getTimer().start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension size = getSize();
		g.setColor(new Color(240, 203, 223));
		g.fillRect(0, 0, size.width, size.height);
		level2.draw(g);
		player.draw(g);
		timer.draw(g);
		//BACKGROUND
		g.setColor(new Color(236, 237, 255));
		g.fillOval(800, 100, 40, 40);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		player.reset();
		player.setTimer((new Timer(25, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.update();
				repaint();
			}
		
		})));
		player.getTimer().start();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
	}

}
