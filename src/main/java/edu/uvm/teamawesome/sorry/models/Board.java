package edu.uvm.teamawesome.sorry.models;

/**
 * Represents the Sorry board.
 * <p>
 * This consists of several collections of spaces which contain pointers to
 * pawns that occupy them.
 * <p>
 * @author <a href="mailto:brian@brianmwaters.net">Brian M. Waters</a>
 */
public final class Board {
    private static final int NUM_SIDES = Color.getNumColors();
    private static final int NUM_SPACES_PER_SIDE = 15;
    private static final int NUM_SPACES_PER_SAFETY_ZONE = 5;
    private static final int NUM_SPACES = NUM_SIDES * NUM_SPACES_PER_SIDE;
    private static final int START_INDEX = 4;
    private static final int DIAMOND_INDEX = 3;
    private static final int SAFETY_ZONE_INDEX = 2;
    private static final int FIRST_SLIDE_START_INDEX = 1;
    private static final int FIRST_SLIDE_END_INDEX = 4;
    private static final int SECOND_SLIDE_START_INDEX = 10;
    private static final int SECOND_SLIDE_END_INDEX = 14;

    private static Board singletonInstance;

    private RoundSpace[] starts;
    private SquareSpace[] spaces;
    private SquareSpace[][] safetyZones;
    private RoundSpace[] homes;

    /**
     * Constructs an empty board.
     * <p>
     * Note that this does not place any pawns at the start spaces.
     */
    public Board() {
        starts = new RoundSpace[NUM_SIDES];
        spaces = new SquareSpace[NUM_SPACES];
        safetyZones = new SquareSpace[NUM_SIDES][NUM_SPACES_PER_SAFETY_ZONE];
        homes = new RoundSpace[NUM_SIDES];
        for (int i = 0; i < starts.length; i++) {
            starts[i] = new RoundSpace();
        }
        for (int i = 0; i < spaces.length; i++) {
            spaces[i] = new SquareSpace();
        }
        for (int i = 0; i < safetyZones.length; i++) {
            for (int j = 0; j < safetyZones[i].length; j++) {
                safetyZones[i][j] = new SquareSpace();
            }
        }
        for (int i = 0; i < homes.length; i++) {
            homes[i] = new RoundSpace();
        }
    }

    /**
     * Gets the singleton instance of Board.
     * <p>
     * @return the singleton instance
     */
    public static Board getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Board();
        }
        return singletonInstance;
    }

    /**
     * Gets the start space for a given color.
     * <p>
     * @param color the color of the start space
     * @return the space
     */
    public RoundSpace getStart(final Color color) {
        assert starts != null;
        assert starts.length == NUM_SIDES;
        if (color == null) {
            throw new IllegalArgumentException();
        }
        if (color.getIndex() < 0 || color.getIndex() >= NUM_SIDES) {
            throw new IndexOutOfBoundsException();
        }
        return starts[color.getIndex()];
    }

    /**
     * Gets a given space.
     * <p>
     * @param index the index of the space
     * @return the space
     */
    public SquareSpace getSpace(final int index) {
        assert spaces != null;
        if (index < 0 || index >= NUM_SPACES) {
            throw new IndexOutOfBoundsException();
        }
        return spaces[index];
    }

    /**
     * Gets the safety zone space for a given color and index.
     * <p>
     * @param color the color of the safety zone
     * @param index the index of the space
     * @return the space
     */
    public SquareSpace getSafetyZoneSpace(final Color color, final int index) {
        assert safetyZones != null;
        assert safetyZones.length == NUM_SIDES;
        if (color == null) {
            throw new IllegalArgumentException();
        }
        if (index < 0 || index >= NUM_SPACES_PER_SAFETY_ZONE
                || color.getIndex() < 0 || color.getIndex() >= NUM_SIDES) {
            throw new IndexOutOfBoundsException();
        }
        return safetyZones[color.getIndex()][index];
    }

    /**
     * Gets the home space for a given color.
     * <p>
     * @param color the color of the home space
     * @return the space
     */
    public RoundSpace getHome(final Color color) {
        assert homes != null;
        assert homes.length == NUM_SIDES;
        if (color == null) {
            throw new IllegalArgumentException();
        }
        if (color.getIndex() < 0 || color.getIndex() >= NUM_SIDES) {
            throw new IndexOutOfBoundsException();
        }
        return homes[color.getIndex()];
    }

    /**
     * Moves a pawn.
     *
     * @param pawn the pawn to move
     * @param space the space to move the pawn to
     * @throws BoardException if the requested space cannot be occupied
     */
    public void movePawn(final Pawn pawn, final Space space)
            throws BoardException {
        if (pawn == null || space == null) {
            throw new IllegalArgumentException();
        }
        if (pawn.getSpace() != null) {
            assert pawn.getSpace().occupiedBy(pawn);
            pawn.getSpace().removePawn(pawn);
        }
        space.placePawn(pawn);
        pawn.place(space);
        assert space.occupiedBy(pawn);
        assert pawn.occupies(space);
    }
}
