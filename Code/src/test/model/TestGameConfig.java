package test.model;

import org.junit.*;
import static org.junit.Assert.*;

import model.GameConfig;

public class TestGameConfig {

    GameConfig g;



    /**
     * setUp
     * Creates the test object before every test
     */
    @Before()
    public void setUp() {
        g = new GameConfig();
    }

    /**
     * tearDown
     * Removes every link to objects (for the GC to do it's work)
     */
    @After()
    public void tearDown() {
        g = null;
    }



    /**
     * Tests if the pickStartPlayer works
     * Doing 4 sepreate tests, to have little chance of getting 4 times the same result
     */
    @Test()
    public void testPickStartPlayer() {
        Boolean b1 = g.pickStartPlayer();
        Boolean b2 = g.pickStartPlayer();
        Boolean b3 = g.pickStartPlayer();
        Boolean b4 = g.pickStartPlayer();
        if (b1 == b2 && b2 == b3 && b3 == b4) {
            assertEquals(true, true);
        }
        else {
            assertEquals(true, false);
        }
    }
    
}