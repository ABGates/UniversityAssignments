package university;
/* Assignment 1|CSCI2110
 * Alexander Gates|B00837129
 * September 23rd, 2020
 * The GameDemo class handles i/o and tests the code I have made for the "Piece Mover" game
 */

import java.util.Scanner;

public class GameDemo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Board board = new Board();

		System.out.println("Welcome to Piece Mover, The Latest & Greatest Board game Simulator");

		while(true) {
			System.out.println("Enter a command: (Type help for details)");
			
			//read each command as one line to simplify input
			String[] command = in.nextLine().split(" ");
			
			try {
				//exit command
				if(command[0].equals("exit")) { 
					System.out.println("Thank you for playing the Piece Mover!");
					break;
				}
	
				//create command
				else if (command[0].equals("create")) {
					//store useful input for later to create the piece with it
					int[] pos = {Integer.parseInt(command[1]),Integer.parseInt(command[2])};
					boolean fast = false,flexible = false;
					//if the optional conditions exist, use them
					if(command.length > 3) 
						 fast = command[3].equals("fast");
					if(command.length > 4)
						 flexible = command[4].equals("flexible");
					//error checking
					if(command.length > 5){
						System.out.println("Syntax error: Too many arguments for create commmand");
					}
					else {
						System.out.println("Input a name for your new piece:");
						String name = in.nextLine();
						System.out.println("Input a colour for your new piece:");
						String colour = in.nextLine();
					
						//create the piece & add it to the board 
						if (fast && flexible) { 
							FastFlexible ff = new FastFlexible(name, colour, pos);
						 	board.addPiece(ff);
						 	System.out.println("Created Fast Flexible piece " + name + " successfully");
						}
						else if(fast && !flexible) { 
							FastPiece fp = new FastPiece(name,colour,pos);
							board.addPiece(fp);
							System.out.println("Created Fast Non-flexible piece " + name + " successfully");
						}
						else if (!fast && flexible) {
							SlowFlexible sf = new SlowFlexible(name,colour,pos);
							board.addPiece(sf);
							System.out.println("Created Slow Flexible piece " + name + " successfully");
						}
						else {
							SlowPiece sp = new SlowPiece(name,colour,pos);
							board.addPiece(sp);
							System.out.println("Created Slow Non-flexible piece " + name + " successfully");
						}
					}
				}
				
				//move command
				else if (command[0].equals("move")) {
					int[] location = {Integer.parseInt(command[1]),Integer.parseInt(command[2])};
					String direction = command[3];
					int spaces = 1;
					if(command.length > 4) 
						spaces = Integer.parseInt(command[4]);
					//error checking
					if(command.length > 5) {
						System.out.println("Syntax error: Too many arguments for create commmand");
					}
					else
						board.move(location[0],location[1],direction,spaces);					
				}
				
				//print command
				else if (command[0].equals("print")) {
					board.display();
				}
				
				//help command
				else if (command[0].equals("help")) {
					System.out.println("List Of Commands:"
							+ "\n* - required field" 
							+ "\n1. create [x]* [y]* [fast] [flexible] - Creates a piece, defaults to slow & non-flexible"
							+ "\n2. move [x]* [y]* [direction]* [spaces] - Moves the piece at (x,y)"
							+ "\nThe direction options for the move command are 'up', 'down', 'left', 'right'"
							+"\nOnly fast pieces can use the spaces option, only flexible pieces can use up & down"
							+ "\n3. print - Displays the board"
							+ "\n4. help - Show help menu"
							+ "\n5. exit - Quit the Game");
				}
				
				//if command is not one of the acceptable commands
				else
					System.out.println("Error: Invalid Command");
			}
			//error checking 
			catch(NumberFormatException e){
				  System.out.println("Syntax Error: incorrect data type for field");
			}
			catch(ArrayIndexOutOfBoundsException e){
				  System.out.println("Syntax Error: not enough inputs for command");
			}
		}
		in.close();
	}
}
