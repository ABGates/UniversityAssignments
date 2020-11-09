package exercise2;

/*
 * This is a basic record class
 * @param name = name on record
 * @param grade = grade on record
 * @author Alexander Gates | B00837129
 * CSCI2110 | October 3rd, 2020
 */

public class Record {

	private String name;
	private int grade;
	
	public Record(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String toString(){
		return name + "," + grade;
	}
}
