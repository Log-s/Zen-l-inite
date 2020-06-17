package model;

import java.util.ArrayList;
import control.Prompt;

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
    public Human(String name, ArrayList<Pawn> pawnList) {
        super(name, pawnList);
    }



    /**
     * Allow the player to move a pawn on his turn
     * tab[0] : pawn x position     ;       tab[1] : pawn y position
     * tab[2] : move x position     ;       tab[3] : move x positions
     * 
     * @return tab with move coordinates
     */
    public int[] newMove() {
        int[] coordinates = Prompt.inputCoordinates();
        return coordinates;
    }



    /**
     * returns a String with formated information about the player
     * @return formated String
     */
    public String toString() {
        
        String ret = "";
        ret += "Human\n";
        ret += "Name : "+this.name;
        
        return ret;
    }
}