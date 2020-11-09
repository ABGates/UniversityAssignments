package recursion_lab7;

/* This class prints a BlastOff! count down recursively
 * @author Alexander Gates | B00837129
 * @date October 26th, 2020
 */

import java.util.Scanner;

public class Exercise2 {
	
	//takes a single user input and prints the BlastOff! message
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter an integer to BlastOff! with:");
		int count = in.nextInt();
		countDown2(count);
		
		in.close();
	}
	
	//recursively prints down by 2 from a number & prints "BlastOff!" at the base cases
	public static void countDown2(int n) {
		if(n==1||n==2) 
			System.out.print(n+"\tBlastOff!");
		else if(n>2) {
			System.out.print(n+"\t");
			countDown2(n-2);
		}
		else
			System.out.println("Can't BlastOff! Backwards");
	}
}
