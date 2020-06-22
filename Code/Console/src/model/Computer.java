package model;

import java.util.ArrayList;
import java.lang.Math;

/**
 * class that models a automated player
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
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
    public Computer(String name, ArrayList<Pawn> pawnList, Difficulty diff) {
        super(name,pawnList);

        if (diff == null) {
            System.err.println("[!] Error - null value \"diff\" | model.Computer.Computer(String name, ArrayList<Pawn> pawnList, Difficulty diff)");
        }
        else {
            this.diff = diff;
        }
    }



    /**
     * Allow the automated player to move a pawn on it's turn
     * tab[0] : pawn x position     ;       tab[1] : pawn y position
     * tab[2] : move x position     ;       tab[3] : move x positions
     */
    public int[] newMove() {
        
        int[] coordinates = new int[4];
        Pawn p = null;

        if (this.diff == Difficulty.RANDOM) {
            do {
                p = this.pawnList.get((int) (Math.random()*this.pawnList.size()));
                System.out.println(p);
            } while (p.getColor() != PawnColor.BLACK && p.getColor() != PawnColor.ZEN);
        }

        coordinates[0] = p.getXPos();
        coordinates[1] = p.getYPos();
        
        Direction direct = Direction.values()[(int) (Math.random() * (Direction.values().length))];
        int invert = 1;
        if ((int) (Math.random()*2) == 1) {
            invert = -1;
        }

        int r = (int) (Math.random()*11);
        switch (direct) {
            case HORIZONTAL:
                coordinates[2] = coordinates[0]+(r*invert);
                coordinates[3] = coordinates[1];
                break;
            case VERTICAL:
                coordinates[2] = coordinates[0];
                coordinates[3] = coordinates[1]+(r*invert);
                break;
            case LEFT_DIAG:
                coordinates[2] = coordinates[0]+(r*invert);
                coordinates[3] = coordinates[1]+(r*invert);
                break;
            case RIGHT_DIAG:
                coordinates[2] = coordinates[0]+(r*invert*(-1));
                coordinates[3] = coordinates[1]+(r*invert);
                break;
        }
        return coordinates;
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
