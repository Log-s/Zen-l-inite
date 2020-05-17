package test.model;

import org.junit.*;

import static org.junit.Assert.*;

import model.Pawn;
import model.Color;

public class PawnTest {
    
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
}