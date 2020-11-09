package cs2110Lab5;

/* This class performs basic statistical analysis(mean & mode) on a given arrayList of integers
 * @author Alexander Gates | B00837129
 * @date 2020-10-15
 */

import java.util.ArrayList;
import java.util.HashMap;

public class AverageAnalyzer {

    private ArrayList<Integer> values;

    public AverageAnalyzer(ArrayList<Integer> values){
        this.values = values;
    }

    //returns mean of values
    public double mean(){
    	double mean = 0;
    	for(Integer i:values) {
    		mean+=i;
    	}
        return mean/values.size();
    }

    //returns the mode of the values list
    public int mode() {
    	//Initialise mode HashMap: <key> will be unique nums from values & <value> will be occurrences of said unique nums. The mode will be the <key> with the greatest <value>
    	HashMap<Integer, Integer> mode = new HashMap<Integer, Integer>();
    	mode.put(values.get(0),1);
    	
    	for(int i=1; i<values.size(); i++) {
    		//if values(i) is not unique, increment that nums mode count	
    		if(mode.get(values.get(i)) != null) {
    				mode.replace(values.get(i), mode.get(values.get(i))+1);
    		}
    		else
    			mode.put(values.get(i),1);
    	}
    	
    	int modeVal = 0;
    	int maxMode = 0;
    	for(Integer i : mode.keySet()) {
    		if(mode.get(i) > maxMode) {
    			modeVal = i;
    			maxMode = mode.get(i);
    		}
    	}
    	return modeVal;
    }
}
