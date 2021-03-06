package sorry.board;

import org.junit.*;
import static org.junit.Assert.*;

public final class OccupiedRoundSpaceTest extends OccupiedSpaceTest {
    @Before
    public void setUp() throws BoardException {
        space = new RoundSpace(Color.YELLOW);
        super.setUp();
    }

    @Test
    public void testPlacePawnNonOccupant() throws BoardException {
        space.placePawn(nonOccupant);
        assertTrue(space.occupiedBy(nonOccupant));
    }
}
