package view;

import java.awt.event.*;

import view.MainWindow;

public class ListenerPause implements ActionListener {

    private MainWindow f;

    public ListenerPause(MainWindow f) {
        this.f = f;
    }

    public void actionPerformed(ActionEvent e) {
        this.f.goToGame();
	}
}