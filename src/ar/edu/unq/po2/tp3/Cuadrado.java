package ar.edu.unq.po2.tp3;

public class Cuadrado {
	
	// VARIABLES
	private Point upperLeftCorner = new Point();
	private Point upperRightCorner = new Point();
	private Point lowerLeftCorner = new Point();
	private Point lowerRightCorner = new Point();
	
	// CONSTRUCTORS
	public Cuadrado(Point origin, int width, int height) throws Exception {
		
		// Width and Height MUST be greater than zero (throws EXCEPTION otherwise)
		if (width < 0 || height < 0) {
			throw new Exception("Could not create the square: WIDTH and HEIGHT must be greater than zero.");
		}
		
		// Set origin point
		upperLeftCorner.addToPoint(origin);
		// Set lower left corner point
		lowerLeftCorner.addToPoint(upperLeftCorner);
		lowerLeftCorner.moveY(height);
		// Set upper right corner point
		upperRightCorner.addToPoint(upperLeftCorner);
		upperRightCorner.moveX(width);
		// Set lower rightcorner point
		lowerRightCorner.addToPoint(lowerLeftCorner);
		lowerRightCorner.moveX(width);
	}
	
	// METHODS
	public int width() {
		return (lowerRightCorner.getX() - lowerLeftCorner.getX());
	}
	
	public int height() {
		return (lowerLeftCorner.getY() - upperLeftCorner.getY());
	}
	
	public int area() {
		int area = width() * height();
		return area;
	}
	
	public int perimeter() {
		int perimeter = (width() + height()) * 2;
		return perimeter;
	}
	
	public Boolean isHorizontal() {
		return (width() >= height());
	}
	
	public Boolean isVertical() {
		return !isHorizontal();
	}
}
