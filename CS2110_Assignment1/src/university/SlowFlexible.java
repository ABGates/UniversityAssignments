package university;
/* Assignment 1|CSCI2110
 * Alexander Gates|B00837129
 * September 23rd, 2020
 * The SlowFlexible class creates Piece objects that can only move left,right, up, & down one space at a time
 */

public class SlowFlexible extends SlowPiece {

	public SlowFlexible(String name, String colour, int[] pos) {
		super(name, colour, pos);
		
	}
	
	public String toString() {
		return name+colour+ "SF";
	}
	
	//returns slowPiece so that the board has a new piece object to add to the board after it gets rid of the old one
	public SlowFlexible move(String direction) {
		//create a copy of piece being referenced to return
		SlowFlexible temp = new SlowFlexible(name,colour,position);

		if(direction.contentEquals("left")) {
			temp.getPos()[1]--;
			return temp;
		}
		else if(direction.contentEquals("right")) {
			temp.getPos()[1]++;
			return temp;
		}
		else if(direction.contentEquals("up")) {
			temp.getPos()[0]--;
			return temp;
		}
		else if(direction.contentEquals("down")) {
			temp.getPos()[0]++;
			return temp;
		}
		
		System.out.println("Syntax Error: Flexible pieces can only move left, right, up, & down");
		return null;
	}

}
