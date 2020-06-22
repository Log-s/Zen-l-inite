package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


/**
 * class that displays the rule panel
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class Rules extends JPanel {

    public static JButton back;
    
    /**
     * Creates the rule Panel
     * @param f the main frame on wich to apply the panel
     */
    public Rules(MainWindow f) {

        String ruleTab = new String(new char[37]).replace("\0", "&nbsp;");
        String ruleText = "<html><body width='%1s'><h1>Rules</h1>"
            + "<p>&nbsp;&nbsp;&nbsp;&nbsp;[¤] Goal :</p>"
            + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The winner is the first player to create a chain with all of his remaining pawns (including the ZEN)</p>"
            + "<p></p>"
            + "<p>&nbsp;&nbsp;&nbsp;&nbsp;[¤] Rules :</p>"
            + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;┌─ Rule 1° :</p>"
            + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└──────────╼ One can move his pawns in any direction (horizontal, vertical, diagonal)</p>"
            + "<p>"+ruleTab+"A pawn moves as many squares as there are pawns on its movement line (including itself,&nbsp;</p>"
            + "<p>"+ruleTab+"the opponent's pawns and the ZEN pawn)</p>"
            + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;┌─ Rule 2° :</p>"
            + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└──────────╼ A pawn can step over any friendly pawn, but is blocked by the opponent's pawns</p>"
            + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;┌─ Rule 3° :</p>"
            + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└──────────╼ If a pawn stops exactly on a opponent's pawn, it replaces it on the square, and the</p>"
            + "<p>"+ruleTab+"opponnent's pawn is taken off the board</p>"
            + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;┌─ Rule 4° :</p>"
            + "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└──────────╼ The ZEN pawn can be considered as a friendly pawn (step over it, move it) or as a</p>"
            + "<p>"+ruleTab+"opponent's pawn (remove it from board) idenpendently at each turn.</p>"
            + "<p>"+ruleTab+"The ZEN pawn CANNOT be moved back to its previous location by the next player on the very</p>"
            + "<p>"+ruleTab+"next move.</p>"
            + "<p>"+ruleTab+"The ZEN pawn CANNOT be moved unless another pawn is position right next to it (in any</p>"
            + "<p>"+ruleTab+"direction)</p>"
            + "<p></p>"
            + "<p>Have fun !</p>"
            + "<p>Author : Léo DESMONTS - IUT Vannes - 2020</p>"
            + "<p>Graphical version</p>";

        JLabel rules = new JLabel(ruleText);
        rules.setForeground(Color.decode("#2d1e19"));
        rules.setFont(new Font("Montserrat Medium",Font.BOLD,15));
        rules.setOpaque(true);

        back = new JButton();
        back.addActionListener(new ListenerButtonGame(f));
        back.setIcon(new ImageIcon(new ImageIcon("../data/images/backButton.jpg").getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH)));

        this.setLayout(new BorderLayout());
        rules.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(rules, BorderLayout.CENTER);
        JPanel pane1 = new JPanel();
        pane1.setPreferredSize(new Dimension(800,68));
        pane1.setLayout(new GridLayout(1,5,100,10));
        pane1.setOpaque(false);
        pane1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(pane1, BorderLayout.SOUTH);
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(new JLabel());
        pane1.add(back);
    }
}