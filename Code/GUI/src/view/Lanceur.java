package view;
import model.Game;

import javax.swing.JFrame;
import javax.swing.UIManager;


public class Lanceur {

	Plateau board;

	public Lanceur(Game g) {
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.macintosh.macintoshLookAndFeel");
		}
		catch(Exception e){}
		JFrame f = new JFrame();
		f.setSize(600, 600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board = new Plateau(g);
		f.add(board);
		f.setVisible(true);
	}

	public void update() {
		board.update();
	}


}
