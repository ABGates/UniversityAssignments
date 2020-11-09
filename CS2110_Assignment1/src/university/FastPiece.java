package university;
/* Assignment 1|CSCI2110
 * Alexander Gates|B00837129
 * September 23rd, 2020
 * The FastPiece class creates Piece objects that can move left & right many spaces at a time
 */


public class FastPiece extends Piece {

	public FastPiece(String name, String colour, int[] pos) {
		super(name, colour, pos);
	}
	
	public String toString() {
		return name+colour+ "F";
	}
	
	//returns slowPiece so that the board has a new piece object to add to the board after it gets rid of the old one
	public FastPiece move(String direction, int spaces){
		//create a copy of piece being referenced to return
		FastPiece temp = new FastPiece(name,colour,position);
		if(direction.contentEquals("left")) {
			temp.getPos()[1]-=spaces;
			return temp;
		}
		else if(direction.contentEquals("right")) {
			temp.getPos()[1]+=spaces;
			return temp;
		}
		System.out.println("Syntax Error: Non-flexible pieces can only move left & right");
		return null;
	}

}
