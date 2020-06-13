package model;

import java.io.Serializable;

/**
 * abstract class modeling a player, and common attributs/method to human and automated players.
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public abstract class Player implements Serializable {

    private String name;



    /**
     * creates the player
     * 
     * @param name the player's name
     */
    public Player(String name) {

    }



    /**
     * Getter : gets the players name
     */
    public String getName() {
        return "";
    }



    /**
     * Method to be reimplemented by humman and automated players.
     * Lauches the procedure of a new move
     */
    public abstract void newMove();



    /**
     * Method to be reimplemeted bu human and automated players.
     * 
     * @return a string containing formated information about the player
     */
    public abstract String toString();
}