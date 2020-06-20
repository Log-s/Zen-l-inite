package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Graphics;

/**
 * class that displays the game mode choice windows
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class GameMode extends JPanel {

    public static JButton HH;
    public static JButton HA;
    public static JButton modeBack;
    public static String mode;

    /**
     * Creates the GameMode Panel
     * @param f the main frame on wich to apply the panel
     */
    public GameMode(MainWindow f) {

        HH = new JButton();
        HH.addActionListener(new ListenerButtonGame(f));
        HH.setIcon(new ImageIcon(new ImageIcon("../data/images/player2Button.jpg").getImage().getScaledInstance(265, 100, java.awt.Image.SCALE_SMOOTH)));
        this.add(HH);
        
        HA = new JButton();
        HA.addActionListener(new ListenerButtonGame(f));
        HA.setIcon(new ImageIcon(new ImageIcon("../data/images/player1Button.jpg").getImage().getScaledInstance(265, 100, java.awt.Image.SCALE_SMOOTH)));
        this.add(HA);

        modeBack = new JButton();
        modeBack.addActionListener(new ListenerButtonGame(f));
        modeBack.setIcon(new ImageIcon(new ImageIcon("../data/images/backButton.jpg").getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH)));
        this.add(modeBack);

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
        pane1.add(HH);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(HA);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(pane2);
        pane2.add(new JLabel());
        pane2.add(modeBack);

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