package recursion_Lab6;

/* Lab 6 Exercise 2 for CS2110
 * @author Alexander Gates | B00837129
 * @date October 24, 2020
 * This class contains a method to print a count down recursively, and a main method to test it
 */

import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter an integer:");
		int count = in.nextInt();
		countDown(count);
		
		in.close();

	}
	
	/* This method counts down from n then prints "BlastOff!"
	 * @param n - number to count down from
	 */
	public static void countDown(int n) {
		if(n == 1) {
			System.out.print("1\tBlast Off!");
			return;
		}
		
		else {
			System.out.print(n + "\t");
			countDown(n-1);
		}
	}

}
