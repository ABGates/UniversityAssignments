package university;
/* Assignment 1|CSCI2110
 * Alexander Gates|B00837129
 * September 23rd, 2020
 * The FastFlexible class creates Piece objects that can move left, right, up, & down many spaces at a time
 */


public class FastFlexible extends FastPiece {

	public FastFlexible(String name, String colour, int[] pos) {
		super(name, colour, pos);
		
	}
	
	public String toString() {
		return name+colour+ "FF";
	}
	
	//returns slowPiece so that the board has a new piece object to add to the board after it gets rid of the old one
	public FastFlexible move(String direction, int spaces){
		//create a copy of piece being referenced to return
		FastFlexible temp = new FastFlexible(name,colour,position);
		if(direction.contentEquals("left")) {
			temp.getPos()[1]-=spaces;
			return temp;
		}
		else if(direction.contentEquals("right")) {
			temp.getPos()[1]+=spaces;
			return temp;
		}
		else if(direction.contentEquals("up")) {
			temp.getPos()[0]-=spaces;
			return temp;
		}
		else if(direction.contentEquals("down")) {
			temp.getPos()[0]+=spaces;
			return temp;
		}
		
		System.out.println("Syntax Error: Flexible pieces can only move left,right,up, & down");
		return null;
	}

}
