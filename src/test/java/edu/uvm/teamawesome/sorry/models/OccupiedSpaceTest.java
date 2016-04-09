package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public abstract class OccupiedSpaceTest extends SpaceTest {
    protected Pawn occupant;
    protected Pawn nonOccupant;

    @Before
    protected void setUp() throws BoardException {
        occupant = new Pawn(Color.YELLOW);
        nonOccupant = new Pawn(Color.GREEN);
        space.placePawn(occupant);
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
    public void testPlacePawnOccupant() throws BoardException {
        space.placePawn(occupant);
    }

    @Test
    public void testRemovePawnOccupant() throws BoardException {
        space.removePawn(occupant);
        assertFalse(space.occupiedBy(occupant));
    }

    @Test(expected = BoardException.class)
    public void testRemovePawnNonOccupant() throws BoardException {
        space.removePawn(nonOccupant);
    }
}
