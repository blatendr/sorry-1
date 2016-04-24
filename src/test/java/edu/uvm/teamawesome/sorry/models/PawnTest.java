package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public final class PawnTest {
    @Test
    public void testGetColor() {
        Pawn pawn = new Pawn(Color.YELLOW);
        assertSame(pawn.getColor(), Color.YELLOW);
    }

    @Test
    public void testGetSpaceNotPlaced() throws BoardException {
        Pawn pawn = new Pawn(Color.YELLOW);
        assertNull(pawn.getSpace());
    }

    @Test
    public void testPlaceGetSpace() throws BoardException {
        Pawn pawn = new Pawn(Color.YELLOW);
        Space space = new SquareSpace(Color.YELLOW, 0);
        pawn.place(space);
        assertSame(pawn.getSpace(), space);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOccupiesNull() {
        Pawn pawn = new Pawn(Color.YELLOW);
        pawn.occupies(null);
    }

    @Test
    public void testOccupiesNotPlaced() {
        Pawn pawn = new Pawn(Color.YELLOW);
        Space space = new SquareSpace(Color.YELLOW, 0);
        assertFalse(pawn.occupies(space));
    }

    @Test
    public void testPlaceOccupiesFalse() {
        Pawn pawn = new Pawn(Color.YELLOW);
        Space space1 = new SquareSpace(Color.YELLOW, 0);
        Space space2 = new SquareSpace(Color.YELLOW, 0);
        pawn.place(space1);
        assertFalse(pawn.occupies(space2));
    }

    @Test
    public void testPlaceOccupiesTrue() {
        Pawn pawn = new Pawn(Color.YELLOW);
        Space space = new SquareSpace(Color.YELLOW, 0);
        pawn.place(space);
        assertTrue(pawn.occupies(space));
    }
}
