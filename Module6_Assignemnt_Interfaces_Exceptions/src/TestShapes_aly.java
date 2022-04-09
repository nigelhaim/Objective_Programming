 public class TestShapes_aly
{
	public static void main(String[] args)
	{
		long start = System.nanoTime();
		
		int[] convertedArray = new int[args.length];
		try
		{
			if (args.length == 0) // 1 is the min number of inputs (outside loop because loop will run if the array has inputs)
				throw new NullPointerException();
			for (int i = 0; i < args.length; i++)
			{
				if (args.length > 3) // 3 is the max number of inputs
					throw new NullPointerException();
				else if (Integer.parseInt(args[i]) != Integer.valueOf(args[i])) // args in int != data type of args
					throw new NumberFormatException();
				else if (Integer.parseInt(args[i]) < 0) // no negative numbers
					throw new IllegalArgumentException();
				else
					convertedArray[i] = Integer.parseInt(args[i]); // adds the converted String to the int array
			}
		}
		
		catch (NullPointerException npe)
		{
			if (args.length == 0) // 1 - 3 inputs only
				System.err.print("Pass one to three values via command line.\n" 
							+ "An IllegalArgumentException is caught.");
			else
				System.err.print("Limit your arguments to a maximum of 3 values.\n" 
							+ "An IllegalArgumentException is caught.");
			System.exit(0);
		}
		
		catch (NumberFormatException nfe) // no Strings allowed
		{
			System.err.print("An argument contains a String value.\n"
							+ "A NumberFormatException is caught.");
			System.exit(0);
		}
		
		catch (IllegalArgumentException iae) // no negative values
		{
			System.err.print("A negative value was passed.\n"
							+ "An IllegalArgumentException is caught.");
			System.exit(0);
		}
		
		finally{
			long end = System.nanoTime();
			System.out.print("\nRuntime: ");
			System.out.println(end - start);
		}
		Shapes shape = null;
		
		if (convertedArray.length == 1)
			shape = new Circle(convertedArray[0]); // shape takes on the Circle object
		else if (convertedArray.length == 2)
		{
			if (convertedArray[0] == convertedArray[1])
				shape = new Square(convertedArray[0]); // shape takes on the Square object
			else
				shape = new Rectangle(convertedArray[0], convertedArray[1]); // shape takes on the Rectangle object
		}
		else if (convertedArray.length == 3)
			shape = new Triangle(convertedArray[0], convertedArray[1], convertedArray[2]); // shape takes on the Triangle object
		shape.getDetails(); // prints the details of the shape
	}
}