package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;


/**
 * class that models a graphical square
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class GUISquare extends JPanel {
	
	private static final long serialVersionUID = -1839026893240660968L;
	
	private Color color;
	private boolean selectionnee;

	/**
	 * Creates the square
	 * @param c color of the square
	 */
	public GUISquare(Color c){
		this.setLayout(new GridLayout(1,0));
		this.color=c;
	}

	/**
	 * @return the color of the square
	 */
	public Color getCouleur() {
		return this.color;
	}

	/**
	 * @return the value of the selectionnee atribute
	 */
	public boolean isSelectionnee() {
		return selectionnee;
	}

	/**
	 * selects (or deselects) the square
	 */
	public void select() {
		this.selectionnee = !this.selectionnee;
		this.repaint();
	}

	/**
     * repaints the squares with images
     * @param g
     */
	protected void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		if (this.selectionnee){
			g.drawImage(new ImageIcon("../data/images/purple.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		}
		else {
			if (this.color == Color.BLACK) {
				g.drawImage(new ImageIcon("../data/images/squareTexture.jpeg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			}
			else {
				g.drawImage(new ImageIcon("../data/images/squareTexture2.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			} 
		}
    }
}
