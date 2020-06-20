package view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * class that handles the pause button on the playing interface
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class ListenerPause implements ActionListener {

    private MainWindow f;

    /**
     * creates the listener
     * @param f the main frame which contains the methods
     */
    public ListenerPause(MainWindow f) {
        this.f = f;
    }

    /**
     * Goes back to the game
     */
    public void actionPerformed(ActionEvent e) {
        this.f.goToGame();
	}
}