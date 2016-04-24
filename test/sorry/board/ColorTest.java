package sorry.board;

import org.junit.*;
import static org.junit.Assert.*;

public final class ColorTest {
    @Test
    public void testGetNumColors() {
        assertEquals(Color.getNumColors(), 4);
    }

    @Test
    public void testIndicesRange() {
        for (int i = 0; i < Color.values().length; i++) {
            assertTrue(Color.values()[i].getIndex() >= 0);
            assertTrue(Color.values()[i].getIndex() <= 4);
        }
    }

    @Test
    public void testIndicesUnique() {
        for (int i = 0; i < Color.values().length; i++) {
            for (int j = 0; i < i; j++) {
                assertTrue(Color.values()[i].getIndex()
                        != Color.values()[j].getIndex());
            }
        }
    }
}
