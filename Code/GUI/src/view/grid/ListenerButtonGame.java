package view.grid;

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
            System.out.println("Button QUIT");
            this.f.quit();
        }

        else if (e.getSource() == MainMenu.rules) {
            
        }

        else if (e.getSource() == MainMenu.play) {

        }
    }
}