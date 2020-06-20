package view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * class that handles every button event
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class ListenerButtonGame implements ActionListener {
    
    private MainWindow f;

    /**
     * Creates the Listener
     * @param f MainWindow that posesses the main methods
     */
    public ListenerButtonGame(MainWindow f) {
        this.f = f;
    }

    /**
     * Method when a button is clicked
     * @param e Event
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == PlayPanel.pause) {
            this.f.goToPause();
        }

        else if (e.getSource() == PlayPanel.exit) {
            this.f.goToQuitSave();
        }

        else if (e.getSource() == MainMenu.quit) {
            this.f.quit();
        }

        else if (e.getSource() == MainMenu.rules) {
            this.f.goToRules();
        }

        else if (e.getSource() == MainMenu.play) {
            this.f.goToSaves();
        }

        else if (e.getSource() == GameMode.HA) {
            GameMode.mode = "HA";
            this.f.goToNames();
        }

        else if (e.getSource() == GameMode.HH) {
            GameMode.mode = "HH";
            this.f.goToNames();
        }

        else if (e.getSource() == GameMode.modeBack) {
            this.f.goToSaves();
        }

        else if (e.getSource() == PlayerName.go) {
            if ((GameMode.mode.equals("HA") && PlayerName.player1.getText().equals("")) || (GameMode.mode.equals("HH") && (PlayerName.player1.getText().equals("") || PlayerName.player2.getText().equals("")))) {
                PlayerName.error.setVisible(true);
            }
            else {
                this.f.goToGame();
            }
        }

        else if (e.getSource() == PlayerName.nameBack) {
            this.f.goToGameMode();
        }

        else if (e.getSource() == Rules.back) {
            this.f.goToMainMenu();
        }

        else if (e.getSource() == Saves.newGame) {
            this.f.goToGameMode();
        }

        else if (e.getSource() == Saves.loadGame) {
            this.f.goToSavesList();
        }

        else if (e.getSource() == Saves.savesBack) {
            this.f.goToMainMenu();
        }

        else if (e.getSource() == SavesList.savesListBack) {
            this.f.goToSaves();
        }

        else if (e.getSource() == SavesList.go) {
            this.f.goToGameLoaded(SavesList.list.getSelectedValue().toString());
        }
    }
}