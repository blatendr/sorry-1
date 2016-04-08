package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public final class BoardTest {
    private Color color;

    @Before
    public void setUp() {
        color = Color.YELLOW;
    }

    @Test
    public void testGetSingletonInstanceIdempotentcy() {
        Board firstInstance = Board.getSingletonInstance();
        Board secondInstance = Board.getSingletonInstance();
        assertSame(firstInstance, secondInstance);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetStartNull() {
        Board.getSingletonInstance().getStart(null);
    }

    @Test
    public void testGetStart() {
        RoundSpace start = Board.getSingletonInstance().getStart(color);
        assertNull(start);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSpaceInvalidIndexLow() {
        Board.getSingletonInstance().getSpace(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSpaceInvalidIndexHigh() {
        Board.getSingletonInstance().getSpace(60);
    }

    @Test
    public void testGetSpace() {
        SquareSpace space = Board.getSingletonInstance().getSpace(59);
        assertNull(space);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSafetyZoneSpaceNullColor() {
        Board.getSingletonInstance().getSafetyZoneSpace(null, 59);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSafetyZoneSpaceInvalidIndexLow() {
        Board.getSingletonInstance().getSafetyZoneSpace(color, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSafetyZoneSpaceInvalidIndexHigh() {
        Board.getSingletonInstance().getSafetyZoneSpace(color, 5);
    }

    @Test
    public void testGetSafetyZoneSpace() {
        SquareSpace safetyZoneSpace =
                Board.getSingletonInstance().getSafetyZoneSpace(color, 4);
        assertNull(safetyZoneSpace);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetHomeNull() {
        Board.getSingletonInstance().getHome(null);
    }

    @Test
    public void testGetHome() {
        RoundSpace home = Board.getSingletonInstance().getHome(color);
        assertNull(home);
    }
}
