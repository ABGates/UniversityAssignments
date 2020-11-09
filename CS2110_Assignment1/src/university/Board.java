package university;
/* Assignment 1|CSCI2110
 * Alexander Gates|B00837129
 * September 23rd, 2020
 * The Board class stores pieces in a 2d array to mimic a real life board 
 */

public class Board {

	private Piece[][] board;
	
	public Board() {board = new Piece[8][8];}
	
	//helper method for spaceEmpty
	public boolean isOnBoard(int[] pos) {
		if(pos[0] >= 0 && pos[0] <8 && pos[1] >= 0 && pos[1] <8) 
			return true;
		return false;
	}
	
	//returns true if position is empty & on the board
	public boolean spaceEmpty(Piece p) {
		if(isOnBoard(p.getPos()) && board[p.getPos()[0]][p.getPos()[1]] == null)
			return true;
		else
			return false;
	}
	
	//adds piece to the board
	public void addPiece(Piece p) {
		//check if space is empty and space is on board
		if(spaceEmpty(p))
			board[p.getPos()[0]][p.getPos()[1]] = p;
		else 
			System.out.println("Error: position not on board or piece already exists in that position\nPiece not added to board");
	}
	
	//prints the board to the console
	public void display() {
		for(int i=0; i<8;i++) {
			for (int j=0; j<8; j++) {
				if(board[i][j] == null)
					System.out.print("_\t");
				else 	
					System.out.print(board[i][j] + "\t");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	//moves pieces around the board
	public void move(int x, int y, String direction, int spaces) {	
		Piece movedPiece;
		try {
			/*I have questions on whether or not this is the best methodology
			 * Please read my QuestionsForTA.txt file  */
			
			if (board[x][y] instanceof SlowPiece) { 
				//create a temporary piece so piece can be moved
				 movedPiece = ((SlowPiece) board[x][y]).move(direction);
			}
			else {
				movedPiece = ((FastPiece) board[x][y]).move(direction,spaces);
			}
					
			//if movedPiece passed error checking in other class & is in a valid position
			if(movedPiece != null && spaceEmpty(movedPiece)) {
				//remove old piece and add new identical piece in new location
				board[x][y] = null;
				this.addPiece(movedPiece);
				System.out.println(movedPiece.getName() + " was moved to " + movedPiece.getPos()[0] + "," + movedPiece.getPos()[1]);
			}
			//!=null is so that I don't output two errors (one from here and one from one of the piece classes)
			else if(movedPiece != null)
				System.out.println("Error: Invalid move. Position off board or position occupied");

		}
		//error checking 
		catch(NullPointerException e){
			System.out.println("Error: There is no piece to move at " + x + "," + y);
		}
	}
}
