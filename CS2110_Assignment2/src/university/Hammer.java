package university;

/**
 * A class for Hammer objects
 * @param name is the name of the tool (will be hammer)
 * @param function is the tools function
 * @author Alexander Gates | B00837129
 * CSCI2110 Assignment 2 | October 3rd, 2020
 */

public class Hammer extends Tool {

	public String function;
	
	public Hammer(String name) {
		super(name);
	}
	
	public void setFunction(String function)
	{
		this.function = function;
	}
	
	public String toString() {
		return name + " Function:" + function;
	}
}
