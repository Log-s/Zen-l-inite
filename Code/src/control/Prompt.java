package control;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
     * 
     * @return Mode gameMode chosen by the user
     */
    public static Mode inputMode() {

        String sMode = "";
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.NO_OPTION;

        do {

            do {
                sMode = JOptionPane.showInputDialog(new JFrame(), "Choose game mode {HH | HA} :");
            } while (!sMode.equals("HH") && !sMode.equals("HA"));

            dialogResult = JOptionPane.showConfirmDialog (null, "You chose : "+sMode+"\nAre you sure ?","Verification",dialogButton);
        } while (dialogResult == JOptionPane.NO_OPTION);

        Mode mMode = Mode.HA;
        if (sMode.equals("HH")) {
            mMode = Mode.HH;
        }

        return mMode;
    }



    /**
     * inputName asks the user for an input, to select a name for a player.
     * 
     * @return String name of the player
     */
    public static String inputName() {

        String name = "";
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.NO_OPTION;

        do {

            do {
                name = JOptionPane.showInputDialog(new JFrame(), "Choose a name (can't be empty) :");
            } while (name.equals(""));

            dialogResult = JOptionPane.showConfirmDialog (null, "You chose : "+name+"\nAre you sure ?","Verification",dialogButton);
        } while (dialogResult == JOptionPane.NO_OPTION);

        return name;
    }



    /**
     * inputCoordinates asks the user for two Ints.
     * tab[0] : pawn x position     ;       tab[1] : pawn y position
     * tab[2] : move x position     ;       tab[3] : move x positions
     * 
     * @return int[] a tab of int of lenght 4
     */
    public static int[] inputCoordinates() {

        int xP;
        String xPS;
        int yP;
        String yPS;
        int xM;
        String xMS;
        int yM;
        String yMS;
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.NO_OPTION;

        do {

            do {
                xPS = JOptionPane.showInputDialog(new JFrame(), "Choose Pawn's x coordinate (integers only):");
                try {
                    xP = Integer.parseInt(xPS);
                }
                catch (NumberFormatException e) {
                    xP = -1;
                }
            } while (xP<0 || xP>10);

            do {
                yPS = JOptionPane.showInputDialog(new JFrame(), "Choose Pawn's y coordinate (integers only):");
                try {
                    yP = Integer.parseInt(yPS);
                }
                catch (NumberFormatException e) {
                    yP = -1;
                }
            } while (yP<0 || yP>10);

            do {
                xMS = JOptionPane.showInputDialog(new JFrame(), "Choose a x coordinate (integers only):");
                try {
                    xM = Integer.parseInt(xMS);
                }
                catch (NumberFormatException e) {
                    xM = -1;
                }
            } while (xM<0 || xM>10);

            do {
                yMS = JOptionPane.showInputDialog(new JFrame(), "Choose a y coordinate (integers only):");
                try {
                    yM = Integer.parseInt(yMS);
                }
                catch (NumberFormatException e) {
                    yM = -1;
                }
            } while (yM<0 || yM>10);

            dialogResult = JOptionPane.showConfirmDialog (null, "You chose to move the pawn ("+xP+","+yP+") to "+xM+","+yM,"Verification",dialogButton);
        } while (dialogResult == JOptionPane.NO_OPTION);

        int[] ret = {xP,yP,xM,yM};

        return ret;
    }



    /**
     * askForQuit asks the user for y/n to maybe launch the save/quit procedure
     * 
     * @return a char tab with the user's answer
     * \n\t *char[0] = 'y' => user wants to quit
     * \n\t *char[1] = 'y' => user wants to save
     */
    public static char[] askForQuit() {

        String qS;
        char q = 'n';
        String sS;
        char s = 'n';
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.YES_OPTION;

        do {

            q = 'e';    //e stands for error
            s = 'e';
            dialogResult = JOptionPane.YES_OPTION;

            do {
                qS = JOptionPane.showInputDialog(new JFrame(), "Do you want to quit ? (y/n)");
                if (qS.length() == 1) {
                    q = qS.charAt(0);
                }
                else {
                    q = 'e';    //length error
                }
            } while (q != 'y' && q != 'n');

            if (q == 'y') { // ask for save if user decides to quit
                do {
                    sS = JOptionPane.showInputDialog(new JFrame(), "Do you want to save ? (y/n)");
                    if (sS.length() == 1) {
                        s = sS.charAt(0);
                    }
                    else {
                        s = 'e';    //length error
                    }
                } while (s != 'y' && s != 'n');
            }

            if (q == 'y' && s == 'n') { //verification if user chooses to quit without saving
                dialogResult = JOptionPane.showConfirmDialog (null, "Quit without saving ?\nAre you sure ?","Verification",dialogButton);
            }
        } while (dialogResult == JOptionPane.NO_OPTION);

        char[] ret = {q,s};

        return ret;
    }
}