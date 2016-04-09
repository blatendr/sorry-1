package edu.uvm.teamawesome.sorry.models;

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

    /**
     * Constructs a Pawn of a given color.
     * <p>
     * @param color the pawn's color
     */
    public Pawn(final Color color) {
        this.color = color;
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
}
