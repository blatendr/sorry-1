package edu.uvm.teamawesome.sorry.models;

import java.util.LinkedList;

/**
 * A space which can hold many pieces.
 * <p>
 * @author <a href="mailto:brian@brianmwaters.net">Brian M. Waters</a>
 */
public final class RoundSpace extends Space {
    private LinkedList<Piece> occupants;

    /**
     * Constructs an empty RoundSpace.
     * <p>
     * Round spaces can hold an unlimited number of occupants each.
     */
    public RoundSpace() {
        occupants = new LinkedList<Piece>();
    }

    /**
     * Returns true if the space is occupied.
     * <p>
     * @return true if the space is occupied
     */
    public boolean occupied() {
        assert occupants != null;
        return !occupants.isEmpty();
    }

    /**
     * Returns true if the space is occupied by a given piece.
     * <p>
     * @param piece the piece
     * @return true if the space is occupied by the piece
     */
    public boolean occupiedBy(final Piece piece) {
        assert occupants != null;
        if (piece == null) {
            throw new IllegalArgumentException();
        }
        return occupants.contains(piece);
    }

    /**
     * Places a piece on the space.
     * <p>
     * Note that the piece is not automatically removed from its previous space.
     * <p>
     * @param piece the piece
     * @throws BoardException if the piece already occupies the space
     */
    public void placePiece(final Piece piece) throws BoardException {
        assert occupants != null;
        if (piece == null) {
            throw new IllegalArgumentException();
        }
        if (occupiedBy(piece)) {
            throw new BoardException();
        }
        occupants.add(piece);
    }

    /**
     * Removes a piece from the space.
     * <p>
     * @param piece the piece
     * @throws BoardException if the piece does not occupy the space
     */
    public void removePiece(final Piece piece) throws BoardException {
        assert occupants != null;
        if (piece == null) {
            throw new IllegalArgumentException();
        }
        if (!occupiedBy(piece)) {
            throw new BoardException();
        }
        occupants.remove(piece);
    }
}
