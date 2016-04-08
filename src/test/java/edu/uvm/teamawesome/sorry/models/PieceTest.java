package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public final class PieceTest {
    @Test
    public void testColor() {
        Piece piece = new Piece(Color.YELLOW);
        assertSame(piece.getColor(), Color.YELLOW);
    }
}
