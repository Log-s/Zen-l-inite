package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rules extends JPanel {

    public static JButton back;
    
    public Rules(MainWindow f) {

        JLabel rules = new JLabel("Rules are comming soon !");
        this.add(rules);

        back = new JButton("Back");
        back.addActionListener(new ListenerButtonGame(f));
        this.add(back);
    }
}