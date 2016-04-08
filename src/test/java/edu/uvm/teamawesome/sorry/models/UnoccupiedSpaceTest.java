package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public abstract class UnoccupiedSpaceTest extends SpaceTest {
    protected Piece piece;

    @Before
    protected void setUp() throws BoardException {
        piece = new Piece(Color.YELLOW);
        super.setUp();
    }

    @Test
    public void testOccupied() {
        assertFalse(space.occupied());
    }

    @Test
    public void testOccupiedBy() {
        assertFalse(space.occupiedBy(piece));
    }

    @Test
    public void testPlacePiece() throws BoardException {
        space.placePiece(piece);
        assertTrue(space.occupiedBy(piece));
    }

    @Test(expected = BoardException.class)
    public void testRemovePiece() throws BoardException {
        space.removePiece(piece);
    }
}
