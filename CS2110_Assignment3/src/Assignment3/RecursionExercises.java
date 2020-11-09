package Assignment3;

/* This class includes methods to recursively reverse a given String starting from a given index, and to sum all the squares of all the integers less than n
 * CS2110 Assignment3 - Recursion & OrderedLists
 * @author Alexander Gates | B00837129
 * @date October 24, 2020
 */

public class RecursionExercises {

	public static void main(String[] args) {
		//starter variables
		int n = 12;   
		String s = "Floccinaucinihilipilification";
		int index = 13;
		
		System.out.println("The sum of sqaures up to " + n + " is: " + squares(n));
		System.out.println("Starting word is '" + s + "', reversed from index " + index + " is '" + reverseString(s,index) +"'");
	}
	
	/* This method recursively sums the squares of all ints <= to n
	 * @param n - int to sum until
	 * @return int - sum of all the squares
	 */
	public static int squares(int n) {
		if(n==1)
			return 1;
		else 
			return (n*n) + squares(n-1); 
	}
	
	/* This method recursively reverses a string starting at a given index from the end of the string
	 * @param n - string to reverse
	 * @param i - index to start the reverse at
	 * @return String - reversed string
	 */
	public static String reverseString(String n, int i) {
		if(i == n.length()-1)
			return n.substring(0,1);
		else
			return n.substring(n.length()-i-1, n.length()-i) + reverseString(n,i+1);
	}
	
	
	
	
	
}
