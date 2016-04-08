package edu.uvm.teamawesome.sorry.models;

/**
 * A space which can hold only one piece.
 * <p>
 * @author <a href="mailto:brian@brianmwaters.net">Brian M. Waters</a>
 */
public final class SquareSpace extends Space {
    private Piece occupant;

    /**
     * Constructs an empty SquareSpace.
     * <p>
     * Square spaces can hold one occupant each.
     */
    public SquareSpace() {
        occupant = null;
    }

    /**
     * Gets the occupant of the space.
     * <p>
     * @throws BoardException if the space is empty
     * @return the occupant
     */
    public Piece getOccupant() throws BoardException {
        if (occupant == null) {
            throw new BoardException();
        }
        return occupant;
    }

    /**
     * Returns true if the space is occupied.
     * <p>
     * @return true if the space is occupied
     */
    public boolean occupied() {
        return occupant != null;
    }

    /**
     * Returns true if the space is occupied by a given piece.
     * <p>
     * @param piece the piece
     * @return true if the space is occupied by the piece
     */
    public boolean occupiedBy(final Piece piece) {
        if (piece == null) {
            throw new IllegalArgumentException();
        }
        return occupant == piece;
    }

    /**
     * Places a piece on the space.
     * <p>
     * Note that the piece is not automatically removed from its previous space.
     * <p>
     * @param piece the piece
     * @throws BoardException if the space is already occupied
     */
    public void placePiece(final Piece piece) throws BoardException {
        if (piece == null) {
            throw new IllegalArgumentException();
        }
        if (occupied()) {
            throw new BoardException();
        }
        occupant = piece;
    }

    /**
     * Removes a piece from the space.
     * <p>
     * @param piece the piece
     * @throws BoardException if the piece does not occupy the space
     */
    public void removePiece(final Piece piece) throws BoardException {
        if (piece == null) {
            throw new IllegalArgumentException();
        }
        if (!occupiedBy(piece)) {
            throw new BoardException();
        }
        occupant = null;
    }
}
