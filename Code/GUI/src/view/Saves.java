package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Saves extends JPanel {

    public static JButton newGame;
    public static JButton loadGame;
    public static JButton savesBack;

    public Saves(MainWindow f) {

        newGame = new JButton("New Game");
        newGame.addActionListener(new ListenerButtonGame(f));
        this.add(newGame);
        
        loadGame = new JButton("Load Game");
        loadGame.addActionListener(new ListenerButtonGame(f));
        this.add(loadGame);

        savesBack = new JButton("Back");
        savesBack.addActionListener(new ListenerButtonGame(f));
        this.add(savesBack);
    }

    public static void displaySaves() {

        List<String> result = null;
        try (Stream<Path> walk = Files.walk(Paths.get("../data/saves/"))) {

            result = walk.filter(Files::isRegularFile)
                .map(x -> x.toString()).collect(Collectors.toList());
                    
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        int i=1;
        while (i-1<result.size()) {
            if (result.get(i-1).equals("../data/saves/emptyFileForGit")) {
                result.remove(i-1);
            }
            else {
                System.out.println(i+") "+result.get(i-1).substring(14));
                i++;
            }
        }

    }
    
}