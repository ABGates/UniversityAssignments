package exercise2;

/*
 * This class keeps basic records for grades
 * @param gradeList is the list of all the records
 * @param gradeSummary represents the data for a histogram of the grades
 * @author Alexander Gates | B00837129
 * CSCI2110 | October 3rd, 2020
 */

public class GradeAnalyzer {
	
    //setting up a list for Records and for storing summary data on grades
    private List<Record> gradeList;
    private int[] gradeSummary;

    public GradeAnalyzer(){
       gradeList = new List<Record>();
       gradeSummary = new int[10];
    }
    
    public void addRecord(Record r) {
    	gradeList.add(r);
    }
    
    public void removeRecord(Record r) {
    	gradeList.remove(r);
    }
    
    public void clearAllRecords() {
    	gradeList.clear();
    }

    public void printAllRecords() {
    	System.out.println(gradeList.first());
    	for(int i=1; i<gradeList.size(); i++) {
    		System.out.println(gradeList.next());
    	}
    }
    
    
    //prints a histogram of the record with intervals of 9
    public void printHistogram() {
    	//fill gradeSummary with grades that fall inside [0-10), [10-20), etc.
    	//do this easily by taking advantage of truncating ints, grade/10 = where it falls in the histogram
    	int grade = gradeList.first().getGrade();
    	for(int i=1; i<gradeList.size(); i++) {
    		//100 is special since the interval [90-100] is the only one that is all inclusive
    		if(grade == 100)
    			gradeSummary[9] +=1;
    		else
    			gradeSummary[(grade)/10] +=1;
    		grade = gradeList.next().getGrade();
    	}
    	//add the last element in the list that gets missed 
    	if(grade == 100)
			gradeSummary[9] +=1;
		else
			gradeSummary[(grade)/10] +=1;
    	
	
    	//print the histogram using gradeSummary
    	for(int j=0; j<gradeSummary.length; j++) {
    		System.out.print(j*10 + "-" + (j*10+10) + "|");
    		int count = gradeSummary[j];
    		while(count>0) {
    			System.out.print("*");
    			count--;
    		}
    		System.out.println();
    	}
    	
    }
}
