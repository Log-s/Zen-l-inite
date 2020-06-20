package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.GridLayout;


/**
 * class that displays new/load game panel
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class Saves extends JPanel {

    public static JButton newGame;
    public static JButton loadGame;
    public static JButton savesBack;

    /**
     * Creates the save Panel
     * @param f the main frame on wich to apply the panel
     */
    public Saves(MainWindow f) {

        newGame = new JButton();
        newGame.addActionListener(new ListenerButtonGame(f));
        newGame.setIcon(new ImageIcon(new ImageIcon("../data/images/newGameButton.jpg").getImage().getScaledInstance(265, 80, java.awt.Image.SCALE_SMOOTH)));
        this.add(newGame);
        
        loadGame = new JButton();
        loadGame.addActionListener(new ListenerButtonGame(f));
        loadGame.setIcon(new ImageIcon(new ImageIcon("../data/images/loadGameButton.jpg").getImage().getScaledInstance(265, 80, java.awt.Image.SCALE_SMOOTH)));
        this.add(loadGame);

        savesBack = new JButton();
        savesBack.addActionListener(new ListenerButtonGame(f));
        savesBack.setIcon(new ImageIcon(new ImageIcon("../data/images/backButton.jpg").getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH)));
        this.add(savesBack);

        this.setLayout(new GridLayout(2,1));
        JPanel pane1 = new JPanel();
        pane1.setLayout(new GridLayout(4,3,50,10));
        pane1.setOpaque(false);
        JPanel pane2 = new JPanel();
        pane2.setLayout(new GridLayout(1,2,50,50));
        pane2.setOpaque(false);
        pane2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.add(new JLabel());
        this.add(pane1);
        pane1.add(new JLabel());
        pane1.add(newGame);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(loadGame);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(pane2);
        pane2.add(new JLabel());
        pane2.add(savesBack);
    }

    /**
     * repaints the background with an image
     * @param g
     */
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("../data/images/MenuBackground.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
}