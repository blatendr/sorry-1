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
     * This is a low-level, package private method. It does not modify the pawn
     * or any other object. You should almost definitely use the movePawn
     * method on the Board class instead.
     * <p>
     * @param pawn the pawn
     * @throws BoardException if the space is already occupied
     */
    abstract void placePawn(final Pawn pawn) throws BoardException;

    /**
     * Removes a pawn from the space.
     * <p>
     * This is a low-level, package private method. It does not modify the pawn
     * or any other object. You should almost definitely use the movePawn
     * method on the Board class instead.
     * <p>
     * @param pawn the pawn
     * @throws BoardException if the pawn does not occupy the space
     */
    abstract void removePawn(final Pawn pawn) throws BoardException;
}
