package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public abstract class SpaceTest {
    protected Space space;

    @Before
    protected void setUp() throws BoardException {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOccupiedByNull() {
        space.occupiedBy(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlacePawnNull() throws BoardException {
        space.placePawn(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePawnNull() throws BoardException {
        space.removePawn(null);
    }
}
