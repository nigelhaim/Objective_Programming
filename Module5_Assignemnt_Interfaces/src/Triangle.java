import java.math.*;
public class Triangle implements Shapes{
	private int side1;
	private int side2;
	private int side3;
	
	public Triangle(int side1, int side2, int side3){
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public int getSide1(){
		return side1;
	}
	public int getSide2(){
		return side2;
	}
	public int getSide3(){
		return side3;
	}

	public double getPerimeter(){
		double p = side1 + side2 + side3;
		return p;
	}

	public double getArea(){
		double s = (side1 + side2 + side3) / 2;
		double a = Math.sqrt(s * (s - side1)*(s - side2) * (s - side3));
		return a;
	}


	public void getDetails(){
	System.out.print("Type: Triangle"  + 
					 "\nSide1: "		 + getSide1() + 
					 "\nSide2: "		 + getSide2() + 
					 "\nSide3: "		 + getSide3() + 
					 "\nPerimeter: " + getPerimeter() + 
					 "\nArea: " 	 + getArea());
	}
}