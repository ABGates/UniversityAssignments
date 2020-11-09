package university;
/* LAB1|Exercise 1|CSCI 2110
 * Alexander Gates|B00837129
 * 2020-09-16
 * Exercise1 Class tests functionality of rectangle class
 */

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numTests = in.nextInt();
		
		/*create an array to store and then process test input when 
		*it is presented in multiple lines with a variable number of inputs*/
		Double[] userIn = new Double[8*numTests];
		int c = 0;
		while(c<numTests*8) {
			userIn[c] = in.nextDouble();
			c++;
		}
		in.close();
		
		/*create rectangle objects with user input stored in userIn
		*because the amount of rectangles is variable I will create them in a loop
		*and store them in an array*/ 
		Rectangle[] rectangles = new Rectangle[numTests * 2];
		for(int i = 0; i<numTests*8; i+=4) {
			rectangles[i/4] = new Rectangle(userIn[i], userIn[i+1], userIn[i+2], userIn[i+3]);
		}


		//output
		for(int i = 0; i<numTests*2; i+=2) {
			System.out.println("The first " + rectangles[i]);
			System.out.println("The second " + rectangles[i+1]);
			System.out.println("The contains method returns: " + rectangles[i].contains(rectangles[i+1]));
			System.out.println("The touches method returns: " + rectangles[i].touches(rectangles[i+1]) +"\n\n");
		}
	}
}
