package view;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

import view.MainWindow;

public class MainMenu extends JPanel {

    public static JButton play;
    public static JButton rules;
    public static JButton quit;

    public MainMenu(MainWindow f) {
        //title

        play = new JButton("Play");
        play.addActionListener(new ListenerButtonGame(f));
        rules = new JButton("Rules");
        rules.addActionListener(new ListenerButtonGame(f));
        quit = new JButton("Quit");
        quit.addActionListener(new ListenerButtonGame(f));

        JPanel pane1 = new JPanel();

        this.setLayout(new GridLayout(2,1));
        pane1.setLayout(new GridLayout(4,3,50,10));
        pane1.setOpaque(false);

        this.add(new JLabel());
        this.add(pane1);
        pane1.add(new JLabel());
        pane1.add(this.play);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(this.rules);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(this.quit);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());

    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("../data/images/MenuBackground.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
}