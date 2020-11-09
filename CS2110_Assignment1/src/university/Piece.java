package university;
/* Assignment 1|CSCI2110
 * Alexander Gates|B00837129
 * September 23rd, 2020
 * The Piece class creates Piece contains the constructor, getters, & setters for a generic Piece object
 */

public class Piece {

	protected String name, colour;
	protected int[] position = new int[2];
	
	public Piece(String name, String colour, int[] pos) {
		this.name = name;
		this.colour = colour;
		this.position[0] = pos[0];
		this.position[1] = pos[1];
	}

	public String getName() {return name;}
	public String getColour() {return colour;}
	public int[] getPos() {return position;}
	
	public void setName(String name) {this.name = name;}
	public void setColour(String colour) {this.colour=colour;}
	public void setPos(int x, int y) {this.position[0] = x; this.position[1] = y;}
	
	public String toString() {
		return name + colour;
	}
	
}
