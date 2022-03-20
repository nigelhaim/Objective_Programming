/*

Test shapes module 6 Exception handling version 1

*/
public class TestShapes_final{
	public static void main(String[] args) 
	{
		long start = System.nanoTime();
		try{
			for(int i = 0; i < args.length; i++){
				if(Integer.parseInt(args[i]) < 0){
					throw new IllegalArgumentException("A negative value was passed.");
				}
			}
			if(args.length == 0){
				throw new IllegalArgumentException("Pass one to three values via command line.");
			}

			if(args.length > 3){
				throw new IllegalArgumentException("Limit your arguments to a maximum of 3 numbers.");
			}
		}catch(NumberFormatException nfe){
			System.out.println("An argument contains a string value.\nNumberFormatException is caught.");
			System.exit(0);
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage() + "\nAn IllegalArgumentException is caught.");
			System.exit(0);
		}

		finally{
			long end = System.nanoTime();
			System.out.print("\nRuntime: ");
			System.out.println(end - start);
		}

		Shapes shape = null;
		if(args.length == 1){
			int radius =  Integer.parseInt(args[0]);
			shape = new Circle(radius);
		}

		else if(args.length == 2){
			int length = Integer.parseInt(args[0]);
			int width = Integer.parseInt(args[1]);
			
			if(length == width){
				shape = new Square(length);
			}

			else{
				shape = new Rectangle(length, width);
			}
		}

		else if(args.length == 3){
			int side1 = Integer.parseInt(args[0]);
			int side2 = Integer.parseInt(args[1]);
			int side3 = Integer.parseInt(args[2]);
			shape = new Triangle(side1, side2, side3);
		}
		shape.getDetails();
	}
}


