package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public final class UnoccupiedSquareSpaceTest extends UnoccupiedSpaceTest {
    @Before
    public void setUp() throws BoardException {
        space = new SquareSpace();
        super.setUp();
    }
}
