package edu.uvm.teamawesome.sorry.models;

import java.util.LinkedList;

/**
 * A space which can hold many pawns.
 * <p>
 * @author <a href="mailto:brian@brianmwaters.net">Brian M. Waters</a>
 */
public final class RoundSpace extends Space {
    private LinkedList<Pawn> occupants;

    /**
     * Constructs an empty RoundSpace.
     * <p>
     * Round spaces can hold an unlimited number of occupants each.
     */
    public RoundSpace() {
        occupants = new LinkedList<Pawn>();
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
     * Returns true if the space is occupied by a given pawn.
     * <p>
     * @param pawn the pawn
     * @return true if the space is occupied by the pawn
     */
    public boolean occupiedBy(final Pawn pawn) {
        assert occupants != null;
        if (pawn == null) {
            throw new IllegalArgumentException();
        }
        return occupants.contains(pawn);
    }

    /**
     * Places a pawn on the space.
     * <p>
     * Note that the pawn is not automatically removed from its previous space.
     * <p>
     * @param pawn the pawn
     * @throws BoardException if the pawn already occupies the space
     */
    public void placePawn(final Pawn pawn) throws BoardException {
        assert occupants != null;
        if (pawn == null) {
            throw new IllegalArgumentException();
        }
        if (occupiedBy(pawn)) {
            throw new BoardException();
        }
        occupants.add(pawn);
    }

    /**
     * Removes a pawn from the space.
     * <p>
     * @param pawn the pawn
     * @throws BoardException if the pawn does not occupy the space
     */
    public void removePawn(final Pawn pawn) throws BoardException {
        assert occupants != null;
        if (pawn == null) {
            throw new IllegalArgumentException();
        }
        if (!occupiedBy(pawn)) {
            throw new BoardException();
        }
        occupants.remove(pawn);
    }
}
