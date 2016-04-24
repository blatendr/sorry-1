package sorry;

import org.junit.*;
import static org.junit.Assert.*;

public final class DeckTest {
    @Test
    public void testColor() 
      {
    
      Deck deck = new Deck();
      if (deck.length != 45)
         {
         System.out.println("error");
         }   
       
    
    }
}
