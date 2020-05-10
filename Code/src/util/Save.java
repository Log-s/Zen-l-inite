package util;

import model.Game;

/**
 * This class offers two static method, to save and load a game to/from a file (Serialized).
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class Save {



    /**
     * writeSave allows you to save an ongoing game, to continue later
     * 
     * @param fileName name of the save. The path is fix, and defined in the method's code.
     * @param game Game object to save
     */
    public static void writeSave (String fileName, Game game) {

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