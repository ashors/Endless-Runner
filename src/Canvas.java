import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.Timer;


// this is the canvas for level1
public class Canvas extends JComponent implements MouseListener {
	
	private int score = 0;
	Character player = new Character();
	Level1 level1 = player.getLevel1();
	Time timer = new Time();
	
	public Canvas() {
		timer.setScore(score); // displays the correct score on the screen
		addMouseListener(this);
		// the following timer is for the level
		level1.setTimer((new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				level1.update();
				repaint();
			}
		})));
		level1.getTimer().start();
		timer.setTimer(new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				timer.update();
				repaint();
				level1.lives.getGameOver();
				if (player.getStopped() && player.getY() < player.getNextRect().y - 45) {
					player.setY(player.getNextRect().y - 45); // puts player at the correct height
				}
				if (player.getStopped() && player.getY() > player.getNextRect().y - 25) {
					player.setY(player.getNextRect().y - 45); // puts player in the right place
					level1.loseLife();
					score -= 20;
					timer.setScore(score);
				}
				if ((player.getIndex() % 3 ) == 1 && 225 < (player.getRectangle().x) && (player.getRectangle().x <  235) && player.getY() > (player.getRectangle().y - 100)) {
					level1.loseLife();
					// this subtracts a life when a player hits a spike
					score -= 50;
					timer.setScore(score);
				}
				if (level1.getLives() == 0) { // stops level if player runs out of lives
					level1.getTimer().stop();
					timer.getTimer().stop();
				}
				if (player.getY() > 540) {
					level1.loseLife(); // this makes game end if player falls into an abyss
					score -= 100;
					timer.setScore(score);
				}
				if (player.getIndex() % 3 == 0 && (205 > player.getY()) && (player.getY() > 175)) { // increases score if player hits a power up
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
		g.setColor(new Color(201, 249, 255));
		g.fillRect(0, 0, size.width, size.height);
		level1.draw(g);
		player.draw(g);
		timer.draw(g);
		//BACKGROUND
		g.setColor(Color.YELLOW);
		g.fillOval(800, 100,40, 40);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		player.reset();
		// the following timer allows the character to jump when the mouse is clicked
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
