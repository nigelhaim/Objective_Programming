public class TestShapes{
	public static void main(String[] args) {
		if(args.length == 1)
		{
			int r =  Integer.parseInt(args[0]);
			Shapes c = new Circle(r);
			c.getDetails();
		}

		else if(args.length == 2)
		{
			int l = Integer.parseInt(args[0]);
			int w = Integer.parseInt(args[1]);
			
			if(l == w){
				Shapes s = new Square(12);
				s.getDetails();
			}

			else{
				Shapes r = new Rectangle(l, w);
				r.getDetails();
			}
		}

		else if(args.length == 3)
		{
			int side1 = Integer.parseInt(args[0]);
			int side2 = Integer.parseInt(args[1]);
			int side3 = Integer.parseInt(args[2]);
			Shapes t = new Triangle(side1, side2, side3);
			t.getDetails();
		}	

		else{System.out.print("Invalid Input");}
	}
}