package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane.*;
import javax.swing.JPanel;

import model.Difficulty;
import model.Game;
import model.Mode;
import util.Save;
import view.Lanceur;
import view.Pause;
import view.MainMenu;

import java.awt.*;


public class MainWindow extends JFrame {
    
    private JPanel mainMenu;
    private JPanel game;
    private JPanel pause;
    private JPanel rules;
    private JPanel gameMode;
    private JPanel playerName;
    private JPanel saves;
    private CardLayout layout = new CardLayout();
    private Game gameInstance;

    public MainWindow() {

        this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(900,600));
        this.getContentPane().setLayout(layout);

        this.pause = new Pause(this);
        this.mainMenu = new MainMenu(this);
        this.rules = new Rules(this);
        this.gameMode = new GameMode(this);
        this.saves = new Saves(this);

        this.add(this.mainMenu, "mainMenu");
        this.add(this.pause, "pause");
        this.add(this.rules, "rules");
        this.add(this.gameMode, "gameMode");
        this.add(this.saves, "saves");
        this.pack();
        this.setVisible(true);
        
    }

    public void goToGame() {
        if (GameMode.mode.equals("HH")) {
            this.gameInstance = new Game(PlayerName.player1.getText(),PlayerName.player2.getText(),Mode.HH);
        }
        else  {
            String[] names = {"Alex","Jimmy","Tom","Albert","Rosie"};
            int i = (int) (Math.random() * 5);
            String name = "bot "+names[i];
            this.gameInstance = new Game(PlayerName.player1.getText(),name,Mode.HA, Difficulty.RANDOM);
        }
        this.game = new Lanceur(this.gameInstance, this);
        this.add(this.game, "game");
        this.layout.show(this.getContentPane(), "game");
    }

    public void goToPause() {
        this.layout.show(this.getContentPane(), "pause");
    }

    public void goToQuitSave() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to save the on going game ?", "Save",JOptionPane.YES_NO_CANCEL_OPTION);
        if(dialogResult == JOptionPane.NO_OPTION){
            this.goToMainMenu();
        }
        else if (dialogResult == JOptionPane.YES_OPTION){
            String name = JOptionPane.showInputDialog(null, "Enter a save name", "Save Name", JOptionPane.QUESTION_MESSAGE);
            while (name.equals("") || name == null) {
                JOptionPane.showMessageDialog(null, "Invalid Name", "Error", JOptionPane.ERROR_MESSAGE);
                name = JOptionPane.showInputDialog("Enter a save name");
            }
            Save.writeSave(name, this.gameInstance);
            this.goToMainMenu();
        }
    }

    public void goToRules() {
        this.layout.show(this.getContentPane(), "rules");
    }

    public void goToMainMenu() {
        this.layout.show(this.getContentPane(), "mainMenu");
    }

    public void goToGameMode() {
        this.layout.show(this.getContentPane(), "gameMode");
    }

    public void goToNames() {
        this.playerName = new PlayerName(this);
        this.add(this.playerName, "playerName");
        this.layout.show(this.getContentPane(), "playerName");
    }

    public void quit() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit ?", "Quit",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    public void goToSaves() {
        this.layout.show(this.getContentPane(), "saves");
    }
}