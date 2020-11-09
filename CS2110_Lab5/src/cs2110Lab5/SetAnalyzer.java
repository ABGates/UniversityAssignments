package cs2110Lab5;

/* This class performs intersection & union tests on two generic lists with unique entries
 * @author Alexander Gates | B00837129
 * @date 2020-10-15
 */

import java.util.ArrayList;

public class SetAnalyzer<T> {

    public SetAnalyzer(){}

    //returns the intersection of two lists.  Ex: intersection of {A,B,C} & {B,C,D} is {B,C}
    public ArrayList<T> intersection(ArrayList<T> list1,ArrayList<T> list2){
    	ArrayList<T> intersection = new ArrayList<T>();
    	
    	for(T item1 : list1) {
    		for(T item2 : list2) {
    			if(item1.equals(item2)) 
    				intersection.add(item1);
    		}
    	}
    	
    	return intersection;
    }

    //returns the union of two lists.  Ex: union of {A,B,C} & {B,C,D} is {A,B,C,D}
    public ArrayList<T> union(ArrayList<T> list1, ArrayList<T> list2){
    	ArrayList<T> union = new ArrayList<T>();
    	
    	//add all of list1 to union list
    	for(T item : list1) {
    		union.add(item);
    	}
    	//loop through all of list2 and if its items are not already in union, add them
    	for(T item : list2) {
    		if(union.indexOf(item) == -1)
    			union.add(item);
    	}
    	
    	return union;
    }


}
