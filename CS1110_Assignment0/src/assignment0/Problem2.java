/*
* Alexander Gates B00837129
* September 15th, 2019
* CSCI 1110 Assignment 0 Problem 2
* 
* Given the dice rolls from a game of Zombie, this program calculates the scores
* of "Alice" & "Bob" given that they follow the rule of three as outlined in the assignment
*/

package assignment0; 
import java.util.*;

public class Problem2 
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
  
    //number of rolls needed to know size of array
    int numRolls = in.nextInt();
   
    //total score for alice & bob that will be in print statement
    int aliceTotal = 0;
    int bobTotal = 0;
    
    //score per turn for alice & bob (so that I can set it to zero if the shotguncount hits 3)
    int alice = 0;
    int bob = 0;
    
    //counts the number of shotguns that have occured during the turn
    int shotgunCount = 0;
    
    //lets me know who to increment points for in if statements
    boolean aliceTurn = true;
    boolean bobTurn = false;
   
    //initialze a 2d string array to take input for dice faces, size is 3 b/c 3 dice per turn
    String[][] diceFaces = new String[numRolls][3];
  
    //put the inputs into a 2 dimensional array 
    for(int i = 0; i < numRolls; i++)
    {
      for (int j = 0; j < 3; j++) 
      {
            diceFaces[i][j] = in.next(); 
      }
    }
        
    //cycle through the 2d array and use if statement logic to increment points based on the order of the letters in the 2d array
    for(int i = 0; i < numRolls; i++)
    {
      for (int j = 0; j < 3; j++) 
      { 
        // ALICE LOGIC
        //increment points & shotgun counts for alice's turns 
        if (aliceTurn && diceFaces[i][j].equals("B") ) 
            alice++;
       
        if (aliceTurn && diceFaces[i][j].equals("S") )
            shotgunCount++;
            
      //if shotgun count reaches 3 we can break and leave that turn b/c we know alice gets no points
        if (shotgunCount >= 3)
        {
          alice = 0;              //remove alice's points for this turn
          aliceTurn = false;  
          bobTurn = true;         //make it bobs turn
          shotgunCount = 0;       //reset shotgun counter
          break;         
        }
       //if alice has 3 or more points at the end of the turn it becomes bobs turn and alice gets her points 
        if (alice >= 3 && j == 2)
        { 
          shotgunCount = 0;         //reset shotgun counter to use later
          aliceTotal += alice;      //give alice her points
          alice = 0;                //reset turnpoint counter for alice so her next turn starts at zero points
          aliceTurn = false;  
          bobTurn = true;            //make it bobs turn
          break;
        }
               
        // BOB LOGIC
        //increment points & shotgun counts for bob's turns 
        if (bobTurn && diceFaces[i][j].equals("B") ) 
            bob++;
       
        if (bobTurn && diceFaces[i][j].equals("S") )
            shotgunCount++;
                   
        //if shotgun count reaches 3 we can break and leave that turn b/c we know bob gets no points
        if (shotgunCount >= 3)
        {
          bob = 0;                   //remove bob's points for this turn
          bobTurn = false;    
          aliceTurn = true;          //make it alice's turn
          shotgunCount = 0;          //reset shotgun counter
          break;        
        }
        //if bob has 3 or more points at the end of the turn it becomes alice's turn and bob gets his points 
        if (bob >= 3 && j == 2)
        { 
          shotgunCount = 0;      //reset shotgun counter to use later
          bobTotal += bob;       //give bob his points
          bob = 0;               //reset turnpoint counter for bob
          bobTurn = false;  
          aliceTurn = true;       //make it alice's turn
          break;                  //end the turn
        }
      }
    }
         
        //if the turn ends because we ran out of turns and not because there were too many points or shotguns, then these will add on the excess points that got missed in the loop
        aliceTotal += alice;
        bobTotal += bob;
    
    //System.out.println("TESTING: " + diceFaces[2][2]);
    System.out.println("Alice " + aliceTotal + ", " + "Bob " + bobTotal);
  }
}