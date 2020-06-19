package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerName extends JPanel {

    public static JButton go;
    public static JButton nameBack;
    public static JTextField player1;
    public static JTextField player2;
    public static JLabel error;
    
    public PlayerName(MainWindow f) {

        JLabel lbPlayer1 = new JLabel("Player 1");
        player1 = new JTextField();
        player1.setPreferredSize(new Dimension(100,20));

        JLabel lbPlayer2 = new JLabel("Player 2");
        player2 = new JTextField();
        player2.setPreferredSize(new Dimension(100,20));

        this.add(lbPlayer1);
        this.add(player1);
        this.add(lbPlayer2);
        this.add(player2);

        if (GameMode.mode.equals("HA")) {
            player2.setEnabled(false);
        }

        go = new JButton("Go");
        go.addActionListener(new ListenerButtonGame(f));
        this.add(go);

        error = new JLabel("You must fill the available fields");
        error.setForeground(Color.RED);
        this.add(error);
        error.setVisible(false);

        nameBack = new JButton("Back");
        nameBack.addActionListener(new ListenerButtonGame(f));
        this.add(nameBack);

    }
}