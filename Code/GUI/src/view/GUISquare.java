package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class GUISquare extends JPanel {
	
	private static final long serialVersionUID = -1839026893240660968L;
	
	private Color color;
	private boolean selectionnee;

	public GUISquare(Color c){
		this.setLayout(new GridLayout(1,0));
		this.color=c;
		initCouleur();
	}

	public Color getCouleur() {
		return this.color;
	}

	public boolean isSelectionnee() {
		return selectionnee;
	}

	public void setSelectionnee(boolean selectionnee) {
		this.selectionnee = selectionnee;
		if(selectionnee){
			setBackground(Color.BLUE);
		}
		else {
			initCouleur();
		}
	}
	
	public void initCouleur(){
		if (this.color == Color.WHITE) {
			setBackground(Color.LIGHT_GRAY);
		}
		else {
			setBackground(Color.DARK_GRAY);
		}
	}

	public void select() {
		this.setBackground(Color.BLUE);
	}
}
