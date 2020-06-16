package test.model;

import org.junit.*;
import static org.junit.Assert.*;

import model.Square;

public class TestSquare {
    
    private Square s;


    /**
     * setUp
     * Creates the test object before every test
     */
    @Before()
    public void setUp() {
        s = new Square(2,5);
    }

    /**
     * tearDown
     * Removes every link to objects (for the GC to do it's work)
     */
    @After()
    public void tearDown() {
        s = null;
    }



    /**
     * tests if the square exists
     */
    @Test()
    public void testExists() {
        assertNotNull(s);
    }

    /**
     * Tests if coordinate getters work
     */
    @Test()
    public void testCoordinateGetters() {
        assertEquals(2,s.getXPos());
        assertEquals(5,s.getYPos());
    }

    /**
     * Tests if isFree returns the right value
     */
    @Test()
    public void testIsFree() {
        assertEquals(true,s.isFree());
    }

    /**
     * Tests if the change of state works (and tests isFree some more)
     */
    @Test()
    public void testChangeState() {
        assertEquals(true,s.isFree());
        s.changeState();
        assertEquals(false,s.isFree());
        s.changeState();
        assertEquals(true,s.isFree());
    }

    /**
     * Tests if the toString methods works
     */
    @Test()
    public void testToString() {
        String test = s.toString();
        String expected = "x : 2 | y : 5 | is free : true";
        assertNotNull(test);
        assertEquals(expected,test);
    }
}