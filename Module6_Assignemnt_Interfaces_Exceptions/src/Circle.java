public class Circle implements Shapes{
	
	public static float PI = 3.14f; 
	private int radius;
	
	public Circle(int radius){
		this.radius = radius;
	}
	public int getRadius(){
		return radius;
	}
	public double getPerimeter(){
		double perimeter = PI * 2 * radius;
		return perimeter;
	}
	public double getArea(){
		double area = PI * (radius * radius);
		return area;
	}

	public void getDetails(){
		System.out.print("Type: Circle"  + 
						 "\nRadius: "		 + getRadius() + 
						 "\nPerimeter: " + getPerimeter() + 
						 "\nArea: " 	 + getArea());
	}
}