public class Rectangle implements Shapes{
	private int length;
	private int width;

	public Rectangle(int length, int width){
		this.length = length;
		this.width 	= width;
	}

	public int getlength(){
		return length;
	}

	public int getwidth(){
		return width;
	}

	public double getPerimeter(){
		double p = 2 * (length + width);
		return p;
	}
	public double getArea(){
		double a = length * width;
		return a;
	}

	public void getDetails(){
		System.out.print("Type: Rectangle"  + 
						 "\nLength: "		 + getlength() + 
						 "\nWidth:"		 + getwidth() +
						 "\nPerimeter: " + getPerimeter() + 
						 "\nArea: " 	 + getArea());
	}
}