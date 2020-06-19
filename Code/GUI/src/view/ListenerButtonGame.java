package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.MainWindow;

import java.awt.*;

import java.awt.event.*;

public class ListenerButtonGame implements ActionListener {
    
    private MainWindow f;

    public ListenerButtonGame(MainWindow f) {
        this.f = f;

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Lanceur.pause) {
            this.f.goToPause();
        }

        else if (e.getSource() == Lanceur.exit) {
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
            System.out.println("Load Game");
            Saves.displaySaves();
        }

        else if (e.getSource() == Saves.savesBack) {
            this.f.goToMainMenu();
        }
    }
}