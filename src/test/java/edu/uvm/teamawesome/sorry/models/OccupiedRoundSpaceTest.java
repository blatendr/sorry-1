package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public final class OccupiedRoundSpaceTest extends OccupiedSpaceTest {
    @Before
    public void setUp() throws BoardException {
        space = new RoundSpace();
        super.setUp();
    }

    @Test
    public void testPlacePieceNonOccupant() throws BoardException {
        space.placePiece(nonOccupant);
        assertTrue(space.occupiedBy(nonOccupant));
    }
}
