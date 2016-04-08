package edu.uvm.teamawesome.sorry.models;

/**
 * Represents a space on the Sorry board.
 * <p>
 * Spaces contain pointers to the pieces that occupy them, but not to adjacent
 * or related spaces.
 * <p>
 * @author <a href="mailto:brian@brianmwaters.net">Brian M. Waters</a>
 */
public abstract class Space {
    /**
     * Returns true if the space is occupied.
     * <p>
     * @return true if the space is occupied
     */
    public abstract boolean occupied();

    /**
     * Returns true if the space is occupied by a given piece.
     * <p>
     * @param piece the piece
     * @return true if the space is occupied by the piece
     */
    public abstract boolean occupiedBy(Piece piece);

    /**
     * Places a piece on the space.
     * <p>
     * Note that the piece is not automatically removed from its previous space.
     * <p>
     * @param piece the piece
     * @throws BoardException if the space is already occupied
     */
    public abstract void placePiece(final Piece piece) throws BoardException;

    /**
     * Removes a piece from the space.
     * <p>
     * @param piece the piece
     * @throws BoardException if the piece does not occupy the space
     */
    public abstract void removePiece(final Piece piece) throws BoardException;
}
