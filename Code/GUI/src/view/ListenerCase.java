package view;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

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
			boolean made = this.game.readMove(xP, yP, x, y);
			if (made) {
				this.plateau.update();
				this.game.changePlayer();
			}
			this.checkWinner();
			if (this.game.getMode() == Mode.HA && this.game.getCurrent() == this.game.getPlayer2()) {
				this.game.readMove(xP, yP, x, y);
				this.plateau.update();
				this.game.changePlayer();
			}
			this.checkWinner();
			this.plateau.deselect();
			Lanceur.turn.setText("   "+this.game.getCurrent().getName()+", it's your turn !");
			

		}
		else {
			this.plateau.selectSquare(this.square);
		}
	}

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
