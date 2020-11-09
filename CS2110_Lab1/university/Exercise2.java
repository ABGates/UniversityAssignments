package university;
/* LAB1|Exercise 1|CSCI 2110
 * Alexander Gates|B00837129
 * 2020-09-16
 * Exercise2 Class tests the functionality of Circle class
 */

import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numTests = in.nextInt();
		
		/*create an array to store and then process test input when 
		*it is presented in multiple lines with a variable number of inputs*/
		Double[] userIn = new Double[6*numTests];
		int c = 0;
		while(c<numTests*6) {
			userIn[c] = in.nextDouble();
			c++;
		}
		in.close();
		
		/*create circle objects with user input stored in userIn
		*because the amount of circles is variable I will create them in a loop
		*and store them in an array*/ 
		Circle[] circles = new Circle[numTests * 2];
		for(int i = 0; i<numTests*6; i+=3) {
			circles[i/3] = new Circle(userIn[i], userIn[i+1], userIn[i+2]);
		}
		

		//output
		for(int i = 0; i<numTests*2; i+=2) {
			System.out.println("The first " + circles[i]);
			System.out.println("The second " + circles[i+1]);
			System.out.println("The contains method returns: " + circles[i].contains(circles[i+1]));
			System.out.println("The touches method returns: " + circles[i].touches(circles[i+1]) +"\n\n");
		}
	}
}
