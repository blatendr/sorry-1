package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public abstract class OccupiedSpaceTest extends SpaceTest {
    protected Piece occupant;
    protected Piece nonOccupant;

    @Before
    protected void setUp() throws BoardException {
        occupant = new Piece(Color.YELLOW);
        nonOccupant = new Piece(Color.GREEN);
        space.placePiece(occupant);
        super.setUp();
    }

    @Test
    public void testOccupied() {
        assertTrue(space.occupied());
    }

    @Test
    public void testOccupiedByOccupant() {
        assertTrue(space.occupiedBy(occupant));
    }

    @Test
    public void testOccupiedByNonOccupant() {
        assertFalse(space.occupiedBy(nonOccupant));
    }

    @Test(expected = BoardException.class)
    public void testPlacePieceOccupant() throws BoardException {
        space.placePiece(occupant);
    }

    @Test
    public void testRemovePieceOccupant() throws BoardException {
        space.removePiece(occupant);
        assertFalse(space.occupiedBy(occupant));
    }

    @Test(expected = BoardException.class)
    public void testRemovePieceNonOccupant() throws BoardException {
        space.removePiece(nonOccupant);
    }
}
