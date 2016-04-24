package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public final class BoardTest {
    // shorthand
    private Board board;
    private Color color;

    @Before
    public void setUp() {
        board = Board.getSingletonInstance();
        color = Color.YELLOW;
    }

    @Test
    public void testGetSingletonInstanceIdempotentcy() {
        Board firstInstance = board;
        Board secondInstance = board;
        assertSame(firstInstance, secondInstance);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetStartNull() {
        board.getStart(null);
    }

    @Test
    public void testGetStart() {
        Space start = board.getStart(color);
        assertNotNull(start);
        assertTrue(start instanceof RoundSpace);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSpaceInvalidIndexLow() {
        board.getSpace(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSpaceInvalidIndexHigh() {
        board.getSpace(60);
    }

    @Test
    public void testGetSpace() {
        Space space = board.getSpace(59);
        assertNotNull(space);
        assertTrue(space instanceof SquareSpace);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSafetyZoneSpaceNullColor() {
        board.getSafetyZoneSpace(null, 59);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSafetyZoneSpaceInvalidIndexLow() {
        board.getSafetyZoneSpace(color, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSafetyZoneSpaceInvalidIndexHigh() {
        board.getSafetyZoneSpace(color, 5);
    }

    @Test
    public void testGetSafetyZoneSpace() {
        Space safetyZoneSpace =
                board.getSafetyZoneSpace(color, 4);
        assertNotNull(safetyZoneSpace);
        assertTrue(safetyZoneSpace instanceof SquareSpace);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetHomeNull() {
        board.getHome(null);
    }

    @Test
    public void testGetHome() {
        Space home = board.getHome(color);
        assertNotNull(home);
        assertTrue(home instanceof RoundSpace);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMovePawnNullPawn() throws BoardException {
        board.movePawn(null,
                board.getHome(color));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMovePawnNullSpace() throws BoardException {
        board.movePawn(new Pawn(color), null);
    }

    @Test
    public void testMovePawn() throws BoardException {
        Pawn pawn = new Pawn(color);
        Space initialSpace = board.getHome(color);
        Space secondSpace = board.getStart(color);
        board.movePawn(pawn, initialSpace);
        assertTrue(pawn.occupies(initialSpace));
        assertTrue(initialSpace.occupiedBy(pawn));
        board.movePawn(pawn, secondSpace);
        assertTrue(pawn.occupies(secondSpace));
        assertFalse(initialSpace.occupiedBy(pawn));
        assertTrue(secondSpace.occupiedBy(pawn));
    }
}
