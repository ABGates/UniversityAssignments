package university;
/* LAB1|Exercise 1|CSCI 2110
 * Alexander Gates|B00837129
 * 2020-09-16
 * Rectangle Class creates rectangles objects based on 
 * top left corner position, width, & height
 */


public class Rectangle {
	private double xpos, ypos, width, height; 
	
	public Rectangle(double xpos, double ypos, double width, double height) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.height = height;
		this.width = width;
	}
	
	//setters
	public void setX(double xpos) {this.xpos = xpos;}
	public void setY(double ypos) {this.ypos = ypos;}
	public void setWidth(double width) {this.width = width;}
	public void setHeight(double height) {this.height = height;}
	//getters 
	public double getX() {return this.xpos;}
	public double getY() {return this.ypos;}
	public double getWidth() {return this.width;}
	public double getHeight() {return this.height;}
	
	//returns true if this rectangle contains point (px,py)
	//does not return true if this rectangle is touching point (px,py)
	public boolean contains(double px, double py) {
		return (xpos < px && xpos + width > px && ypos < py && ypos + height > py);
	}
	
	//return true if this rectangle contains rectangle r
	//does not return true if this rectangle is touching rectangle r
	public boolean contains(Rectangle r) {
		return(this.contains(r.getX(), r.getY()) && 
			   this.contains(r.getX() + r.getWidth(), r.getY() + r.getHeight()));
	}
	
	//returns true if this rectangle is touching point (px,py)
	public boolean touches(double px, double py) {
		if (px == xpos && (py >= ypos && py <= ypos + height))
			return true;
		else if (px == xpos + width && (py >= ypos && py <= ypos + height))
			return true;
		else if (py == ypos && (px >= xpos && px <= xpos + width))
			return true;
		else if (py == ypos + height && (px >= xpos && px <= xpos + width))
			return true;
		else 
			return false;
	}
	
	//returns true if this rectangle is touching rectangle r 
	public boolean touches(Rectangle r) {
		if (this.touches(r.getX(), r.getY()))
			return true;
		else if (this.touches(r.getX() + r.getWidth(), r.getY()))
				return true;
		else if (this.touches(r.getX() + r.getWidth(), r.getY() + r.getHeight()))
			return true;
		else if (this.touches(r.getX(), r.getY() + r.getHeight()))
			return true;
		else 
			return false;
	}
	
	public String toString() {
		return "Rectangle's top corner is: " +xpos + ", " + ypos +
			   "\nIt's width is: " + width + 
			   "\nIt's height is: " + height + "\n";
	}
}
