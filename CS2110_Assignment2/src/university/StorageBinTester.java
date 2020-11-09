package university;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to test the functionality of the StorageBin class, Tool class & all of its subclasses
 * @author Alexander Gates | B00837129
 * CSCI2110 Assignment 2 | October 3rd, 2020
 */
public class StorageBinTester {

    public static void main(String[] args) {
    	
    	Scanner in = new Scanner(System.in);
    	
        StorageBin<Tool, Integer> bin = new StorageBin<Tool, Integer>();
        ArrayList<Tool> workbelt = new ArrayList<Tool>();
        
        System.out.println("Enter tools to be stored in a bin in the format ItemName ID");
        
        //while the input is not quit
        while(!in.hasNext("quit")) {
        	Tool temp;
        	String toolName = in.next();
        	//use switch cases to actually use hammer, saw, level classes if applicable
        	switch(toolName.toLowerCase()) {
        		case "hammer":
        			temp = new Hammer(toolName);
        			((Hammer) temp).setFunction("I hammer stuff");
        			break;
        		case "saw":
        			temp = new Saw(toolName);
        			((Saw) temp).setFunction("I saw stuff");
        			break;
        		case "level":
        			temp = new Level(toolName);
        			((Level) temp).setFunction("I make sure everything is even");
        			break;
        		default:
        			temp = new Tool(toolName);
        	}
        	int id = in.nextInt();
        	bin.addItem(temp, id);
        }
    	
        //display bin contents
        System.out.println("Items in storage bin:");
        bin.displayItems();
        
        //fix for scanner not moving to newline after 'quit' is entered
        in.next();
        //while input is not "no" move specified items from bin to workbelt
        while(true){
        	System.out.println("Would you like to retrieve a tool and add it to the workbelt? [yes/no]");
        	String cont = in.next();
        	if(cont.equals("no"))
        		break;
        	else if(cont.equals("yes")) {
        		System.out.println("Enter ID of tool to move to workbelt");
        		workbelt.add(bin.removeItem(in.nextInt()));
        		System.out.println("Moved tool from storage bin to workbelt");
        	}
        	else
        		System.out.println("Please enter yes or no");
        }
      
        //display items left in bin & in workbelt
        System.out.println("Okay have a nice day! \nTools left in bin:");
        bin.displayItems();
        
        System.out.println("Tools in workbelt:");
        for(Tool t: workbelt) {
        	System.out.println(t);
        }
        
        in.close();

    }
}
