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
        if (color == null) {
            System.err.println("[!] Error : null value -color- in model.Pawn.Pawn(Color color)");
        }
        else {
            this.color = color;
        }
    }



    /**
     * getter that returns the color of the pawn
     * 
     * @return a Color
     */
    public Color getColor() {
        return this.color;
    }



    /**
     * getter that returns the horizontal position of the pawn on the grid
     * 
     * @return int with the x position
     */
    public int getXPos() {
        return this.xPos;
    }



    /**
     * getter that returns the vertical position of the pawn on the grid
     * 
     * @return int with the y position
     */
    public int getYPos() {
        return this.yPos;
    }



    /**
     * setter that sets the position of the pawn on the grid
     * 
     * @param x horizontal coordinate
     * @param y vertical cooridinate
     */
    public void setPosition(int x, int y) {

        // value verifications are made by the calling method
        // values are correct 
        this.xPos = x;
        this.yPos = y;
    }



    /**
     * returns a formated information about the pawn
     * 
     * @return a string with the information
     */
    public String toString() {

        String ret = "";
        ret += "x : "+this.xPos;
        ret += "y : "+this.yPos;
        ret += "color : "+this.color;
        return ret;
    }
    
}