package test.model;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Human;
import model.Pawn;

public class TestHuman {

    private Human h;

    /**
     * setUp
     * Creates the test object before every test
     */
    @Before()
    public void setUp() {
        ArrayList<Pawn> pawnList = new ArrayList<Pawn>();
        h = new Human("Player1", pawnList);
    }

    /**
     * tearDown
     * Removes every link to objects (for the GC to do it's work)
     */
    @After()
    public void tearDown() {
        h = null;
    }



    /**
     * Tests if human exists
     */
    @Test()
    public void testExists() {
        assertNotNull(h);
    }



    /**
     * Tests if name getter works
     */
    @Test()
    public void testGetName() {
        assertEquals("Player1", h.getName());
    }



    /**
     * Tests if the toString method works
     */
    @Test()
    public void testToString() {
        String expected = "Human\nName : Player1";
        String test = h.toString();
        assertEquals(expected, test);
    }

}