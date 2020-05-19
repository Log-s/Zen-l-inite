package model;

import java.util.ArrayList;

/**
 * Main class that handles the game.
 * Handles the board, the main loop, the end conditions
 */
public class Game {

    private int SIZE = 11;
    private int[] lastZenPosition;
    protected Square[][] grid;
    protected ArrayList<Pawn> pawnList;
    private Player player1;
    private Player player2;
    private Player current;



    /**
     * class constructor in case both player are human
     * 
     * @param player1 name of the first player
     * @param player2 name of the second player
     * @param gameMode gameMode (for debugging purposes)
     */
    public Game(String player1, String player2, Mode gameMode) {

    }



    /**
     * class constructor in case the user is playing against the machine
     * 
     * @param player1 name of the first player
     * @param player2 name of the second player
     * @param gameMode gameMode (for debugging purposes)
     * @param dif Difficulty of the Automated player
     */
    public Game(String player1, String player2, Mode gameMode, Difficulty dif) {

    }



    /***
     * class constructor in case the game is loaded
     */
    public Game() {
        
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
     * returns the arrayList of Pawns (for testing purposes)
     * 
     * @return pawnList attribut
     */
    public ArrayList<Pawn> getPawnList() {
        return new ArrayList<Pawn>();
    }



    /**
     * returns the grid (for testing purposes)
     * 
     * @return game board
     */
    public Square[][] getGrid() {
        return new Square[0][0];
    }



    /**
     * Gets the pawn on the given square
     * 
     * @param x x coordinate of the square
     * @param y y coordinate of the square
     * @return a pawn, or null if the square is empty
     */
    public Pawn getPawnOnSquare(int x, int y) {
        return new Pawn(Color.ZEN);
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
     * Moves a pawn on the grid
     * 
     * @param p pawn to move
     * @param x x Coordinate of where to move the pawn
     * @param y y Coordinate of where to move the pawn
     */
    public void makeMove(Pawn p, int x, int y) {
        
    }



    /**
     * Removes a Pawn from pawnList, if this one is taken by the oppponent, and is therefor no longer in game
     * 
     * @param p Pawn to remove
     */
    public void removePawn(Pawn p) {

    }



    /**
     * Detects the longuest chain of a player. Is used to detect if there is a winner.
     * 
     * @param p Player to detect the longuest chain of
     * @return the longuest chain length
     */
    public int detectLonguestChain(Player p) {
        return 0;
    }



    /**
     * Gets the number of pawn remanining possessed by the player (counting the ZEN pawn)
     * Used to compare to the longuest chain
     */
    public int getNbPawn(Player p) {
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



    /**
     * changes the current player to the other player
     */
    public void changePlayer() {

    }



    /**
     * returns the current player (for testing purposes)
     * 
     * @return the current player
     */
    public Player getCurrent() {
        return new Human("player");
    }



    /**
     * returns the player 1 (for testing purposes)
     * 
     * @return the player 2
     */
    public Player getPlayer1() {
        return new Human("player");
    }



    /**
     * returns the player 2 (for testing purposes)
     * 
     * @return the player 2
     */
    public Player getPlayer2() {
        return new Human("player");
    }



    /**
     * Checks if the enterd move is possible :
     *  1) Evaluates the Direction by using relatives positions of the pawn and the entended move
     *  2) Checks if there are some enemy pawn on the way
     * 
     * @param p Pawn to move
     * @param x x coordinate to move to
     * @param y y coordinate to move to
     * @return true if the move is possible, false otherwise
     */
    public boolean isMovePossible(Pawn p, int x, int y) {
        return true;
    }
}