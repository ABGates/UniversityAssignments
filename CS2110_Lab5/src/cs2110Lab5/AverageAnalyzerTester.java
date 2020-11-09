package cs2110Lab5;

/* This class tests the functionality of the AverageAnalyzer class
 * @author Alexander Gates | B00837129
 * @date 2020-10-15
 */

import java.io.File;
import java.util.*;
import java.io.IOException;
public class AverageAnalyzerTester {

	public static void main(String[] args) throws IOException {
		Scanner consoleIn = new Scanner(System.in);
		System.out.println("Enter the filename to read from:");
		//C:\Users\alexa\Desktop\University\Second Year\CSCI2110 - Data Structures & Algorithms\Lab5\Exercise1\Exercise1Input.txt
		
		File file = new File(consoleIn.nextLine());
		Scanner fileIn = new Scanner(file);
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		while(fileIn.hasNext()) {
			values.add(fileIn.nextInt());
		}
		
		AverageAnalyzer analyzer = new AverageAnalyzer(values);
		System.out.println("Mean: " + analyzer.mean());
		System.out.println("Mode: " + analyzer.mode());
		
		consoleIn.close();
		fileIn.close();
	}
}
