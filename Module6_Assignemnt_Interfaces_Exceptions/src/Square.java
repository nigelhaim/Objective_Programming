public class Square implements Shapes{
	private int side;

	Square(int side){
		this.side = side;
	}	

	public int getSide(){
		return side;
	}

	public double getPerimeter(){
		double area = 4 * side;
		return area;
	}

	public double getArea(){
		double perimeter = side * side;
		return perimeter;
	}

	public void getDetails(){
	System.out.print("Type: Square"  + 
					 "\nSide: "		 + getSide() + 
					 "\nPerimeter: " + getPerimeter() + 
					 "\nArea: " 	 + getArea());
	}
}