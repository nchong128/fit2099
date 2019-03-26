import javax.swing.JFrame;

public class MovingBallMain {

	public MovingBallMain() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Nicholas");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        for(int i = 0; i < 1000; i++) {
            game.moveBall();
            game.repaint();
            Thread.sleep(10);
        }
}
}
