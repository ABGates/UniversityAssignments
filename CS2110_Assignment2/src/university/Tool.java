package university;

/**
 * A basic tool class
 * @param name is the name of the tool
 * @author Alexander Gates | B00837129
 * CSCI2110 Assignment 2 | October 3rd, 2020
 */
public class Tool {

    protected String name;

    public Tool(String name){
    	this.name=name;
    }

    public String getName(){
    	return name;
    }

    public String toString(){
    	return name;
    }
}
