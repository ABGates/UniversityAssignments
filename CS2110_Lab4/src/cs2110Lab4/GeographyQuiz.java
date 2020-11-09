package cs2110Lab4;

/**
This class tests the code for Lab4: Exercise2. It creates a GeographyQuiz,
adding elements from an input file to an unordered list, then calling them up
randomly to provide questions and answers for the game. Remember that different lists add elements in FiLo or LiFo.
It expands upon a framework provided by Srini (Dr. Srini Sampalli). Modified by Rob from previous version.

Code that is not part of the framework done by:
Alexander Gates | B00837129
*/

//import Labs.Lab4Fall2020.List;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class GeographyQuiz {
	public static void main(String[] args) throws IOException {
        // initialize Scanner to capture user input
        Scanner consoleIn = new Scanner(System.in);

        // capture file information from user and read file
        System.out.println("Enter a file to read input from:");
        //C:\Users\alexa\Desktop\University\Second Year\CSCI2110 - Data Structures & Alorithms\Lab4\Exercise 2\CountryCapitals.txt
        File quizInfo = new  File(consoleIn.nextLine());
        Scanner fileIn = new Scanner(quizInfo);

        // initialize List to store data from the text file
        List<String> capitals = new List<String>();

        //fill capitals with information from file
        while(fileIn.hasNext()) {
        	capitals.add(fileIn.nextLine());
        }
        
        //for random number generation
        Random rand = new Random();
        
        //for the score
        double quesAns = 0;
        double quesCorr = 0;
        //for comparing answers
        String quizAns;
        String question;
        String userAns;
        
        System.out.println("Game loaded with answers from file\nWelcome to the Country-Capital Quiz!");
        while(true) {
        	System.out.println("Play?");
        	String play = consoleIn.nextLine();
        	
        	if(play.toLowerCase().equals("no"))
        		break;
        	
        	else if(play.toLowerCase().equals("yes")) {
        		
        		 //This section of code is for randomly determining the question & answer
        		int r = rand.nextInt(capitals.size());
        		String traverse = capitals.first();
        		//if the random num is even - question will be country, answer will be capital
        		if(r%2 == 0) {
        			//arrive at our randomly selected question by traversing through list r times
        			for(int i=1; i<= r; i++) {
        				traverse = capitals.next();
        			}
        			quizAns = traverse;
        			traverse = capitals.next();
        			question = traverse;
        			
        			System.out.println("What is the capital of " + question + "?");
        			userAns = consoleIn.nextLine();
        			if(userAns.equals(quizAns)) {
        				System.out.println("Correct!");
        				quesAns++;
        				quesCorr++;
        			}
        			else {
        				System.out.println("Incorrect. The correct answer is: " + quizAns);
        				quesAns++;
        			}	
        		}
        		//if the random num is odd - question will be capital, answer will be country
        		else {
        			//arrive at our randomly selected question by traversing through list r times
        			for(int i=1; i< r; i++) {
        				traverse = capitals.next();
        			}
        			question = traverse;
        			traverse = capitals.next();
        			quizAns = traverse;
        			
        			System.out.println("What country has " + question + " as its capital?");
        			userAns = consoleIn.nextLine();
        			if(userAns.equals(quizAns)) {
        				System.out.println("Correct!");
        				quesAns++;
        				quesCorr++;
        			}
        			else {
        				System.out.println("Incorrect. The correct answer is: " + quizAns);
        				quesAns++;
        			}
        		}
        	}
        }
        
        DecimalFormat intType = new DecimalFormat("#");
        DecimalFormat percent = new DecimalFormat("#.##'%'");
        System.out.println("Game Stats:\nQuestions Played: " + intType.format(quesAns) + ", Correct Answers: " + intType.format(quesCorr) + ", Score: " + percent.format(100*quesCorr/quesAns));
        consoleIn.close();
        fileIn.close();

	}
}
