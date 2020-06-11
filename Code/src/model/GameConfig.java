package model;

//personnal libs
import model.Game.*;
import model.Mode.*;

//common libs
import java.util.Random;

/**
 * Class used to configure a game before it starts
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class GameConfig {

    private String player1;
    private String player2;
    private Mode gameMode;
    private Difficulty diff;


    /**
     * The class constructor launches the readConfig sequence, and creates a new game with the read parameters
     */
    public GameConfig() {

        this.readConfig();

        if (!pickStartPlayer()) {
            String tmp = this.player1;
            this.player1 = this.player2;
            this.player2 = tmp;
        }

        if (this.gameMode == Mode.HA) {
            Game myGame = new Game(player1, player2, gameMode, diff);
        }
        else {
            Game myGame = new Game(player1, player2, gameMode);
        }

        this.printConfig();

    }



    /**
     * readConfig is a prompt sequence, to read the game parameters from the user.
     */
    public void readConfig() {
        this.player1 = "name1";
        this.player2 = "name2";
        this.gameMode = Mode.HA;
    }



    /**
     * picks randomly the player who starts
     * Original playing order is the order player names where enterd.
     * This method randomly returns a boolean
     * 
     * @return -true : order is kept | -false : order is inverted
     */
    public boolean pickStartPlayer() {
        Random rd = new Random();
        return rd.nextBoolean();
    }



    /**
     * printConfig prints the configuration used for the game (gamemode, playernames, etc)
     */
    public void printConfig() {
        System.out.println("_____________________________________");
        System.out.println("|     Welcome to Zen l'Initie !      \\");
        System.out.println("|  ---------------------------------");
        System.out.println("|Player 1 : "+this.player1);
        System.out.println("|Player 2 : "+this.player2);
        System.out.println("|Game mode : "+this.gameMode);
        if (this.gameMode == Mode.HA) {
            System.out.println("|Bot Difficulty : "+this.diff);
        }
        System.out.println("|____________________________________/");
    }
}