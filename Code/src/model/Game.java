package model;

import util.Save;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;

/**
 * Main class that handles the game.
 * Handles the board, the main loop, the end conditions
 */
public class Game implements Serializable{

    private final int SIZE = 11;
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

        if (player1 == null) {
            System.err.println("[!] Error - null value \"player1\" | model.Game.Game(String player1, String player2, Mode gameMode)");
        }
        else if (player2 == null) {
            System.err.println("[!] Error - null value \"player2\" | model.Game.Game(String player1, String player2, Mode gameMode)");
        }
        else if (gameMode == null) {
            System.err.println("[!] Error - null value \"gameMode\" | model.Game.Game(String player1, String player2, Mode gameMode)");
        }

        else {
            this.setBoard();
            this.player1 = new Human(player1);
            this.player2 = new Human(player2);
            this.current = this.player1;
            this.drawBoard();
        }
    }



    /**
     * class constructor in case the user is playing against the machine
     * 
     * @param player1 name of the first player
     * @param player2 name of the second player
     * @param gameMode gameMode (for debugging purposes)
     * @param dif Difficulty of the Automated player
     */
    public Game(String player1, String player2, Mode gameMode, Difficulty diff) {
        if (player1 == null) {
            System.err.println("[!] Error - null value \"player1\" | model.Game.Game(String player1, String player2, Mode gameMode, Difficulty diff)");
        }
        else if (player2 == null) {
            System.err.println("[!] Error - null value \"player2\" | model.Game.Game(String player1, String player2, Mode gameMode, Difficulty diff)");
        }
        else if (gameMode == null) {
            System.err.println("[!] Error - null value \"gameMode\" | model.Game.Game(String player1, String player2, Mode gameMode, Difficulty diff)");
        }
        else if (diff == null) {
            System.err.println("[!] Error - null value \"diff\" | model.Game.Game(String player1, String player2, Mode gameMode, Difficulty diff)");
        }

        else {
            this.setBoard();
            this.player1 = new Human(player1);
            this.player2 = new Computer(player2,diff);
            this.current = this.player1;
            this.drawBoard();
        }
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
        return this.pawnList;
    }



    /**
     * returns the grid (for testing purposes)
     * 
     * @return game board
     */
    public Square[][] getGrid() {
        return this.grid;
    }



    /**
     * Gets the pawn on the given square
     * 
     * @param x x coordinate of the square
     * @param y y coordinate of the square
     * @return a pawn, or null if the square is empty
     */
    public Pawn getPawnOnSquare(int x, int y) {

        Pawn ret = null;

        for (Pawn p : this.pawnList) {
            if (p.getXPos() == x && p.getYPos() == y) {
                ret = p;
            }
        }

        return ret;
    }



    /**
     * Method used to draw th board with the pawns in the current stat in the console
     */
    public void drawBoard() {

        System.out.println("  | 0   1   2   3   4   5   6   7   8   9   10");
        System.out.println("----------------------------------------------");
        for (int y=0 ; y<this.SIZE ; y++) {

            if (y<10) {
                System.out.print(y+" | ");
            }
            else {
                System.out.print(y+"| ");
            }

            for (int x=0 ; x<this.SIZE ; x++) {

                if (!this.grid[y][x].isFree()) {
                    switch (this.getPawnOnSquare(x, y).getColor()) {
                        case BLACK:
                            System.out.print("O");
                            break;
                        case WHITE:
                            System.out.print("X");
                            break;
                        case ZEN:
                            System.out.print("Z");
                            break;
                    }
                }
                else {
                    System.out.print(".");
                }
                System.out.print("   ");
            }
            if (y<10) {
                System.out.print("\n  |\n");
            }
            else {
                System.out.println();
            }
        }

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
     * 
     * @return nb of pawns remaining (-1 if an error occurs)
     */
    public int getNbPawn(Player p) {
        
        int i = -1;

        if (p == null) {
            System.err.println("[!] Error - null value \"p\" | model.Game.getNbPawn(Player p)");
        }

        else {

            i = 0;
            Color c = Color.BLACK;
            if (p == this.player1) {
                c = Color.WHITE;
            }

            for (Pawn pwn : this.pawnList) {
                if (pwn.getColor() == c || pwn.getColor() == Color.ZEN) {
                    i++;
                }
            }

        }

        return i;
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

        this.grid = new Square[this.SIZE][this.SIZE];
        
        for (int y=0 ; y<this.SIZE ; y++) {     //initilizing grid
            for (int x=0 ; x<this.SIZE ; x++) {
                this.grid[y][x] = new Square(x, y);
            }
        }

        this.pawnList = new ArrayList<Pawn>();
        ArrayList<String> content = new ArrayList<String>();

        try {

            Scanner sc = new Scanner(new FileReader("../data/config/pwnList.txt"));
            sc.useDelimiter("\\s*:\\s*");

            while(sc.hasNext()){
        		content.add(sc.next());
        	}

            sc.close();

        for (int i=0 ; i<content.size() ; i=i+3) {
            Color c = null;
            switch(content.get(i+2)) {
                case "W":
                    c = Color.WHITE;
                    break;
                case "B":
                    c = Color.BLACK;
                    break;
                case "Z":
                    c = Color.ZEN;
                    break;
            }
            Pawn p = new Pawn(c);
            p.setPosition(Integer.parseInt(content.get(i)), Integer.parseInt(content.get(i+1)));
            this.pawnList.add(p);
            this.grid[Integer.parseInt(content.get(i))][Integer.parseInt(content.get(i+1))].changeState();
        }

        } catch (FileNotFoundException e) {
            System.err.println("[!] Error - file not found : ../ressources/config/pwnList.txt | model.Game.setBoard()");
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.err.println("[!] Error - no more elements : method next() | model.Game.setBoard()");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("[!] Error - parsing error : method Integer.parseInt() | model.Game.setBoard()");
            e.printStackTrace();
        }
    }



    /**
     * changes the current player to the other player
     */
    public void changePlayer() {

        if (this.current == this.player1) {
            this.current = this.player2;
        }
        else {
            this.current = this.player1;
        }
    }



    /**
     * returns the current player (for testing purposes)
     * 
     * @return the current player
     */
    public Player getCurrent() {
        return this.current;
    }



    /**
     * returns the player 1 (for testing purposes)
     * 
     * @return the player 2
     */
    public Player getPlayer1() {
        return this.player1;
    }



    /**
     * returns the player 2 (for testing purposes)
     * 
     * @return the player 2
     */
    public Player getPlayer2() {
        return this.player2;
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