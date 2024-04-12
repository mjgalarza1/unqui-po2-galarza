package ar.edu.unq.po2.tp3;

public class Point {

	// VARIABLES
	private int x;
	private int y;
	
	// CONSTRUCTORS
	public Point() {
		setXY(0, 0);
	}
	
	public Point(int xValue, int yValue) {
		setXY(xValue, yValue);
	}
	
	// GETTERs & SETTERs
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setXY(int xValue, int yValue) {
		x = xValue;
		y = yValue;
	}
	
	// METHODS
	public void moveX(int number) {
		x += number;
	}
	
	public void moveY(int number) {
		y += number;
	}
	
	public Point addToPoint(Point p) {
		x += p.getX();
		y += p.getY();
		return this; 
	}
}
