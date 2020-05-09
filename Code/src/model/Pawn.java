package model;

/**
 * class that models a pawn
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class Pawn {

    private Color color;
    private int xPos;
    private int yPos;



    /**
     * Class construtor, creates the pawn
     * 
     * @param color Color of the pawn (can be WHITE, BLACK, ZEN)
     */
    public Pawn(Color color) {

    }



    /**
     * getter that returns the color of the pawn
     * 
     * @return a Color
     */
    public Color getColor() {
        return Color.ZEN;
    }



    /**
     * getter that returns the horizontal position of the pawn on the grid
     * 
     * @return int with the x position
     */
    public int getXPos() {
        return 0;
    }



    /**
     * getter that returns the vertical position of the pawn on the grid
     * 
     * @return int with the y position
     */
    public int getYPos() {
        return 0;
    }



    /**
     * setter that sets the position of the pawn on the grid
     * 
     * @param x horizontal coordinate
     * @param y vertical cooridinate
     */
    public void setPosition(int x, int y) {

    }



    /**
     * returns a formated information about the pawn
     * 
     * @return a string with the information
     */
    public String toString() {
        return "";
    }
    
}