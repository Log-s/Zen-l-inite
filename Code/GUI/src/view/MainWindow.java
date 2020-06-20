package view;

import model.Difficulty;
import model.Game;
import model.Mode;
import util.Save;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Dimension;

/**
 * class that displays the playing board
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class MainWindow extends JFrame {
    
    private JPanel mainMenu;
    private JPanel game;
    private JPanel pause;
    private JPanel rules;
    private JPanel gameMode;
    private JPanel playerName;
    private JPanel saves;
    private JPanel savesList;
    private CardLayout layout = new CardLayout();
    private Game gameInstance;

    /**
     * creates the main frame
     */
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
        this.savesList = new SavesList(this);

        this.add(this.mainMenu, "mainMenu");
        this.add(this.pause, "pause");
        this.add(this.rules, "rules");
        this.add(this.gameMode, "gameMode");
        this.add(this.saves, "saves");
        this.add(this.savesList, "savesList");
        this.pack();
        this.setVisible(true);
        
    }

    /**
     * goes to the game tab, and creates the game instance
     */
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
        this.game = new PlayPanel(this.gameInstance, this);
        this.add(this.game, "game");
        this.layout.show(this.getContentPane(), "game");
    }

    /**
     * goes to the pause tab
     */
    public void goToPause() {
        this.layout.show(this.getContentPane(), "pause");
    }

    /**
     * lauches the save procedure
     */
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

    /**
     * goes to the rules tab
     */
    public void goToRules() {
        this.layout.show(this.getContentPane(), "rules");
    }

    /**
     * goes to the main menu
     */
    public void goToMainMenu() {
        this.layout.show(this.getContentPane(), "mainMenu");
    }

    /**
     * goes to the gamemode choice tab
     */
    public void goToGameMode() {
        this.layout.show(this.getContentPane(), "gameMode");
    }

    /**
     * goes to names choice tab
     */
    public void goToNames() {
        this.playerName = new PlayerName(this);
        this.add(this.playerName, "playerName");
        this.layout.show(this.getContentPane(), "playerName");
    }

    /**
     * lauches the quit procedure
     */
    public void quit() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit ?", "Quit",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    /**
     * goes to new/load game choice tab
     */
    public void goToSaves() {
        this.layout.show(this.getContentPane(), "saves");
    }

    /**
     * goes to the saves tab
     */
    public void goToSavesList() {
        this.layout.show(this.getContentPane(), "savesList");
    }

    /**
     * goes to the game tab when the game is loaded from save
     */
    public void goToGameLoaded(String filename) {
        this.gameInstance = Save.readSave(filename);
        this.game = new PlayPanel(this.gameInstance, this);
        this.add(this.game, "game");
        this.layout.show(this.getContentPane(), "game");
    }
}