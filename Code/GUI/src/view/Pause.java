package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import view.MainWindow;
import java.awt.*;

public class Pause extends JPanel {

    public Pause(MainWindow f) {

        this.setLayout(new GridLayout(1,1));

        JButton icon = new JButton(new ImageIcon("../data/images/Pause.png"));
        icon.setBorder(BorderFactory.createEmptyBorder());
        icon.addActionListener(new ListenerPause(f));
        this.add(icon);
    }
}