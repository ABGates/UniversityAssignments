package university;
/* Assignment 1|CSCI2110
 * Alexander Gates|B00837129
 * September 23rd, 2020
 * The SlowPiece class creates Piece objects that can only move left & right one space at a time
 */

public class SlowPiece extends Piece {

	public SlowPiece(String name, String colour, int[] pos) {
		super(name, colour, pos);
	}
	
	public String toString() {
		return name+colour+ "S";
	}
	
	//returns slowPiece so that the board has a new piece object to add to the board after it gets rid of the old one
	public SlowPiece move(String direction) {
		//create a copy of piece being referenced to return
		SlowPiece temp = new SlowPiece(name,colour,position);
		if(direction.contentEquals("left")) {
			temp.getPos()[1]--;
			return temp;
		}
		else if(direction.contentEquals("right")) {
			temp.getPos()[1]++;
			return temp;
		}
		
		System.out.println("Syntax Error: Non-flexible pieces can only move left & right");
		return null;
	}

}
