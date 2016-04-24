package edu.uvm.teamawesome.sorry.models;

import org.junit.*;
import static org.junit.Assert.*;

public final class CardTest {
    @Test
    public void testColor() 
      {
    
      SorryCards deck = new SorryCards();
      if (deck.length != 45)
         {
         System.out.println("error");
         }   
       
    
    }
}
