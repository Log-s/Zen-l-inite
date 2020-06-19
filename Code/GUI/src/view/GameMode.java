package view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameMode extends JPanel {

    public static JButton HH;
    public static JButton HA;
    public static JButton modeBack;
    public static String mode;

    public GameMode(MainWindow f) {

        HH = new JButton("HH");
        HH.addActionListener(new ListenerButtonGame(f));
        this.add(HH);
        
        HA = new JButton("HA");
        HA.addActionListener(new ListenerButtonGame(f));
        this.add(HA);

        modeBack = new JButton("Back");
        modeBack.addActionListener(new ListenerButtonGame(f));
        this.add(modeBack);

    }
    
}