/*
Brad LAtendresse, 
cs 205
Sorry game card logic
*/
package sorry;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Object;

public class Deck{
   
   ArrayList<Integer> deck = new ArrayList<>();
   int[] cardArray = new int[]{1,2,3,4,5,7,8,10,11,12,13};   
   
   
   public Deck() 
   {
   int counter=0; //initiliaze constants
   
   
     
   for (int i=1;i <5;i++) //initiliaze deck
      {
      for (int j=0; j<cardArray.length;j++)
         {
         deck.add(cardArray[j]);
         }
      }  
   deck.add(cardArray[1]);
      Collections.shuffle(deck);
 System.out.print(deck.size());
   }

   public int draw()
     {
     int drawn = deck.get(0);
     deck.remove(0);
     
   
       return drawn;
      }



   public String getMessage(int i)
      {
        String m="";
         if(i ==1)
            {
            m = "Move a pawn from Start or move a pawn one space forward.";
            }
         if(i ==2)
            {
         	m= "Move a pawn from Start or move a pawn two spaces forward. Draw again at the end of your turn.";
            }
         if (i==3)
            {
         	m= "Move a pawn three spaces forward.";
            }
         if (i==4)
            {
            m= "Move a pawn four spaces backward.";
            }
         if (i==5){
         	m= "Move a pawn five spaces forward.";
            }
         if (i==7){
         	m= "Move one pawn seven spaces forward or split the seven spaces between two pawns";
            }
         if (i==8){
         	m= "Move a pawn eight spaces forward.";
            }
         if (i==10){
         	m= "Move a pawn 10 spaces forward or one space backward. If a player cannot go forward 10 spaces, then one pawn must go back one space.";
            }
         if (i==11){
         	m= "Move 11 spaces forward or switch places with one opposing pawn. A player that cannot move 11 spaces is not forced to switch and instead can forfeit the turn.";
            }
         if (i==12){
         	m= "Move a pawn 12 spaces forward.";
            }
         if (i ==13){
           m= "Move any one pawn from Start to a square occupied by any opponent, sending that pawn back to its own Start. If there are no pawns on the player's Start, or no opponent's pawns on any squares, the turn is lost. If an enemy's pawn is swapped while it is in front of your HOME, your pawn is switched EXACTLY where your enemy's pawn is, not at your HOME.";
            }      
      return m;
      }
      }