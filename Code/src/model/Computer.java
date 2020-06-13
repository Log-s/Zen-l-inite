package model;

/**
 * class that models a automated player
 * 
 * @author Léo DESMONTS -  IUT VANNES - 2020
 * @version 1.0
 */
public class Computer extends Player {


    private Difficulty diff;




    /**
     * class constructor, that calls upon the Player(String) constructor
     * 
     * @param name name given to the automated player
     * @param diff Automated player difficulty
     */
    public Computer(String name, Difficulty diff) {
        super(name);

        if (diff == null) {
            System.err.println("[!] Error - null value \"diff\" | model.Computer.Computer(String name, Difficulty diff)");
        }
        else {
            this.diff = diff;
        }
    }



    /**
     * Allow the automated player to move a pawn on it's turn
     */
    public void newMove() {

    }



    /**
     * getter that gets the player difficulty
     * 
     * @return the difficulty
     */
    public Difficulty getDifficulty() {
        return this.diff;
    }



    /**
     * returns a String with formated information about the player
     * @return formated String
     */
    public String toString() {
        
        String ret = "";
        ret += "Computer\n";
        ret += "Name : "+this.name;

        return ret;
    }
}