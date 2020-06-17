package test.util;

import org.junit.*;
import static org.junit.Assert.*;

import model.Game;
import util.Save;
import model.Mode;

public class TestSave {

    /**
     * Tests if a saved game loads the same way
     */
    @Test()
    public void testSaveLoad() {
        Game g1 = new Game("Player1", "Player1", Mode.HH);
        Save.writeSave("JUNIT_Save", g1);
        Game g2 = Save.readSave("JUNIT_Save");
        assertEquals(g1, g2);
    }

}