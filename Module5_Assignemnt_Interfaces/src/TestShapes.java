public class TestShapes{
	public static void main(String[] args) {
		Shapes shape;
		if(args.length == 1)
		{
			int radius =  Integer.parseInt(args[0]);
			shape = new Circle(radius);
			shape.getDetails();
		}

		else if(args.length == 2)
		{
			int length = Integer.parseInt(args[0]);
			int width = Integer.parseInt(args[1]);
			
			if(length == width){
				shape = new Square(length);
				shape.getDetails();
			}

			else{
				shape = new Rectangle(length, width);
				shape.getDetails();
			}
		}

		else if(args.length == 3)
		{
			int side1 = Integer.parseInt(args[0]);
			int side2 = Integer.parseInt(args[1]);
			int side3 = Integer.parseInt(args[2]);
			shape = new Triangle(side1, side2, side3);
			shape.getDetails();
		}	

		else{System.out.print("Invalid Input");}
	}
}