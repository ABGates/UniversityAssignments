package recursion_lab7;

/* This Class can recursively calculate the nth number in the Fibonacci sequence 
 * @author Alexander Gates | B00837129
 * @date October 26th, 2020
 */

public class Exercise1 {
	
	//prints the first 20 numbers in the Fibonacci sequence
	public static void main(String[] args) {
		for(int i = 0; i<20; i++) 
			System.out.print(fib(i) + ",");
	}
	
	//Recursively calculates nth number of Fibonacci sequence
	public static int fib(int n) {
		if(n==0)
			return 0;
		else if(n==1) 
			return 1;
		else if (n>1)
			return fib(n-1)+fib(n-2);
		else 
			return -1;
	}
}
