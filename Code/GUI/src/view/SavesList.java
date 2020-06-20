package view;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * class that displays saves and allow you to pick one
 * 
 * @author Léo DESMONTS - IUT VANNES - 2020
 * @version 1.0
 */
public class SavesList extends JPanel {

    public static JList list;
    public static JButton savesListBack;
    public static JButton go;
    
    /**
     * Creates the saveList Panel
     * @param f the main frame on wich to apply the panel
     */
    public SavesList(MainWindow f) {

        DefaultListModel listModel = new DefaultListModel();
        List<String> saves = this.getSaves();
        for (String s : saves) {
            listModel.addElement(s.substring(12));
        }
        list = new JList(listModel);
        list.setOpaque(false);
        list.setFont(new Font("Montserrat Medium",Font.BOLD,25));

        savesListBack = new JButton();
        savesListBack.addActionListener(new ListenerButtonGame(f));
        savesListBack.setIcon(new ImageIcon(new ImageIcon("../data/images/backButton.jpg").getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH)));

        go = new JButton();
        go.addActionListener(new ListenerButtonGame(f));
        go.setIcon(new ImageIcon(new ImageIcon("../data/images/goButton.jpg").getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH)));

        this.setLayout(new GridLayout(2,1));
        JPanel pane1 = new JPanel();
        pane1.setLayout(new BorderLayout());
        pane1.setOpaque(false);
        JPanel pane2 = new JPanel();
        pane2.setLayout(new GridLayout(1,3,50,50));
        pane2.setOpaque(false);
        pane2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel pane3 = new JPanel();
        pane3.setLayout(new GridLayout(1,5,95,50));
        pane3.setPreferredSize(new Dimension(800,70));
        pane3.setOpaque(false);
        pane3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.add(new JLabel());
        this.add(pane1);
        pane1.add(pane2, BorderLayout.CENTER);
        pane1.add(pane3, BorderLayout.SOUTH);
        pane2.add(new JLabel());
        pane2.add(list);
        pane2.add(new JLabel());
        pane3.add(new JLabel());
        pane3.add(new JLabel());
        pane3.add(new JLabel());
        pane3.add(go);
        pane3.add(savesListBack);
    }


    /**
     * retrieves the saves from the save folder
     */
    public List<String> getSaves() {

        List<String> result = null;
        try (Stream<Path> walk = Files.walk(Paths.get("../../saves/"))) {

            result = walk.filter(Files::isRegularFile)
                .map(x -> x.toString()).collect(Collectors.toList());
                    
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        int i=1;
        while (i-1<result.size()) {
            if (result.get(i-1).equals("../../saves/emptyFileForGit")) {
                result.remove(i-1);
            }
            i++;
        }

        return result;

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