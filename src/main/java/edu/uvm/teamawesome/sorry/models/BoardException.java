package edu.uvm.teamawesome.sorry.models;

/**
 * Thrown to indicate that a method has requested an illegal board
 * configuration.
 * <p>
 * Note that this is not intended to indicate board configurations that are
 * illegal according to the rules of Sorry. Instead, it indicates board
 * configurations that are physically or structurally unsound, such as two
 * pawns occupying the same square (single-pawn) space.
 * <p>
 * @author <a href="mailto:brian@brianmwaters.net">Brian M. Waters</a>
 */
public final class BoardException extends Exception {
    /**
     * Constructs a BoardException.
     */
    public BoardException() {
    }
}
