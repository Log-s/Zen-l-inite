package view;

import model.PawnColor;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;

/**
 * class that models a graphical pawn
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class GUIPawn extends JPanel {

	private static final long serialVersionUID = 1436178861615738480L;

	private PawnColor couleur;

	/**
     * Creates the GUIPawn object
     * @param color color of the pawn
     */
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

	/**
	 * @return the color of the pawn
	 */
	public PawnColor getCouleur() {
		return couleur;
	}
	
	/**
     * repaints the pawn
     * @param g
     */
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.fillOval(5, 5, getWidth()-10, getHeight()-10);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(2));
		g2.drawOval(5, 5, getWidth()-10, getHeight()-10);
	}

}
