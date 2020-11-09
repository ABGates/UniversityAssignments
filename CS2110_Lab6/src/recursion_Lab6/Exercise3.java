package recursion_Lab6;

/* Lab 6 Exercise  for CS2110
 * @author Alexander Gates | B00837129
 * @date October 24, 2020
 * This class contains a method to print m multiples of an integer n recursively, and a main method to test it
 */

import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter an integer value:");
		int n = in.nextInt();
		System.out.println("How many multiples do you want?");
		int m = in.nextInt();
		
		System.out.println("The first " + m + " multiples of " + n + " are:");
		multiples(n,m);
		
		
		in.close();
	}
	
	/* This method prints the first m multiples of n in descending order
	 * @param n - base number
	 * @param m - number of multiples
	 */
	public static void multiples(int n, int m) {
		if(m == 1) {
			System.out.print(n);
			return;
		} 
		else {
			System.out.print(n*m + ", ");
			multiples(n,m-1);
		}
		
	}

}
