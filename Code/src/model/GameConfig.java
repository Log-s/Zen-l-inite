package model;


/**
 * Class used to configure a game before it starts
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class GameConfig {


    /**
     * The class constructor launches the readConfig sequence, and creates a new game with the read parameters
     */
    public GameConfig() {

    }



    /**
     * readConfig is a prompt sequence, to read the game parameters from the user.
     */
    public void readConfig() {

    }



    /**
     * picks randomly the player who starts
     * Original playing order is the order player names where enterd.
     * This method randomly returns a boolean
     * 
     * @return -true : order is kept | -false : order is inverted
     */
    public boolean pickStartPlayer() {
        return true;
    }



    /**
     * printConfig prints the configuration used for the game (gamemode, playernames, etc)
     */
    public void printConfig() {

    }
}