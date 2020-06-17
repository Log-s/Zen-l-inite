package model;

//personnal libs
import control.Prompt;
import util.Prints;
import util.Save;

//common libs
import java.util.Random;
import java.io.IOException;
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
     * The class constructor launches the readConfig sequence, and creates a new
     * game with the read parameters
     */
    public GameConfig() {

        Prompt.clear();

        Prints.rules();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Prompt.clear();

        this.readConfig();

        if (this.gameMode == Mode.HH && !pickStartPlayer()) {
            String tmp = this.player1;
            this.player1 = this.player2;
            this.player2 = tmp;
        }

        if (this.gameMode == Mode.HA) {
            this.diff = Difficulty.RANDOM; // to remove later
            Game myGame = new Game(player1, player2, gameMode, diff);
        }
        else {
            Game myGame = new Game(player1, player2, gameMode);
        }
    }



    /**
     * readConfig is a prompt sequence, to read the game parameters from the user.
     */
    public void readConfig() {

        String loadGame = Prompt.loadGame();
        if (loadGame != null) {
            Game loadedGame = new Game();
            loadedGame = Save.readSave(loadGame);
            loadedGame.start();
        }

        else {

            this.gameMode = Prompt.inputMode();
            Prints.config(this.player1, this.player2, this.gameMode, this.diff);

            this.player1 = Prompt.inputName();

            String[] names = {"Alex","Jimmy","Tom","Albert","Rosie"};
            int i = (int) (Math.random() * 5);
            this.player2 = "bot "+names[i];    //choosing a random name for the box
            if (this.gameMode == Mode.HH) { //if not a bot, asking for input
                this.player2 = Prompt.inputName();
            }
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
}