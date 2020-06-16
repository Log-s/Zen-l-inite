package util;

import model.Difficulty;
import model.Game;
import model.Mode;
import model.Player;

public class Prints {
    
    /**
     * Prints the logo
     */
    public static void logo() {

        System.out.println();
        System.out.println("███████╗███████╗███╗   ██╗        ██╗     ██╗ ██╗███╗   ██╗██╗████████╗██╗███████╗");
        System.out.println("╚══███╔╝██╔════╝████╗  ██║        ██║     ██║ ██║████╗  ██║██║╚══██╔══╝██║██╔════╝");
        System.out.println("  ███╔╝ █████╗  ██╔██╗ ██║        ██║     ╚═╝ ██║██╔██╗ ██║██║   ██║   ██║█████╗  ");
        System.out.println(" ███╔╝  ██╔══╝  ██║╚██╗██║        ██║         ██║██║╚██╗██║██║   ██║   ██║██╔══╝  ");
        System.out.println("███████╗███████╗██║ ╚████║        ███████╗    ██║██║ ╚████║██║   ██║   ██║███████╗");
        System.out.println("╚══════╝╚══════╝╚═╝  ╚═══╝        ╚══════╝    ╚═╝╚═╝  ╚═══╝╚═╝   ╚═╝   ╚═╝╚══════╝");
        System.out.println();
    }

    /**
     * Prints the game configuration
     * 
     * @param player1
     * @param player2
     * @param gameMode
     * @param diff
     */
    public static void config(String player1, String player2, Mode gameMode, Difficulty diff) {
        System.out.println("_____________________________________");
        System.out.println("|     Welcome to Zen l'Initie !      \\");
        System.out.println("|  ---------------------------------");
        System.out.println("| Player 1 : "+player1+" (O)");
        System.out.println("| Player 2 : "+player2+" (X)");
        System.out.println("| Game mode : "+gameMode);
        if (gameMode == Mode.HA) {
            System.out.println("| Bot Difficulty : "+diff);
        }
        System.out.println("|____________________________________/");
        System.out.println();
    }


    /**
     * Method used to draw th board with the pawns in the current stat in the console
     */
    public static void board(Game game) {

        System.out.println("  | 0   1   2   3   4   5   6   7   8   9   10");
        System.out.println("----------------------------------------------");
        for (int y=0 ; y<game.SIZE ; y++) {

            if (y<10) {
                System.out.print(y+" | ");
            }
            else {
                System.out.print(y+"| ");
            }

            for (int x=0 ; x<game.SIZE ; x++) {
                if (!game.grid[y][x].isFree()) {
                    switch (game.getPawnOnSquare(x, y).getColor()) {
                        case BLACK:
                            System.out.print("X");
                            break;
                        case WHITE:
                            System.out.print("O");
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
        System.out.println();

    }
}