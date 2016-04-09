package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public abstract class UnoccupiedSpaceTest extends SpaceTest {
    protected Pawn pawn;

    @Before
    protected void setUp() throws BoardException {
        pawn = new Pawn(Color.YELLOW);
        super.setUp();
    }

    @Test
    public void testOccupied() {
        assertFalse(space.occupied());
    }

    @Test
    public void testOccupiedBy() {
        assertFalse(space.occupiedBy(pawn));
    }

    @Test
    public void testPlacePawn() throws BoardException {
        space.placePawn(pawn);
        assertTrue(space.occupiedBy(pawn));
    }

    @Test(expected = BoardException.class)
    public void testRemovePawn() throws BoardException {
        space.removePawn(pawn);
    }
}
