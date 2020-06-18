package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import model.Game;


public class ListenerPion extends MouseAdapter {
	
	private Plateau plateau;
	private GUIPawn pawn;
	private Game game;
	
	public ListenerPion(GUIPawn pion, Plateau plateau, Game game){
		this.plateau=plateau;
		this.pawn=pion;
		this.game = game;
	}

	public void mousePressed(MouseEvent arg0) {

		if (!this.plateau.isOneSelected()) {

			if (this.game.getPawnOnSquare(this.plateau.getGUIPawnCoordinates(this.pawn)[0], this.plateau.getGUIPawnCoordinates(this.pawn)[1]) != null) {
				this.plateau.selectSquare(this.pawn);
				System.out.println("SELECTED "+this.plateau.getGUIPawnCoordinates(this.pawn)[0]+","+this.plateau.getGUIPawnCoordinates(this.pawn)[1]);
			}

		}
		else if (this.plateau.isOneSelected()) {

			int xP = this.plateau.getGUISquareCoordinates(this.plateau.getSelected())[0];
			int yP = this.plateau.getGUISquareCoordinates(this.plateau.getSelected())[1];
			int x = this.plateau.getGUIPawnCoordinates(this.pawn)[0];
			int y = this.plateau.getGUIPawnCoordinates(this.pawn)[1];
			System.out.println("TRYING : "+xP+","+yP+" to "+x+","+y);
			this.game.readMove(xP, yP, x, y);
			this.plateau.update();
			this.plateau.deselect();
		}
	}

}
