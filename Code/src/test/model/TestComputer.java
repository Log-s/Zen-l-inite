package test.model;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Computer;
import model.Difficulty;
import model.Pawn;

public class TestComputer {

    private Computer c;

    /**
     * setUp
     * Creates the test object before every test
     */
    @Before()
    public void setUp() {
        ArrayList<Pawn> pawnList = new ArrayList<Pawn>();
        c = new Computer("Bot1", pawnList, Difficulty.EASY);
    }

    /**
     * tearDown
     * Removes every link to objects (for the GC to do it's work)
     */
    @After()
    public void tearDown() {
        c = null;
    }



    /**
     * Tests if computer exists
     */
    @Test()
    public void testExists() {
        assertNotNull(c);
    }



    /**
     * Tests if name getter works
     */
    @Test()
    public void testGetName() {
        assertEquals("Bot1", c.getName());
    }



    /**
     * Tests if difficulty getter works
     */
    @Test()
    public void testGetDifficulty() {
        assertEquals(Difficulty.EASY, c.getDifficulty());
    }



    /**
     * Tests if the toString method works
     */
    @Test()
    public void testToString() {
        String expected = "Computer\nName : Bot1";
        String test = c.toString();
        assertEquals(expected, test);
    }

}