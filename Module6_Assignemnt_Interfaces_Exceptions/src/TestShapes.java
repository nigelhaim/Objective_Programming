/*

Test shapes module 6 Exception handling version 1

*/
public class TestShapes{
	public static void main(String[] args) 
	{
		long start = System.nanoTime();
		try{
			if(Integer.parseInt(args[0]) > 0){
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
			else{
				throw new Exception("A negative value was passed.");
				//throw new Exception();
			}
		}catch(NumberFormatException nfe){
			System.out.println("An argument contains a String value.\nA NumberFormatException is caught.");
		}
		catch(ArrayIndexOutOfBoundsException aiobe){
			System.out.println("Pass one to three values via command line." + "\nAn IllegalArgumentException is caught.");
			//throw Exception();
		}
		catch(NullPointerException npe){
			System.out.println("The limit of your arguments to a maximumn of 3 values." + "\nAn IllegalArgumentException is caught.");
			//throw Exception();
		}
		catch(Exception e){
			System.out.println(e.getMessage() + "\nAn IllegalArgumentException is caught.");
		}
		finally{
			long end = System.nanoTime();
			System.out.print("\nRuntime: ");
			System.out.println(end - start);
		}
	}
}

