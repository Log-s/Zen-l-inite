package view.grid;

import javax.swing.JButton;
import javax.swing.JPanel;

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
        this.add(play);
        this.add(rules);
        this.add(quit);
    }
    
}