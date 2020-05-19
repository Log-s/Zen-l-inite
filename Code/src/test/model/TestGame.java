package test.model;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Difficulty;
import model.Mode;
import model.Game;
import model.Square;
import model.Pawn;
import model.Player;

public class TestGame {

    Game g;
    
    /**
     * setUp
     * Creates the test object before every test
     */
    @Before()
    public void setUp() {
        g = new Game ("George", "Fred", Mode.HH);
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
     * Tests if games exists
     */
    @Test()
    public void testExists() {
        assertNotNull(g);
        Game g2 = new Game("George", "Bot", Mode.HA, Difficulty.EASY);
        assertNotNull(g2);
        g2 = null;
    }


    /***
     * Test grid size
     */
    @Test()
    public void testSizeGrid() {
        int x = g.getGrid()[0].length;
        int y = g.getGrid().length;
        assertEquals(11, x);
        assertEquals(11, y);
    }



    /**
     * Checks if the method getPawnOnSquare works
     */
    @Test()
    public void testGetPawnOnSquare() {
        Pawn p1 = g.getPawnList().get(0);
        p1.setPosition(1, 1);

        Pawn p2 = g.getPawnOnSquare(1, 1);

        assertEquals(p1, p2);

    }

    

    /**
     * Testing the removal of a pawn from the grid
     */
    @Test()
    public void testRemovePawn(){

        Square s = g.getGrid()[5][0];
        ArrayList<Pawn> list = g.getPawnList();
        Pawn p = g.getPawnOnSquare(0, 5);

        assertEquals(false, s.isFree());
        assertEquals(true, list.contains(p));

        g.removePawn(p);

        assertEquals(true, s.isFree());
        assertEquals(false, list.contains(p));

    }


    /**
     * Tests is the player is able ot move a pawn
     */
    public void testMakeMove() {

        Pawn p = g.getPawnOnSquare(0, 5);

        assertEquals(false, g.getGrid()[5][0].isFree());
        assertEquals(true, g.getGrid()[5][3].isFree());
        assertEquals(0, p.getXPos());
        assertEquals(5, p.getYPos());

        g.makeMove(p, 3, 5);

        assertEquals(true, g.getGrid()[5][0].isFree());
        assertEquals(false, g.getGrid()[5][3].isFree());
        assertEquals(3, p.getXPos());
        assertEquals(5, p.getYPos());

    }


    /**
     * Tests if the change of current player works
     */
    @Test()
    public void testChangePlayer() {
        Player p1 = g.getPlayer1();
        Player c = g.getCurrent();

        assertEquals(p1, c);

        Player p2 = g.getPlayer2();
        g.changePlayer();
        
        assertEquals(p2, c);
    }



    /**
     * Tests is the isMovePossible works
     */
    @Test()
    public void testIsMovePossible() {
        Pawn p = g.getPawnOnSquare(0, 5);

        assertEquals(p, g.isMovePossible(p, -3, 5));
        assertEquals(true, g.isMovePossible(p, 3, 5));

        g.makeMove(p, 3, 5);

        assertEquals(false, g.isMovePossible(p, 6, 5));
        assertEquals(false, g.isMovePossible(p, 2, 5));

    }


    /**
     * Test if the longuest chain is detected
     */
    public void testLonguestChain() {
        assertEquals(1, g.detectLonguestChain(g.getPlayer1()));
        assertEquals(1, g.detectLonguestChain(g.getPlayer2()));

        g.makeMove(g.getPawnOnSquare(2, 3), 0, 3);
        g.makeMove(g.getPawnOnSquare(0, 0), 0, 4);
        g.makeMove(g.getPawnOnSquare(10, 6), 10, 2);
        g.makeMove(g.getPawnOnSquare(5, 5), 3, 5);
        g.makeMove(g.getPawnOnSquare(3, 5), 1, 5);

        assertEquals(4, g.detectLonguestChain(g.getPlayer1()));
        assertEquals(3, g.detectLonguestChain(g.getPlayer2()));
    }


    /**
     * Tests if the number of pawns is correctly detected
     */
    public void testNbPawn() {
        assertEquals(13, g.getNbPawn(g.getPlayer1()));
        assertEquals(13, g.getNbPawn(g.getPlayer2()));

        g.removePawn(g.getPawnOnSquare(0, 5));

        assertEquals(12, g.getNbPawn(g.getPlayer1()));
        assertEquals(13, g.getNbPawn(g.getPlayer2()));
    }
}