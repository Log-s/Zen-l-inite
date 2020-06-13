package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Game;

/**
 * This class offers two static method, to save and load a game to/from a file
 * (Serialized).
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class Save {

    /**
     * writeSave allows you to save an ongoing game, to continue later
     * 
     * @param fileName name of the save. The path is fix, and defined in the
     *                 method's code.
     * @param game     Game object to save
     */
    public static void writeSave(String fileName, Game game) {

        System.out.println("saving...");

        if (fileName == null) {
            System.err.println("[!] Error - null value \"fileName\" | util.Save.writeSave(String fileName, Game game)");
        } else if (fileName.equals("")) {
            System.err.println("[!] Error - \"fileName\" can not be empty | util.Save.writeSave(String fileName, Game game)");
        } else if (game == null) {
            System.err.println("[!] Error - null value \"game\" | util.Save.writeSave(String fileName, Game game)");
        } else {

            String path = "../data/saves/" + fileName;

            try {
                FileOutputStream filePath = new FileOutputStream(path);
                ObjectOutputStream file = new ObjectOutputStream(filePath);

                file.writeObject(game);

                file.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done");

    }


    
    /**
     * readSave allows you to read a saved game to load and play.
     * 
     * @param fileName name of the save.
     * @return a Game object that will be loaded by the app.
     */
    public static Game readSave(String fileName) {
        return new Game();
    }

}