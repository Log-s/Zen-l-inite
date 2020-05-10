package model;

/**
 * class that models a automated player
 * 
 * @author Léo DESMONTS -  IUT VANNES - 2020
 * @version 1.0
 */
public class Computer extends Player {

    /**
     * class constructor, that calls upon the Player(String) constructor
     * 
     * @param name name given to the automated player
     * @param diff Automated player difficulty
     */
    public Computer(String name, Difficulty diff) {
        super(name);
    }



    /**
     * Allow the automated player to move a pawn on ti's turn
     */
    public void newMove() {

    }



    /**
     * getter that gets the player difficulty
     * 
     * @return the difficulty
     */
    public Difficulty getDifficulty() {
        return Difficulty.RANDOM;
    }



    /**
     * returns a String with formated information about the player
     * @return formated String
     */
    public String toString() {
        return "";
    }
}