package view.grid;

import model.Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import model.Pawn;
import model.PawnColor;


public class Plateau extends JPanel {

	private static final long serialVersionUID = 6726708245444190460L;
	private GUISquare selected;
	private final int SIZE;
	private Game game;
	private GUISquare[][] board;

	public Plateau(Game g){

		this.setPreferredSize(new Dimension(600,600));
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#402b10"), 10));
		this.game = g;
		Lanceur.turn.setText("   "+this.game.getCurrent().getName()+", it's your turn !");
		this.SIZE = this.game.getSize();
		this.board = new GUISquare[this.SIZE][this.SIZE];
		this.setLayout(new GridLayout(this.SIZE, this.SIZE));
		for(int i=0; i<this.SIZE; i++){
			for(int j=0; j<this.SIZE; j++){
				if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
					this.addSquare(Color.BLACK, j, i);
				}
				else{
					this.addSquare(Color.WHITE, j, i);
				}
			}
		}
		init();
	}

	private void addSquare(Color c, int x, int y){
		GUISquare square = new GUISquare(c);
		square.addMouseListener(new ListenerCase(square, this, this.game));
		this.add(square);
		this.board[y][x] = square;
	}

	public void update() {
		System.out.println("update");
		for (int j=0 ; j<this.SIZE ; j++) {
			for (int i=0 ; i<this.SIZE ; i++) {
				this.board[j][i].removeAll();
			}
		}
		this.validate();
		init();
		this.revalidate();
    	this.repaint();
	}

	private void init(){
		for (Pawn p : this.game.getPawnList()) {
			GUIPawn pion;
			if (p.getColor() == PawnColor.WHITE) {
				pion = new GUIPawn(PawnColor.WHITE);
			}
			else if (p.getColor() == PawnColor.BLACK) {
				pion = new GUIPawn(PawnColor.BLACK);
			}
			else {
				pion = new GUIPawn(PawnColor.ZEN);
			}
			pion.addMouseListener(new ListenerPion(pion, this, this.game));
			this.board[p.getYPos()][p.getXPos()].add(pion);
		}
	}

	public void afficherPossibilites(GUIPawn p){

	}

	public void selectSquare(GUISquare square){
		this.selected = square;
		this.selected.select();
	}
	public void selectSquare(GUIPawn pawn){

		int[] coordinates = getGUIPawnCoordinates(pawn);
		int[] coordinates_bis;

		for (int j=0 ; j<this.SIZE ; j++) {
			for (int i=0 ; i<this.SIZE ; i++) {
				coordinates_bis = getGUISquareCoordinates(this.board[j][i]);
				if (coordinates[0]==coordinates_bis[0] && coordinates[1]==coordinates_bis[1]) {
					this.selected = this.board[j][i];
				}
			}
		}
		this.selected.select();
	}

	public void deselect() {
		this.selected.initCouleur();
		this.selected = null;
	}

	public void deplacer(GUISquare case1){

	}


	public boolean isOneSelected() {
		
		boolean ret = true;
		if (this.selected == null) {
			ret = false;
		}

		return ret;
		
	}

	public GUISquare getSelected() {
		return this.selected;
	}

	public int[] getGUISquareCoordinates(GUISquare square) {

		int[] ret = {-1, -1};

		for (int j=0 ; j<this.SIZE ; j++) {
			for (int i=0 ; i<this.SIZE ; i++) {
				if (this.board[j][i] == square) {
					ret[0] = i;
					ret[1] = j;
				}
			}
		}

		return ret;
	}

	public int[] getGUIPawnCoordinates(GUIPawn pawn) {

		int[] ret = {-1, -1};

		for (int j=0 ; j<this.SIZE ; j++) {
			for (int i=0 ; i<this.SIZE ; i++) {
				if (this.board[j][i].getComponents().length == 1 && this.board[j][i].getComponents()[0] == pawn) {
					ret[0] = i;
					ret[1] = j;
				}
			}
		}

		return ret;
	}
}
