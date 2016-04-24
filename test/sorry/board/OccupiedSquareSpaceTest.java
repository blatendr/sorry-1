package sorry.board;

import org.junit.*;
import static org.junit.Assert.*;

public final class OccupiedSquareSpaceTest extends OccupiedSpaceTest {
    @Before
    public void setUp() throws BoardException {
        space = new SquareSpace(Color.YELLOW, 0);
        super.setUp();
    }

    @Test(expected = BoardException.class)
    public void testPlacePawnNonOccupant() throws BoardException {
        space.placePawn(nonOccupant);
    }
}
