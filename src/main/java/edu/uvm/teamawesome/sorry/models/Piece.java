package edu.uvm.teamawesome.sorry.models;

/**
 * Represents a Sorry piece.
 * <p>
 * Pieces to not currently contain pointers to their spaces on the board.
 * Instead, we track this information the other way around.
 * <p>
 * @author <a href="mailto:brian@brianmwaters.net">Brian M. Waters</a>
 */
public final class Piece {
    private final Color color;

    /**
     * Constructs a Piece of a given color.
     * <p>
     * @param color the piece's color
     */
    public Piece(final Color color) {
        this.color = color;
    }

    /**
     * Gets the piece's color.
     * <p>
     * @return the piece's color
     */
    public Color getColor() {
        assert color != null;
        return color;
    }
}
