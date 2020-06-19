package view.grid;

import java.awt.Color;
import java.awt.Graphics;

import model.PawnColor;

import javax.swing.JPanel;


public class GUIPawn extends JPanel {

	private static final long serialVersionUID = 1436178861615738480L;

	private PawnColor couleur;


	public GUIPawn(PawnColor color) {
		this.couleur = color;
		setOpaque(false);
		switch (couleur) {
		case WHITE :
			setForeground(Color.WHITE);
			break;
		case BLACK :
			setForeground(Color.BLACK);
			break;
		case ZEN :
			setForeground(Color.RED);
			break;
		}
	}
	
	public void paintComponent(Graphics g){
		g.fillOval(5, 5, getWidth()-10, getHeight()-10);

	}

	public PawnColor getCouleur() {
		return couleur;
	}

}
