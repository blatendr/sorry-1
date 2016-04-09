package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public final class PawnTest {
    @Test
    public void testGetColor() {
        Pawn pawn = new Pawn(Color.YELLOW);
        assertSame(pawn.getColor(), Color.YELLOW);
    }
}
