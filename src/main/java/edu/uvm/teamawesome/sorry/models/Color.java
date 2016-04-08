package edu.uvm.teamawesome.sorry.models;

/**
 *
 * Represents the player colors (yellow, green, red and blue) in Sorry.
 * <p>
 * Each color is given a unique index which may be useful elsewhere in the code.
 * <p>
 * @author <a href="mailto:brian@brianmwaters.net">Brian M. Waters</a>
 */
public enum Color {
    YELLOW (0, "yellow"),
    GREEN (1, "green"),
    RED (2, "red"),
    BLUE (3, "blue");

    private static final int NUM_COLORS = values().length;

    private final int index;
    private final String name;

    /**
     * Constructs a color.
     * <p>
     * @param index the color's index
     * @param name a lower-case string representation for the color
     */
    Color(final int index, final String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * The number of player colors in the game.
     * <p>
     * @return the number of colors
     */
    public static final int getNumColors() {
        return NUM_COLORS;
    }

    /**
     * Gets the color's index.
     * <p>
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets the lower-case string representation for the color.
     * <p>
     * @return the string
     */
    public String toString() {
        return name;
    }
}
