package view;

import model.Game;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;

/**
 * class that displays the playing panel
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class PlayPanel extends JPanel {

	Board board;
	public static JLabel turn;
	public static JButton pause;
	public static JButton exit;

	/**
     * Creates the PlayPanel Panel
     * @param f the main frame on wich to apply the panel
     */
	public PlayPanel(Game g, MainWindow f) {

		this.setLayout(new BorderLayout(0,0));

		turn = new JLabel();
		turn.setFont(new java.awt.Font("Montserrat Medium",Font.BOLD,20));
		turn.setHorizontalAlignment(JLabel.CENTER);
		turn.setForeground(Color.WHITE);

		board = new Board(g);
		JPanel menu = new JPanel();
		JPanel menuButton = new JPanel();
		pause = new JButton();
		pause.addActionListener(new ListenerButtonGame(f));
		pause.setIcon(new ImageIcon(new ImageIcon("../data/images/woodTexturePauseButton.jpg").getImage().getScaledInstance(140, 60, java.awt.Image.SCALE_SMOOTH)));
		exit = new JButton();
		exit.addActionListener(new ListenerButtonGame(f));
		exit.setIcon(new ImageIcon(new ImageIcon("../data/images/woodTextureExitButton.jpg").getImage().getScaledInstance(140, 60, java.awt.Image.SCALE_SMOOTH)));
		menu.setLayout(new GridLayout(2,1,0,30));
		menu.setPreferredSize(new Dimension(300,600));
		menu.setOpaque(false);
		menuButton.setLayout(new GridLayout(3,2, 10, 50));
		menuButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		menuButton.add(new JLabel());
		menuButton.add(new JLabel());
		menuButton.add(pause);
		menuButton.add(exit);
		menuButton.setOpaque(false);
		menu.add(turn);
		menu.add(menuButton);

		validate();

		this.add(board);
		this.add(menu, BorderLayout.WEST);
		this.add(board, BorderLayout.CENTER);

		this.setVisible(true);
	}

	/**
	 * reaches out to the update method of board
	 */
	public void update() {
		board.update();
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
