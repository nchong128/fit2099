import java.awt.LayoutManager;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/*
 * A simple programming which shows a ball moving across a window
 * 
 * Slightly modified from:
 * 
 * https://www.abeautifulsite.net/java-game-programming-for-beginners
 */

public class Game extends JPanel {

	 int x = 0;
	 int y = 0;
	    public void moveBall() {
	        x+=1;
	        y+=1;
	    }
	    @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	            RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.fillOval(x, y, 30, 30);
	    }
	    public Game() {
		// TODO Auto-generated constructor stub
	}

	public Game(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Game(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Game(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	
}
