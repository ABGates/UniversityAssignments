package recursion_Lab6;

/* Lab 6 Exercise 1 for CS2110
 * @author Alexander Gates | B00837129
 * @date October 24, 2020
 * This class contains methods to calculate factorials and exponents recursively, and a main method to test them
 */


import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		//print factorials 1-10
		System.out.println("Factorials");
		for(int i=1; i<=10; i++) {
			System.out.println(i + "! = " + factorial(i));
		}
		
		//take user in and do exponents until user in says no to
		boolean cont = true;
		do {
			System.out.println("Enter an int value for the base:");
			int x = in.nextInt();
			System.out.println("Enter an int value for the exponent:");
			int n = in.nextInt();
			
			System.out.println(x + " to the power of " + n + " is " + power(x,n));
			
			System.out.println("Do another power calculation (true/false)?");
			cont = in.nextBoolean();
			
		} while(cont);
		
		in.close();
	}
		
	/* Method returns factorial of n
	 * @param n - number you want to find the factorial of
	 * @return int - factorial of n
	 */
	public static int factorial(int n) {
		if (n==0)
			return 1;
		else if(n>0) 
			return n*factorial(n-1);
		else {
			System.out.println("Negative numbers do not have a factorial");
			return -1;
		}
	}
	
	/* Method returns x to the power of n
	 * @param x - base number
	 * @param n - exponent number
	 * @return int - x to the power n
	 */
	public static int power(int x, int n) {
		if(n==0)
			return 1;
		else if(n>0)
			return x*power(x,n-1);
		else {
			System.out.println("Power method cannot do negative powers");
			return -1;
		}
	}
}
