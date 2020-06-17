package control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Mode;
import util.Prints;
import util.Save;

/**
 * Class that offers different prompt types : mode prompt, name prompt, coordinates prompt and quit/save prompt.
 * Every method is only designed for the value recovery. Every display functionnality (visual communication with the user) is handeld by the calling method.
 * This way, the methods are more likely to be called by various methods.
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class Prompt {

    private static Scanner sc = new Scanner(System.in);


    /**
     * clears the terminal
     * 
     * Thanks to Julien Rouillier for this method
     */
    public final static void clear() {
        if(System.getProperty("os.name").contains("Windows")){
            try{
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }catch(IOException e){
                e.printStackTrace();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }else{
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        Prints.logo();
    }



    /**
     * inputMode asks the user for an input, to select the gameMode :
     *      - HH (Human - Human)
     *      - HA (Human - Automated)
     * 
     * @return Mode gameMode chosen by the user
     */
    public static Mode inputMode() {

        String sMode = "";
        String verif = "";

        do {

            do {
                System.out.print("Choose game mode {HH | HA} :\n> ");
                sMode = sc.nextLine();
                clear();
            } while (!sMode.equals("HH") && !sMode.equals("HA"));

            do {
                System.out.print("Are you sure you want to select "+sMode+" ? (y/n)\n> ");
                verif = sc.nextLine();
                clear();
            } while (!verif.equals("y") && !verif.equals("n"));

        } while (!verif.equals("y"));

        Mode mMode = Mode.HA;
        if (sMode.equals("HH")) {
            mMode = Mode.HH;
        }

        clear();
        return mMode;
    }



    /**
     * inputName asks the user for an input, to select a name for a player.
     * 
     * @return String name of the player
     */
    public static String inputName() {

        String name = " ";
        String verif = "";
        
        do {

            do {
                System.out.print("Choose a player's name\n> ");
                name = sc.nextLine();
                clear();
            } while (name.isEmpty());

            do {
                System.out.print("Are you sure you want to choose "+name+" ? (y/n)\n> ");
                verif = sc.nextLine();
                clear();
            } while (!verif.equals("y") && !verif.equals("n"));
            
        } while (!verif.equals("y"));

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
        String verif = "";

        do {

            do {
                System.out.print("Choose Pawn's X coordinate\n> ");
                xPS = sc.nextLine();
                try {
                    xP = Integer.parseInt(xPS);
                }
                catch (NumberFormatException e) {
                    xP = -1;
                    System.out.println("Nop ! Coordinates have to be intergers");
                }
            } while (xP<0 || xP>10);

            System.out.println();

            do {
                System.out.print("Choose Pawn's Y coordinate\n> ");
                yPS = sc.nextLine();
                try {
                    yP = Integer.parseInt(yPS);
                }
                catch (NumberFormatException e) {
                    yP = -1;
                        System.out.println("Nop ! Coordinates have to be intergers");   

                }
            } while (yP<0 || yP>10);

            System.out.println();

            do {
                System.out.print("Choose a X coordinate to move to\n> ");
                xMS = sc.nextLine();
                try {
                    xM = Integer.parseInt(xMS);
                }
                catch (NumberFormatException e) {
                    xM = -1;
                    System.out.println("Nop ! Coordinates have to be intergers");
                }
            } while (xM<0 || xM>10);

            System.out.println();

            do {
                System.out.print("Choose a Y coordinate to move to\n> ");
                yMS = sc.nextLine();
                try {
                    yM = Integer.parseInt(yMS);
                }
                catch (NumberFormatException e) {
                    yM = -1;
                    System.out.println("Nop ! Coordinates have to be intergers");
                }
            } while (yM<0 || yM>10);

            System.out.println();

            do {
                System.out.print("You chose to move the pawn ("+xP+","+yP+") to "+xM+","+yM+" (y/n)\n> ");
                verif = sc.nextLine();
            } while (!verif.equals("y") && !verif.equals("n"));

        } while (!verif.equals("y"));

        int[] ret = {xP,yP,xM,yM};

        return ret;
    }



    /**
     * askForQuit asks the user for y/n to maybe launch the save/quit procedure
     * 
     * @return a String tab with the user's answer
     * \n\t *char[0] = "y" => user wants to quit
     * \n\t *char[1] = "y" => user wants to save
     * \n\t *char[2] = "filename"
     */
    public static String[] askForQuit() {

        String[] ret = new String[3];

        String q = "";
        String s = "";
        String name = "";
        String verif = "y";

        do {

            do {
                System.out.print("Do you want to quit ? (y/n)\n> ");
                q = sc.nextLine();
            } while (!q.equals("y") && !q.equals("n"));

            System.out.println();

            if (q.equals("y")) { // ask for save if user decides to quit
                do {
                    System.out.print("Do you want to save ? (y/n)\n> ");
                    s = sc.nextLine();
                } while (!s.equals("y") && !s.equals("n"));
            }

            System.out.println();

            if (q.equals("y") && s.equals("y")) {
                do {
                    System.out.print("Save's name ?\n> ");
                    name = sc.nextLine();
                } while (name.isEmpty());
            }
            if (q.equals("y") && s.equals("n")) { //verification if user chooses to quit without saving
                System.out.print("Quit without saving ?\nAre you sure ? (y/n)\n> ");
                verif = sc.nextLine();
            }
        } while (!verif.equals("y"));

        ret[0] = q;
        ret[1] = s;
        ret[2] = name;

        return ret;
    }



    /**
     * asks if a game should be loaded, if yes which one
     * 
     * @return a String with the user's anwser (the fileName, or null if no save is selected)
     */
    public static String loadGame() {

        String ret = null;

        String l = "";
        String saveS = "";
        int save = 0;
        String verif = "";

        do {

            do {
                System.out.print("Do you want to load a game (y) or start a fresh one (n) ?\n> ");
                l = sc.nextLine();
                clear();
            } while (!l.equals("y") && !l.equals("n"));

            verif = "y";

            if (l.equals("y")) {
                verif = "n";
                do {
                    clear();

                    //getting the save list
                    List<String> result = null;
                    try (Stream<Path> walk = Files.walk(Paths.get("../data/saves/"))) {

                        result = walk.filter(Files::isRegularFile)
                                .map(x -> x.toString()).collect(Collectors.toList());
                    
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println();
                    int i=1;
                    while (i-1<result.size()) {
                        if (result.get(i-1).equals("../data/saves/emptyFileForGit")) {
                            result.remove(i-1);
                        }
                        else {
                            System.out.println(i+") "+result.get(i-1).substring(14));
                            i++;
                        }
                    }
                    if (result.size() == 0) {
                        System.out.println("No save avalaible :/\n\n== PRESS ENTER TO CONTINUE ==");
                        verif = "y";
                        try {
                            System.in.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Prompt.clear();
                    }
                    else {
                        System.out.print("Choose a save file {1-"+(result.size())+"}\n> ");
                        saveS = sc.nextLine();
                        try {
                            save = Integer.parseInt(saveS);
                        } catch (NumberFormatException e) {
                            save = -1;
                        }
                        if (save>0 && save<=(result.size())) {
                            verif = "y";
                            ret = result.get(save-1).substring(14);
                        }
                    }
                    System.out.println();
                } while (!verif.equals("y"));
            }
        } while (!verif.equals("y"));

        return ret;
    }
}