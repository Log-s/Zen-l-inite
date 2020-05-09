package model;

import java.util.ArrayList;

/**
 * Main class that handles the game.
 * Handles the board, the main loop, the end conditions
 */
public class Game {

    protected Square[] grid;
    protected ArrayList<Pawn> pawnList;
    private Player player1;
    private Player player2;
    private Player current;



    /**
     * class constructor in case both player are human
     * 
     * @param player1 name of the first player
     * @param player2 name of the second player
     * @param mode gameMode (for debugging purposes)
     */
    public Game(String player1, String player2, Mode gameMode) {

    }



    /**
     * class constructor in case the user is playing against the machine
     * 
     * @param player1 name of the first player
     * @param player2 name of the second player
     * @param mode gameMode (for debugging purposes)
     * @param dif Difficulty of the Automated player
     */
    public Game(String player1, String player2, Mode gameMode, Difficulty dif) {

    }



    /**
     * method used to start the game
     */
    public void start() {

    }



    /**
     * method used to end the game when someone won
     */
    public void end() {

    }



    /**
     * Method used to draw th board with the pawns in the current stat in the console
     */
    public void drawBoard() {

    }



    /**
     * readMove reads the players next move (asks for pawn to move, and for the next coordinates).
     * Reapats until move is right, or the player saved the game to quit.
     */
    public void readMove() {

    }



    /**
     * updates pawns positions after readMove
     */
    public void makeMove() {
        
    }



    /**
     * Detects the longuest chain of a player. Is used to detect if there is a winner.
     * @return the longuest chain length
     */
    public int detectLonguestChain() {
        return 0;
    }



    /**
     * isWon is called to verify if the game was won by one of the players
     * @return true if there is a winner or a tie, else otherwise
     */
    public boolean isWon() {
        return true;
    }



    /**
     * setBoard is called once by the constructor, to initialize the board and the pawns
     */
    public void setBoard() {

    }

}