package view;

import model.Game;
import view.MainWindow;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


public class Lanceur extends JPanel {

	Plateau board;
	public static JLabel turn;
	public static JButton pause;
	public static JButton exit;

	public Lanceur(Game g, MainWindow f) {

		this.setLayout(new BorderLayout(0,0));

		turn = new JLabel();
		turn.setFont(new java.awt.Font("Montserrat Medium",Font.BOLD,20));
		turn.setHorizontalAlignment(JLabel.CENTER);
		turn.setBackground(Color.decode("#83502e"));
		turn.setForeground(Color.BLACK);

		board = new Plateau(g);
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
		menu.setBackground(Color.decode("#83502e"));
		menuButton.setLayout(new GridLayout(3,2, 10, 50));
		menuButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		menuButton.add(new JLabel());
		menuButton.add(new JLabel());
		menuButton.add(pause);
		menuButton.add(exit);
		menuButton.setBackground(Color.decode("#83502e"));
		menu.add(turn);
		menu.add(menuButton);

		validate();

		this.add(board);
		this.add(menu, BorderLayout.WEST);
		this.add(board, BorderLayout.CENTER);

		this.setVisible(true);
	}

	public void update() {
		board.update();
	}


}
