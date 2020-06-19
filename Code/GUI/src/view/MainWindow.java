package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane.*;
import javax.swing.JPanel;

import model.Game;
import view.grid.Lanceur;
import view.grid.Pause;
import view.grid.MainMenu;

import java.awt.*;


public class MainWindow extends JFrame {
    
    private JPanel mainMenu;
    private JPanel game;
    private JPanel pause;
    private CardLayout layout = new CardLayout();

    public MainWindow(Game g) {

        this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(900,600));
        this.getContentPane().setLayout(layout);

        this.game = new Lanceur(g, this);
        this.pause = new Pause(this);
        this.mainMenu = new MainMenu(this);

        this.add(game, "game");
        this.add(pause, "pause");
        this.add(mainMenu, "mainMenu");
        this.pack();
        this.setVisible(true);
        
    }

    public void goToGame() {
        this.layout.show(this.getContentPane(), "game");
    }

    public void goToPause() {
        this.layout.show(this.getContentPane(), "pause");
    }

    public void goToQuitSave() {
        System.out.println("Save procedure");
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to save the on going game ?", "Save",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.NO_OPTION){
            this.goToMainMenu();
        }
        else if (dialogResult == JOptionPane.YES_OPTION){
            String name = JOptionPane.showInputDialog(null, "Enter a save name", "Save Name", JOptionPane.QUESTION_MESSAGE);
            while (name.equals("") || name == null) {
                JOptionPane.showMessageDialog(null, "Invalid Name", "Error", JOptionPane.ERROR_MESSAGE);
                name = JOptionPane.showInputDialog("Enter a save name");
            }
            //save
            this.goToMainMenu();
        }
    }

    public void goToMainMenu() {
        this.layout.show(this.getContentPane(), "mainMenu");
    }

    public void goToGameMode() {

    }

    public void goToNames() {

    }

    public void quit() {
        System.out.println("QUIT");
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit ?", "Quit",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
}