package edu.uvm.teamawesome.sorry.models;

/**
 * Represents a space on the Sorry board.
 * <p>
 * Spaces contain pointers to the pawns that occupy them, but not to adjacent
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
     * Returns true if the space is occupied by a given pawn.
     * <p>
     * @param pawn the pawn
     * @return true if the space is occupied by the pawn
     */
    public abstract boolean occupiedBy(Pawn pawn);

    /**
     * Places a pawn on the space.
     * <p>
     * Note that the pawn is not automatically removed from its previous space.
     * <p>
     * @param pawn the pawn
     * @throws BoardException if the space is already occupied
     */
    public abstract void placePawn(final Pawn pawn) throws BoardException;

    /**
     * Removes a pawn from the space.
     * <p>
     * @param pawn the pawn
     * @throws BoardException if the pawn does not occupy the space
     */
    public abstract void removePawn(final Pawn pawn) throws BoardException;
}
