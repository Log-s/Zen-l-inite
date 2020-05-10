package model;

/**
 * class that models a automated player
 * 
 * @author Léo DESMONTS -  IUT VANNES - 2020
 * @version 1.0
 */
public class Human extends Player {

    /**
     * class constructor, that calls upon the Player(String) constructor
     * 
     * @param name name given to the human player
     */
    public Human(String name) {
        super(name);
    }



    /**
     * Allow the player to move a pawn on his turn
     */
    public void newMove() {

    }



    /**
     * returns a String with formated information about the player
     * @return formated String
     */
    public String toString() {
        return "";
    }
}