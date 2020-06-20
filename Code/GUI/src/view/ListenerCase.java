package view;

import model.Game;
import model.Mode;

import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * class that handles the clicks on a square
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class ListenerCase extends MouseAdapter{
	
	private GUISquare square;
	private Board board;
	private Game game;

	/**
	 * Creates the listener
	 * @param square the square it applies to
	 * @param board The board the square belongs to
	 * @param game The game instance 
	 */
	public ListenerCase(GUISquare square, Board board, Game game) {
		super();
		this.square = square;
		this.board = board;
		this.game = game;
	}


	/**
	 * Events when the mouse is pressed
	 * @param e Event instance (useless here)
	 */
	public void mousePressed(MouseEvent e) {

		if (this.board.isOneSelected()) {

			int xP = this.board.getGUISquareCoordinates(this.board.getSelected())[0];
			int yP = this.board.getGUISquareCoordinates(this.board.getSelected())[1];
			int x = this.board.getGUISquareCoordinates(this.square)[0];
			int y = this.board.getGUISquareCoordinates(this.square)[1];
			boolean made = this.game.readMove(xP, yP, x, y);
			if (made) {
				this.board.update();
				this.game.changePlayer();
			}
			this.checkWinner();
			if (this.game.getMode() == Mode.HA && this.game.getCurrent() == this.game.getPlayer2()) {
				this.game.readMove(xP, yP, x, y);
				this.board.update();
				this.game.changePlayer();
			}
			this.checkWinner();
			this.board.deselect();
			PlayPanel.turn.setText("   "+this.game.getCurrent().getName()+", it's your turn !");
			

		}
		else {
			this.board.selectSquare(this.square);
		}
	}

	/**
	 * Checks if there is a winner
	 */
	public void checkWinner() {
		if (this.game.isWon(this.game.getPlayer1()) && this.game.isWon(this.game.getPlayer2())) {
			JOptionPane.showMessageDialog(null, "Ouch ! It's a tie... You both fought well", "Congratulation !", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Tie");
			System.exit(0);
		}
		else if(this.game.isWon(this.game.getPlayer1())) {
			JOptionPane.showMessageDialog(null, this.game.getPlayer1().getName()+", you won !", "Congratulation !", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		else if (this.game.isWon(this.game.getPlayer2())) {
			JOptionPane.showMessageDialog(null, this.game.getPlayer2().getName()+", you won !", "Congratulation !", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

}
