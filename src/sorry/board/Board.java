package sorry.board;

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
            starts[i] = new RoundSpace(Color.colorOfIndex(i), SpaceType.START);
        }
        for (int i = 0; i < spaces.length; i++) {
            spaces[i] = new SquareSpace(
                    Color.colorOfIndex(i % Color.getNumColors()), SpaceType.NORMAL, i);
        }
        for (int i = 0; i < safetyZones.length; i++) {
            for (int j = 0; j < safetyZones[i].length; j++) {
                // safety zone indices start above normal indices
                safetyZones[i][j] = new SquareSpace(Color.colorOfIndex(i),
                        SpaceType.SAFETY_ZONE, j);
            }
        }
        for (int i = 0; i < homes.length; i++) {
            homes[i] = new RoundSpace(Color.colorOfIndex(i), SpaceType.HOME);
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
   
   /**
  checks if a move the player is trying to make is valid 
   
   @param int i: number of the card, pawn p: the pawn player wants to move and Space s: the space the player wants to move the pawn to 
   @returns true if move is valid
   */
  
   public boolean checkMove(int i, Pawn p,Space s)
      {
      Space spaceType = p.getSpace();
      SpaceType currentType = spaceType.getSpaceType();
      
      if (s.occupiedBy(p) == true)
               return false;

      
      //If the pawn starts on a normal space     
      if (currentType.equals("NORMAL"))
         {
         Space current_space = p.getSpace();
         int current_index = ((SquareSpace)current_space).getIndex();
         int space_index = ((SquareSpace)s).getIndex();


         SpaceType moveType = s.getSpaceType();
         //the the player wants to move onto a safetyzone,
         if (moveType.equals("SAFETY_ZONE"))
            {
            int modded_index = current_index%16;
            
            //If the pawn is one or two spaces away
            if (modded_index <3)
               {
               //find spaces until safe zone starts 
               int spaces_till_safe = 3-modded_index+1;
               
               //get amount player wants to move pawn
               int spaces_moved = spaces_till_safe+space_index+1;
               //if they moved to an area their card wouldn't allow, move is invalid
               if ( i!= spaces_moved)
                  return false;
                 
               
               
               }
            //if pawn if up to 11 spaces away, still could make it into safe area
            if (modded_index > 7)
               {
               //calc amount player wants to move
               int spaces_moved = 18-modded_index+space_index+1;
               
               if (spaces_moved != i)
                  return false;
          
               }
            }
         //if pawn want to go from normal space to home
         if (moveType.equals("HOME"))
            {
            if (i < 6)
               return false;
            }
         //if player is moving pawn normal to normal
            int spaces_moved = space_index -current_index;
            if (spaces_moved != i)
               return false;
  
         }
     
     
      //If the pawn is moving out of start
      if ( currentType.equals("START"))
         {
         if (i != 1 || i!=2 || i != 13)
            {
            return false;
            }   
         }

      //If the pawn starts in the saefty zone
      if ( currentType.equals("SAFETY_ZONE"))
         {//
          Space current_space = p.getSpace();
          int current_index = ((SquareSpace)current_space).getIndex();
          int space_index = ((SquareSpace)s).getIndex();
          int spaces_moved = space_index -current_index;

         
         
         //no number higher than 6 can move a pawn in safety zone
         if (i >5)
            return false;
         SpaceType moveType = s.getSpaceType();
         
         //if pawn is going from safety into home
         if (moveType.equals("HOME"))
            {
            int home = NUM_SPACES_PER_SAFETY_ZONE -current_index;
            if (home != i)  
               return false;
            
            }
         //if pawn is going safety zone to safety zone
         if (moveType.equals("SAFETY_ZONE"))
            {
            if (spaces_moved != i)  
               return false;
            }

         //pawn cant go back to normal spaces
         if (moveType.equals("NORMAL"))
            return false;
          
         }
     //cant move a pawn from home
      if (currentType.equals("HOME"))
         return false;
      
            //if nothing returned false, move is valid, return true
            return true;
      }



}
