package university;

/* This class tests functionality of GenericStack using two stacks,
 * one of type String, and one of type Integer
 * CSCI2110 Lab 3
 * Alexander Gates | B00837129
 * September 9th, 2020
 */

import java.util.*;

public class GenericStackTester {

	public static void main(String[] args) {
		    Scanner in = new Scanner(System.in);
		    GenericStack<String> stringStack = new GenericStack<String>();
		    GenericStack<Integer> intStack= new GenericStack<Integer>();
		    
		    //while nextIn is not quit add items to stringStack
		    while(!in.hasNext("quit")) {
		    	stringStack.push(in.next());
		    }
		    
		    in.next();//iterate past 'quit' so that scanner works properly
		    
		    //while nextInt is not -1 add items to intStack
		    while(!in.hasNext("-1")) {
		    	intStack.push(in.nextInt());
		    }
		    
		    System.out.println("String Stack Contents:");
		    while(!stringStack.isEmpty()) {
		    	System.out.println(stringStack.pop());
		    }
		    
		    System.out.println("\nInteger Stack Contents:");
		    while(!intStack.isEmpty()) {
		    	System.out.println(intStack.pop());
		    }    
		    in.close();
	}
}
