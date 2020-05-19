package test.model;

import org.junit.*;
import static org.junit.Assert.*;

import model.Pawn;
import model.Color;

public class TestPawn {
    
    private Pawn pW;
    private Pawn pB;
    private Pawn pZ;

    /**
     * setUp
     * Creates the test object before every test
     */
    @Before()
    public void setUp() {
        pW = new Pawn(Color.WHITE);
        pB = new Pawn(Color.BLACK);
        pZ = new Pawn(Color.ZEN);
    }



    /**
     * tearDown
     * Removes every link to objects (for the GC to do it's work)
     */
    @After()
    public void tearDown() {
        pW = null;
        pB = null;
        pZ = null;
    }



    /**
     * tests if the pawns exists
     */
    @Test()
    public void testExists() {
        assertNotNull(pW);
        assertNotNull(pB);
        assertNotNull(pZ);
    }



    /**
     * Tests if the color getter works
     */
    @Test()
    public void testGetColor() {
        assertEquals(Color.WHITE, pW.getColor());
        assertEquals(Color.BLACK, pB.getColor());
        assertEquals(Color.ZEN, pZ.getColor());
    }



    /**
     * Tests if the Position Setters/Getters work
     */
    @Test()
    public void testPostionGettersSetter() {
        assertEquals(0, pW.getXPos());
        assertEquals(0, pW.getYPos());
        pW.setPosition(3, 5);
        assertEquals(3, pW.getXPos());
        assertEquals(5, pW.getYPos());
    }



    /**
     * Tests if the toString method works
     */
    @Test
    public void testToString() {
        pW.setPosition(3, 5);
        String test = pW.toString();
        String expected = "Color = WHITE\nx = 3\ny = 5";
        assertEquals(expected, test);
    }
}