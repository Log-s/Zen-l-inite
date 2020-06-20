package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * class that displays the pause panel
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class Pause extends JPanel {

    /**
     * Creates the pause Panel
     * @param f the main frame on wich to apply the panel
     */
    public Pause(MainWindow f) {

        this.setLayout(new GridLayout(1,1));

        JButton icon = new JButton(new ImageIcon("../data/images/Pause.png"));
        icon.setBorder(BorderFactory.createEmptyBorder());
        icon.addActionListener(new ListenerPause(f));
        this.add(icon);
    }
}