package model;

//personnal libs
import control.Prompt;
import util.Prints;

//common libs
import java.util.Random;
import java.lang.Math;

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

        Prompt.clear();
        
        this.readConfig();

        if (this.gameMode == Mode.HH && !pickStartPlayer()) {
            String tmp = this.player1;
            this.player1 = this.player2;
            this.player2 = tmp;
        }

        if (this.gameMode == Mode.HA) {
            this.diff = Difficulty.RANDOM; // to remove later
            Prints.config(this.player1, this.player2, this.gameMode, this.diff);
            Game myGame = new Game(player1, player2, gameMode, diff);
        }
        else {
            Prints.config(this.player1, this.player2, this.gameMode, this.diff);
            Game myGame = new Game(player1, player2, gameMode);
        }
    }



    /**
     * readConfig is a prompt sequence, to read the game parameters from the user.
     */
    public void readConfig() {

        this.gameMode = Prompt.inputMode();

        this.player1 = Prompt.inputName();

        String[] names = {"Alex","Jimmy","Tom","Albert","Rosie"};
        int i = (int) (Math.random() * 5);
        this.player2 = "bot "+names[i];    //choosing a random name for the box
        if (this.gameMode == Mode.HH) { //if not a bot, asking for input
            this.player2 = Prompt.inputName();
        }
            
    }



    /**
     * picks randomly the player who starts
     * Original playing order is the order player names where enterd.
     * This method randomly returns a boolean
     * The method is only used for HH mode
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
        System.out.println("| Player 1 : "+this.player1+" (O)");
        System.out.println("| Player 2 : "+this.player2+" (X)");
        System.out.println("| Game mode : "+this.gameMode);
        if (this.gameMode == Mode.HA) {
            System.out.println("| Bot Difficulty : "+this.diff);
        }
        System.out.println("|____________________________________/");
        System.out.println();
    }
}