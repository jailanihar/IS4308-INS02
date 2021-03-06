package week3.shapeapplication;

public class Rectangle extends Shape {

	int base;
	int height;
	
	public Rectangle(String colour, int base, int height) {
		super(colour);
		this.base = base;
		this.height = height;
	}
	
	public int getArea() {
		return base * height;
	}

	public int getPerimeter() {
		return (2 * base) + (2 * height);
	}
	
}
