package edu.uvm.teamawesome.sorry.models;

/**
 * A space which can hold only one pawn.
 * <p>
 * @author <a href="mailto:brian@brianmwaters.net">Brian M. Waters</a>
 */
public final class SquareSpace extends Space {
    private Pawn occupant;

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
    public Pawn getOccupant() throws BoardException {
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
     * Returns true if the space is occupied by a given pawn.
     * <p>
     * @param pawn the pawn
     * @return true if the space is occupied by the pawn
     */
    public boolean occupiedBy(final Pawn pawn) {
        if (pawn == null) {
            throw new IllegalArgumentException();
        }
        return occupant == pawn;
    }

    /**
     * Places a pawn on the space.
     * <p>
     * Note that the pawn is not automatically removed from its previous space.
     * <p>
     * @param pawn the pawn
     * @throws BoardException if the space is already occupied
     */
    public void placePawn(final Pawn pawn) throws BoardException {
        if (pawn == null) {
            throw new IllegalArgumentException();
        }
        if (occupied()) {
            throw new BoardException();
        }
        occupant = pawn;
    }

    /**
     * Removes a pawn from the space.
     * <p>
     * @param pawn the pawn
     * @throws BoardException if the pawn does not occupy the space
     */
    public void removePawn(final Pawn pawn) throws BoardException {
        if (pawn == null) {
            throw new IllegalArgumentException();
        }
        if (!occupiedBy(pawn)) {
            throw new BoardException();
        }
        occupant = null;
    }
}
