package sorry.board;

import org.junit.*;
import static org.junit.Assert.*;

public final class UnoccupiedSquareSpaceTest extends UnoccupiedSpaceTest {
    @Before
    public void setUp() throws BoardException {
        space = new SquareSpace(Color.YELLOW, 0);
        super.setUp();
    }
}
