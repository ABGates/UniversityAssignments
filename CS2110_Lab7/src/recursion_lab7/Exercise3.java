package recursion_lab7;

/* This class recursively prints a given integer vertically 
 * @author Alexander Gates | B00837129
 * @date October 26th, 2020
 * Some information for this class sourced from the Wikipedia page on Logarithms
 * [1]	“Logarithm,” Wikipedia, 22-Oct-2020. [Online]. Available: https://en.wikipedia.org/wiki/Logarithm#Particular_bases 
 * 		[Accessed: 27-Oct-2020]. 
 */

import java.util.Scanner;

public class Exercise3 {
	
	//take a single integer input and run writeVertical
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter an integer to write vertically:");
		int n = in.nextInt();
		writeVertical(n);
		
		in.close();
	}
	
	//Recursively prints the digits of a number starting at the left-most digit 
	public static void writeVertical(int n) {
		
		//[1] represents the nearest power of ten less than n, used to make code more readable
		int leftMostDigit = (int) (Math.pow(10, Math.floor(Math.log10(n))));
		
		if(n < 10) 
			System.out.println(n);
		else if(n >= 10) {
			System.out.println(n / leftMostDigit);
			writeVertical(n % leftMostDigit);
		}
	}
}
