package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import model.Game;
import model.Mode;


public class ListenerCase extends MouseAdapter{
	
	private GUISquare square;
	private Plateau plateau;
	private Game game;

	
	public ListenerCase(GUISquare square, Plateau plateau, Game game) {
		super();
		this.square = square;
		this.plateau = plateau;
		this.game = game;
	}


	public void mousePressed(MouseEvent arg0) {

		if (this.plateau.isOneSelected()) {

			int xP = this.plateau.getGUISquareCoordinates(this.plateau.getSelected())[0];
			int yP = this.plateau.getGUISquareCoordinates(this.plateau.getSelected())[1];
			int x = this.plateau.getGUISquareCoordinates(this.square)[0];
			int y = this.plateau.getGUISquareCoordinates(this.square)[1];
			System.out.println("TRYING : "+xP+","+yP+" to "+x+","+y);
			boolean made = this.game.readMove(xP, yP, x, y);
			if (made) {
				this.plateau.update();
				this.plateau.deselect();
				this.game.changePlayer();
			}
			if (this.game.getMode() == Mode.HA && this.game.getCurrent() == this.game.getPlayer2()) {
				this.game.readMove(xP, yP, x, y);
				this.plateau.update();
				this.plateau.deselect();
				this.game.changePlayer();
			}

		}
	}

}
