package Assignment3;

/* This class takes two files as input, creates two ordered lists from those files, and then creates a third list that is the merge of lists 1&2
 * CS2110 Assignment3 - Recursion & OrderedLists
 * @author Alexander Gates | B00837129
 * @date October 24, 2020
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderedListDemo {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner consoleIn = new Scanner(System.in);
		
		System.out.println("Enter first file name to read from:");
		File list1 = new File(consoleIn.nextLine());
		OrderedList<String> names1 = createList(list1);
		
		System.out.println("Enter a second file to read from:");
		File list2 = new File(consoleIn.nextLine());
		OrderedList<String> names2 = createList(list2);
		
		System.out.println("The Two OrderedLists Are:\nList 1:");
		names1.enumerate();
		System.out.println("List 2:");
		names2.enumerate();
		
		OrderedList<String> merged = merge(names1, names2);
		System.out.println("\nA merged version of the two lists is:");
		merged.enumerate();
		
		consoleIn.close();
	}
	
	/* This method merges two OrderedLists using the two-finger walking algorithm
	 * @param list1,list2 - lists to be merged
	 * @return OrderedList<T> - merged list 
	 */
	public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2){
		T curr1 = list1.first();
		T curr2 = list2.first();
		OrderedList<T> merged = new OrderedList<T>();
		
		//compare each element of list & list2, add the lower element, and increment that lists counter
		while(curr1 != null && curr2 != null) {
			if(curr1.compareTo(curr2) < 0) {
				merged.add(curr1);
				curr1 = list1.next();
			}
			else if(curr1.compareTo(curr2) > 0) {
				merged.add(curr2);
				curr2 = list2.next();
			}
			else {
				merged.add(curr1);
				curr1 = list1.next();
				curr2 = list2.next();
			}
		}
		
		//if additional elements in list1, add them
		while(curr1 != null) {
			merged.add(curr1);
			curr1 = list1.next();
		}
		
		//if additional elements in list2, add them
		while(curr2 != null) {
			merged.add(curr2);
			curr2 = list2.next();
		}
		return merged;
	}
	
	/* This method creates an OrderedList from a file
	 * @param f - File to read from
	 * @return OrderedList<String> - OrderedList filled with contents from file
	 */
	public static  OrderedList<String> createList(File f) throws FileNotFoundException{
		Scanner fileIn = new Scanner(f);
		OrderedList<String> list = new OrderedList<String>();
		while(fileIn.hasNext()) {
			list.insert(fileIn.nextLine());
		}
		fileIn.close();
		return list;
	}
	
}
