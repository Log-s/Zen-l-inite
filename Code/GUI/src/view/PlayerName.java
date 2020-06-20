package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

/**
 * class that displays the name panel
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class PlayerName extends JPanel {

    public static JButton go;
    public static JButton nameBack;
    public static JTextField player1;
    public static JTextField player2;
    public static JLabel error;
    
    /**
     * Creates the PlayerName Panel
     * @param f the main frame on wich to apply the panel
     */
    public PlayerName(MainWindow f) {

        JLabel lbPlayer1 = new JLabel("Player 1");
        player1 = new JTextField();
        lbPlayer1.setForeground(Color.WHITE);
        lbPlayer1.setFont(new Font("Montserrat Medium",Font.BOLD,15));

        JLabel lbPlayer2 = new JLabel("Player 2");
        player2 = new JTextField();
        lbPlayer2.setForeground(Color.WHITE);
        lbPlayer2.setFont(new Font("Montserrat Medium",Font.BOLD,15));

        if (GameMode.mode.equals("HA")) {
            player2.setEnabled(false);
        }

        go = new JButton();
        go.addActionListener(new ListenerButtonGame(f));
        go.setIcon(new ImageIcon(new ImageIcon("../data/images/goButton.jpg").getImage().getScaledInstance(225, 100, java.awt.Image.SCALE_SMOOTH)));

        error = new JLabel("You must fill the available fields");
        error.setForeground(Color.RED);
        error.setVisible(false);

        nameBack = new JButton();
        nameBack.addActionListener(new ListenerButtonGame(f));
        nameBack.setIcon(new ImageIcon(new ImageIcon("../data/images/backButton.jpg").getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH)));

        this.setLayout(new GridLayout(2,1));
        JPanel pane1 = new JPanel();
        pane1.setLayout(new GridLayout(4,3,50,10));
        pane1.setOpaque(false);
        JPanel pane2 = new JPanel();
        pane2.setLayout(new GridLayout(1,2,50,50));
        pane2.setOpaque(false);
        pane2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panePlayer1 = new JPanel();
        panePlayer1.setLayout(new GridLayout(1,2));
        panePlayer1.add(lbPlayer1);
        panePlayer1.add(player1);
        panePlayer1.setOpaque(false);
        panePlayer1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel panePlayer2 = new JPanel();
        panePlayer2.setLayout(new GridLayout(1,2));
        panePlayer2.add(lbPlayer2);
        panePlayer2.add(player2);
        panePlayer2.setOpaque(false);
        panePlayer2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel paneGo = new JPanel();
        paneGo.setLayout(new GridLayout(1,1));
        paneGo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        paneGo.add(go);
        paneGo.setOpaque(false);



        this.add(new JLabel());
        this.add(pane1);
        pane1.add(new JLabel());
        pane1.add(panePlayer1);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(panePlayer2);
        pane1.add(error);
        pane1.add(new JLabel());
        pane1.add(paneGo);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(pane2);
        pane2.add(new JLabel());
        pane2.add(nameBack);

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