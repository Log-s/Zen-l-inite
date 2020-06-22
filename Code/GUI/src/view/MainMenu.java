package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.GridLayout;

/**
 * class that displays main menu
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class MainMenu extends JPanel {

    public static JButton play;
    public static JButton rules;
    public static JButton quit;

    /**
     * Creates the MainMenu Panel
     * @param f the main frame on wich to apply the panel
     */
    public MainMenu(MainWindow f) {

        play = new JButton();
        play.addActionListener(new ListenerButtonGame(f));
        play.setIcon(new ImageIcon(new ImageIcon("../data/images/playButton.jpg").getImage().getScaledInstance(265, 100, java.awt.Image.SCALE_SMOOTH)));
        rules = new JButton();
        rules.addActionListener(new ListenerButtonGame(f));
        rules.setIcon(new ImageIcon(new ImageIcon("../data/images/rulesButton.jpg").getImage().getScaledInstance(265, 100, java.awt.Image.SCALE_SMOOTH)));
        quit = new JButton();
        quit.addActionListener(new ListenerButtonGame(f));
        quit.setIcon(new ImageIcon(new ImageIcon("../data/images/quitButton.jpg").getImage().getScaledInstance(265, 100, java.awt.Image.SCALE_SMOOTH)));

        JPanel pane1 = new JPanel();

        this.setLayout(new GridLayout(2,1));
        pane1.setLayout(new GridLayout(4,3,50,10));
        pane1.setOpaque(false);

        this.add(new JLabel());
        this.add(pane1);
        pane1.add(new JLabel());
        pane1.add(play);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(rules);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(quit);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());

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