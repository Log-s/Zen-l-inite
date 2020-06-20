package test.model;

import org.junit.*;
import static org.junit.Assert.*;

import model.PawnColor;
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
        pW = new Pawn(PawnColor.WHITE);
        pB = new Pawn(PawnColor.BLACK);
        pZ = new Pawn(PawnColor.ZEN);
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
        assertEquals(PawnColor.WHITE, pW.getColor());
        assertEquals(PawnColor.BLACK, pB.getColor());
        assertEquals(PawnColor.ZEN, pZ.getColor());
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
        String expected = "x : 3 | y : 5 | color : WHITE";
        assertEquals(expected, test);
    }
}