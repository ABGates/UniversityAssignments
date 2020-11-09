package university;

/* This class tests functionality of GenericQueue using two queues,
 * one of type String, and one of type Integer
 * CSCI2110 Lab 3
 * Alexander Gates | B00837129
 * September 9th, 2020
 */

import java.util.Scanner;

public class GenericQueueTester {

	public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
		    GenericQueue<String> stringStack = new GenericQueue<String>();
		    GenericQueue<Integer> intStack= new GenericQueue<Integer>();
		    
		    //while nextIn is not quit add items to stringStack
		    while(!in.hasNext("quit")) {
		    	stringStack.enqueue(in.next());
		    }
		    
		    in.next();//iterate past 'quit' so that scanner works properly
		    
		    //while nextInt is not -1 add items to intStack
		    while(!in.hasNext("-1")) {
		    	intStack.enqueue(in.nextInt());
		    }
		    
		    System.out.println("String Stack Contents:");
		    System.out.println(stringStack.first());
		    for(int i =0; i<stringStack.size()-1; i++) {
		    	System.out.println(stringStack.next());
		    }
		    
		    System.out.println("\nInteger Stack Contents:");
		    System.out.println(intStack.first());
		    for(int i =0; i<intStack.size()-1; i++) {
		    	System.out.println(intStack.next());
		    }  
		    in.close();

	}

}
