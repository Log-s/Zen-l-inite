package control;

import model.Mode;

/**
 * Class that offers different prompt types : mode prompt, name prompt, coordinates prompt and quit/save prompt.
 * Every method is only designed for the value recovery. Every display functionnality (visual communication with the user) is handeld by the calling method.
 * This way, the methods are more likely to be called by various methods.
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class Prompt {

    /**
     * inputMode asks the user for an input, to select the gameMode :
     *      - HH (Human - Human)
     *      - HA (Human - Automated)
     *      - AA (Automated - Automated)
     * 
     * @return Mode gameMode chosen by the user
     */
    public static Mode inputMode() {
        return Mode.HH;
    }



    /**
     * inputName asks the user for an input, to select a name for a player.
     * 
     * @return String name of the player
     */
    public static String inputName() {
        return "";
    }



    /**
     * inputCoordinates asks the user for two Int, to form a coordinate (for a pawn to select of a move to make).
     * 
     * @return int[] a tab of int of lenght 2
     */
    public static int[] inputCoordinates() {
        int[] ret = {0,0};
        return ret;
    }



    /**
     * askForQuit asks the user for y/n to maybe launch the save/quit procedure
     * 
     * @return a char with the user's answer
     */
    public static char askForQuit() {
        return 'y';
    }
}