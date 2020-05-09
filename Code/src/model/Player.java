package model;

/**
 * abstract class modeling a player, and common attributs/method to human and automated players.
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public abstract class Player {

    private String name;



    /**
     * creates the player
     * 
     * @param name the player's name
     */
    public Player(String name) {

    }



    /**
     * Method to be reimplemented by humman and automated players.
     * Lauches the procedure of a new move
     */
    public abstract void newMove();
}