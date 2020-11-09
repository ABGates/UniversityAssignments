package cs2110Lab5;

/* This class tests the functionality of the SetAnalyzer class
 * @author Alexander Gates | B00837129
 * @date 2020-10-15
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class SetAnalyzerTester {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner consoleIn = new Scanner(System.in);
		
		//lists
		ArrayList<String> string1 = new ArrayList<String>();
		ArrayList<String> string2 = new ArrayList<String>();
		ArrayList<Integer> int1 = new ArrayList<Integer>();
		ArrayList<Integer> int2 = new ArrayList<Integer>();
		
		//analysers
		SetAnalyzer<String> stringAnalyzer = new SetAnalyzer<String>();
		SetAnalyzer<Integer> intAnalyzer = new SetAnalyzer<Integer>();
		
		System.out.println("Will you be analyzing Strings or Integers?");	
		String genericType = consoleIn.nextLine();

		//C:\Users\alexa\Desktop\University\Second Year\CSCI2110 - Data Structures & Algorithms\Lab5\Exercise2\Exercise2ListX.txt
		if(genericType.toLowerCase().equals("strings")) {
			//fill the lists with info from files
			System.out.println("Enter the filename for set 1:");
			File file1 = new File(consoleIn.nextLine());
			Scanner set1 = new Scanner(file1);
			while(set1.hasNextLine()) {
				string1.add(set1.nextLine());
			}
			
			System.out.println("Enter the filename for set 2:");
			File file2 = new File(consoleIn.nextLine());
			Scanner set2 = new Scanner(file2);
			while(set2.hasNextLine()) {
				string2.add(set2.nextLine());
			}
			
			System.out.println("Intersection of sets 1 & 2 is: " + stringAnalyzer.intersection(string1, string2));
			System.out.println("Union of sets 1 & 2 is: " + stringAnalyzer.union(string1, string2));
			
			set1.close();
			set2.close();
		}
		else if(genericType.toLowerCase().equals("integers")) {
			System.out.println("Enter the filename for set 1:");
			File file1 = new File(consoleIn.nextLine());
			Scanner set1 = new Scanner(file1);
			while(set1.hasNextInt()) {
				int1.add(set1.nextInt());
			}
			
			System.out.println("Enter the filename for set 2:");
			File file2 = new File(consoleIn.nextLine());
			Scanner set2 = new Scanner(file2);
			while(set2.hasNextInt()) {
				int2.add(set2.nextInt());
			}
			
			System.out.println("Intersection of sets 1 & 2 is: " + intAnalyzer.intersection(int1, int2));
			System.out.println("Union of sets 1 & 2 is: " + intAnalyzer.union(int1, int2));
			
			set1.close();
			set2.close();
		}
		else 
			System.out.println("Not a valid answer");
		
		consoleIn.close();
	}
}
