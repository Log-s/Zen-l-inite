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
        System.out.println(" /$$$$$$$$                           /$$ /$$   /$$           /$$   /$$     /$$");
        System.out.println("|_____ $$                           | $$| $/  |__/          |__/  | $$    |__/ ");
        System.out.println("     /$$/   /$$$$$$  /$$$$$$$       | $$|_/    /$$ /$$$$$$$  /$$ /$$$$$$   /$$  /$$$$$$ ");
        System.out.println("    /$$/   /$$__  $$| $$__  $$      | $$      | $$| $$__  $$| $$|_  $$_/  | $$ /$$__  $$");
        System.out.println("   /$$/   | $$$$$$$$| $$  \\ $$      | $$      | $$| $$  \\ $$| $$  | $$    | $$| $$$$$$$$");
        System.out.println("  /$$/    | $$_____/| $$  | $$      | $$      | $$| $$  | $$| $$  | $$ /$$| $$| $$_____/");
        System.out.println(" /$$$$$$$$|  $$$$$$$| $$  | $$      | $$$$$$$$| $$| $$  | $$| $$  |  $$$$/| $$|  $$$$$$$");
        System.out.println("|________/ \\_______/|__/  |__/      |________/|__/|__/  |__/|__/   \\___/  |__/ \\_______/");
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
        if (player1!=null) {
            System.out.println("| Player 1 : "+player1+" (O)");
        }
        if (player2!=null) {
            System.out.println("| Player 2 : "+player2+" (X)");
        }
        if (gameMode!=null) {
            System.out.println("| Game mode : "+gameMode);
        }
        if (diff != null) {
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



    /**
     * Prints the rulesn and informations
     */
    public static void rules() {
        System.out.println("[¤] Goal :");
        System.out.println();
        System.out.println("\t The winner is the first player to create a chain with all of his remaining pawns (including the ZEN)");
        System.out.println();
        System.out.println();
        System.out.println("[¤] Rules :");
        System.out.println();
        System.out.println("\t┌─ Rule 1° :");
        System.out.println("\t└──────────╼ One can move his pawns in any direction (horizontal, vertical, diagonal)");
        System.out.println("\t             A pawn moves as many squares as there are pawns on its movement line (including itself,");
        System.out.println("\t             the opponent's pawns and the ZEN pawn)");
        System.out.println("\t┌─ Rule 2° :");
        System.out.println("\t└──────────╼ A pawn can step over any friendly pawn, but is blocked by the opponent's pawns");
        System.out.println("\t┌─ Rule 3° :");
        System.out.println("\t└──────────╼ If a pawn stops exactly on a opponent's pawn, it replaces it on the square, and the");
        System.out.println("\t             opponnent's pawn is taken off the board");
        System.out.println("\t┌─ Rule 4° :");
        System.out.println("\t└──────────╼ The ZEN pawn can be considered as a friendly pawn (step over it, move it) or as a");
        System.out.println("\t             opponent's pawn (remove it from board) idenpendently at each turn");
        System.out.println();
        System.out.println();
        System.out.println("[¤] How to play :");
        System.out.println();
        System.out.println("\t- Fist you will have to configure the game");
        System.out.println("\t- Before each turn, you will be ask if you want to quit an save the game");
        System.out.println("\t- At each turn, you will need to enter a pawn's coordinates and the coordinates of a valid square");
        System.out.println("\t- If movement is impossible for any reason, you will be asked again");
        System.out.println();
        System.out.println();
        System.out.println("[¤] Advice :");
        System.out.println();
        System.out.println("\t You should enlarge your terminal's window to play in the best conditions");
        System.out.println("\t In order to play in good conditions, this page should be able to be displayed entirely");
        System.out.println();
        System.out.println();
        System.out.println("Have fun !");
        System.out.println("Author : Léo DESMONTS - IUT Vannes - 2020");
        System.out.println("Non-graphical version");
        System.out.println();
        System.out.println();
        System.out.println("== PRESS ENTER TO CONTIUNUE ==");
    }
}
