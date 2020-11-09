package exercise2;

/*
 * This class tests the functionality of the GradeAnalyzer class
 * @author Alexander Gates | B00837129
 * CSCI2110 | October 3rd, 2020
 * input: C:\Users\alexa\Desktop\University\Second Year\CSCI2110\A2 Student Files\Grades.txt
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradeAnalyzerTester {

    public static void main(String[] args) throws FileNotFoundException {

    	Scanner consoleIn = new Scanner(System.in);
        GradeAnalyzer analyzer = new GradeAnalyzer();
       
        System.out.println("Enter the filename to read from: [your file path here]");
        File grades = new File(consoleIn.nextLine()); 
        consoleIn.close();
        
        Scanner fileIn = new Scanner(grades);
        while(!fileIn.hasNext("-1")) {
        	String name = fileIn.next();
        	int grade = fileIn.nextInt();
        	Record r = new Record(name,grade);
        	analyzer.addRecord(r);
        }
        fileIn.close();
        
        analyzer.printAllRecords();
        System.out.println("______________________________________");
        analyzer.printHistogram();
    }
}
