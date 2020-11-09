package university;
/* LAB1|Exercise 1|CSCI 2110
 * Alexander Gates|B00837129
 * 2020-09-16
 * Circle Class creates circle objects based on 
 * centre position & radius
 */

public class Circle {

	private double xpos, ypos, radius;
	
	public Circle(double xpos, double ypos, double radius) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.radius = radius;
	}
	
	//getters
	public double getX() {return xpos;}
	public double getY() {return ypos;}
	public double getRadius() {return radius;}
	
	//setters
	public void setCenter(double x, double y) {xpos = x;  ypos = y;}
	public void setRadius(double r) {this.radius = r;}
	
	public double getArea() {return Math.PI * radius * radius;}
	public double getCircumference() {return 2 * Math.PI * radius;}
	
	//the distance between two points is often used so I made a method for it
	public double getDistance(double x1,double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
	
	/*returns true if the distance between point (x,y) and 
	 *the centre of the circle is less than the radius*/
	public boolean contains(double x, double y) {
		return this.getDistance(x, y, xpos, ypos) < radius;
	}
	
	/*returns true if the distance between point (x,y) and 
	 *the centre of the circle is equal to the radius*/
	public boolean touches(double x, double y) {
		return  this.getDistance(x, y, xpos, ypos) == radius;
	}
	
	/*returns true if the distance between the centres of the two circles
	 *plus the radius of the inner circle is less than the radius of the outer circle
	 *Thus, only returns true if inner circle is completely contained in the outer circle*/
	public boolean contains(Circle c) {
		return this.getDistance(xpos, ypos, c.getX(), c.getY()) + c.getRadius() < radius;
	}
	
	/*returns true if circle c touches this circle (only at one point)
	 *the distance between the centres of the circle must either be 
	 *equal to the outer radius + inner radius (outside & touching) or
	 *equal to the outer radius - inner radius (inside & touching)*/
	public boolean touches(Circle c) {
		if (this.getDistance(xpos, ypos, c.getX(), c.getY()) == radius + c.getRadius())
			return true;
		else if (this.getDistance(xpos, ypos, c.getX(), c.getY()) == radius - c.getRadius())
			return true;
		else
			return false;
	}
	
	public String toString() {
		return "Circle's centre is: " + xpos + ", " + ypos +
				"\nIt's radius is: " + radius + 
				"\nIt's area is: " + String.format("%.1f",this.getArea()) +
				"\nIt's circumference is: " + String.format("%.1f",this.getCircumference()) +"\n";
	}
}
