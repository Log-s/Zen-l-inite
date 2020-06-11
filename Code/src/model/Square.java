package model;


/**
 * class that models a square, meant to be part of the playing grid
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class Square {

    private int xPos;
    private int yPos;
    private boolean free;



    /**
     * creates the square, with his position on the grid
     * 
     * @param x horizontal position
     * @param y vertical position
     */
    public Square(int x, int y) {

        // value verifications are made by the calling method
        // values are correct 
        this.xPos = x;
        this.yPos = y;
        this.free = true;
    }



    /**
     * Checks if the square is free (no pawn is on it)
     * 
     * @return true if it's free, false otherwise
     */
    public boolean isFree() {
        return this.free;
    }



    /**
     * Chages the state of the square (free/not free)
     */
    public void changeState() {
        if (this.free) {
            this.free = false;
        }
        else {
            this.free = true;
        }
    }



    /**
     * Horizontal poistion on the grid getter
     * 
     * @return int with the x position
     */
    public int getXPos() {
        return this.xPos;
    }



    /**
     * Vertical position on the grid getter
     * 
     * @return in with y position
     */
    public int getYPos() {
        return this.yPos;
    }



    /**
     * Returns a string with formated information about the square
     * 
     * @return the formated string
     */
    public String toString() {

        String ret = "";
        ret += "x : "+this.xPos;
        ret += "y : "+this.yPos;
        ret += "is free : "+this.free;
        return ret;
    }
}   