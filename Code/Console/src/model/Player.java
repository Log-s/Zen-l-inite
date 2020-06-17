package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * abstract class modeling a player, and common attributs/method to human and automated players.
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public abstract class Player implements Serializable {

    protected String name;
    protected ArrayList<Pawn> pawnList;



    /**
     * creates the player
     * 
     * @param name the player's name
     * @param pawnList list of pawns still in game
     */
    public Player(String name, ArrayList<Pawn> pawnList) {

        if (name == null) {
            System.err.println("[!] Error - null value \"name\" | model.Player.Player(String name, ArrayList<Pawn> pawnList)");
        }
        else if (pawnList == null) {
            System.err.println("[!] Error - null value \"pawnList\" | model.Player.Player(String name, ArrayList<Pawn> pawnList)");          
        }

        else {
            this.name = name;
            this.pawnList = pawnList;
        }
    }



    /**
     * Getter : gets the players name
     */
    public String getName() {
        return this.name;
    }



    /**
     * Method to be reimplemented by humman and automated players.
     * Lauches the procedure of a new move
     * 
     * tab[0] : pawn x position     ;       tab[1] : pawn y position
     * tab[2] : move x position     ;       tab[3] : move x positions
     * @return int[] tab
     */
    public abstract int[] newMove();



    /**
     * Method to be reimplemeted bu human and automated players.
     * 
     * @return a string containing formated information about the player
     */
    public abstract String toString();
}