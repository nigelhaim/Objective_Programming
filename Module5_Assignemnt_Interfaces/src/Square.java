public class Square implements Shapes{
	private int side;

	Square(int side){
		this.side = side;
	}	

	public int getSide(){
		return side;
	}

	public double getPerimeter(){
		double a = 4 * side;
		return a;
	}

	public double getArea(){
		double p = side * side;
		return p;
	}

	public void getDetails(){
	System.out.print("Type: Square"  + 
					 "\nSide: "		 + getSide() + 
					 "\nPerimeter: " + getPerimeter() + 
					 "\nArea: " 	 + getArea());
	}
}