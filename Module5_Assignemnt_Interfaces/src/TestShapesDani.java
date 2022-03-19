/*
 * TestShapes.java file
 * Module 4 Synchronous - Polymorphism 
 * Sophia Danielle F. Durana - 1CSA
 * March 10, 2022
 */
public class TestShapesDani
{
	public static void main(String args[])
	{
		int argsLength = args.length;
		int[] intArgs = new int [argsLength];
		int counter = 0; // to count number of elements for args
		
		// parsing String args array into int
		for (int i = 0; i < argsLength; i++) {
			intArgs[i] = Integer.parseInt(args[i]);
			counter++;
		}

		//Shapes shapes = new Shapes;
		
		switch (counter) {
			
			case 0:
			Shapes shapes = new Circle(intArgs[0]);
			shapes.getDetails();
			break; 
			
			case 1:
			int l, w;
			l = intArgs[0];
			w = intArgs[1];
			
			if (l == w) {
				Shapes s = new Square(intArgs[0]);
				s.getDetails();
			} else {
				Shapes r = new Rectangle(intArgs[0], intArgs[1]);
				r.getDetails();
			}
			break;
			
			case 2:
			Shapes t = new Triangle(intArgs[0], intArgs[1], intArgs[2]);
			t.getDetails();
			
			default:
			System.out.println("\nInvalid Input");
			break;
		} System.out.print(counter);
	}
}
	