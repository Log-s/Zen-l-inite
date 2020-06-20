package view;

import model.Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


/**
 * class that handles the clickes on a pawn
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class ListenerPawn extends MouseAdapter {
	
	private Board board;
	private GUIPawn pawn;
	private Game game;
	
	/**
	 * Creates the listener
	 * @param pion  the pawn is applies to
	 * @param board the board the pawn is on
	 * @param game the current game instance
	 */
	public ListenerPawn(GUIPawn pion, Board board, Game game){
		this.board = board;
		this.pawn=pion;
		this.game = game;
	}

	/**
	 * Events when the mouse is pressed
	 * @param e Event instance (useless here)
	 */
	public void mousePressed(MouseEvent e) {

		if (!this.board.isOneSelected()) {

			if (this.game.getPawnOnSquare(this.board.getGUIPawnCoordinates(this.pawn)[0], this.board.getGUIPawnCoordinates(this.pawn)[1]) != null) {
				this.board.selectSquare(this.pawn);
			}

		}
		else if (this.board.isOneSelected()) {

			int xP = this.board.getGUISquareCoordinates(this.board.getSelected())[0];
			int yP = this.board.getGUISquareCoordinates(this.board.getSelected())[1];
			int x = this.board.getGUIPawnCoordinates(this.pawn)[0];
			int y = this.board.getGUIPawnCoordinates(this.pawn)[1];
			this.game.readMove(xP, yP, x, y);
			this.board.update();
			this.board.deselect();
			PlayPanel.turn.setText("   "+this.game.getCurrent().getName()+", it's your turn !");
		}
	}

}
