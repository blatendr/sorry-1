package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public final class OccupiedSquareSpaceTest extends OccupiedSpaceTest {
    @Before
    public void setUp() throws BoardException {
        space = new SquareSpace();
        super.setUp();
    }

    @Test(expected = BoardException.class)
    public void testPlacePawnNonOccupant() throws BoardException {
        space.placePawn(nonOccupant);
    }
}
