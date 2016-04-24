package sorry.board;

/**
 * Represents a Sorry pawn.
 * <p>
 * Pawns to not currently contain pointers to their spaces on the board.
 * Instead, we track this information the other way around.
 * <p>
 * @author <a href="mailto:brian@brianmwaters.net">Brian M. Waters</a>
 */
public final class Pawn {
    private final Color color;

    private Space space;

    /**
     * Constructs a Pawn of a given color.
     * <p>
     * @param color the pawn's color
     */
    public Pawn(final Color color) {
        if (color == null) {
            throw new IllegalArgumentException();
        }
        this.color = color;
        this.space = space;
    }

    /**
     * Gets the pawn's color.
     * <p>
     * @return the pawn's color
     */
    public Color getColor() {
        assert color != null;
        return color;
    }

    /**
     * Gets the pawn's space.
     * <p>
     * @return the pawn's space, or null if it has not been placed
     */
    public Space getSpace() {
        return space;
    }

    /**
     * Returns whether the pawn occupies a given space.
     * <p>
     * @param givenSpace the space
     * @return whether the pawn occupies the space
     */
    public boolean occupies(final Space givenSpace) {
        if (givenSpace == null) {
            throw new IllegalArgumentException();
        }
        return space == givenSpace;
    }

    /**
     * Moves the pawn to the given space.
     * <p>
     * This is a low-level, package private method. It does not modify the space
     * or any other object. You should almost definitely use the movePawn
     * method on the Board class instead.
     * <p>
     * @param newSpace the space to move the pawn to
     */
    void place(final Space newSpace) {
        if (newSpace == null) {
            throw new IllegalArgumentException();
        }
        space = newSpace;
    }
}
