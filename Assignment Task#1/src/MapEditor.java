//Made by: Nigel Haim N. Sebastian 
import java.util.*;

public class MapEditor{
	static Scanner mapIn = new Scanner(System.in);
	public static void main(String[] args) {
			/*System.out.println("Enter rows, columns, and default character:");
			int rows = mapIn.nextInt();
			int columns = mapIn.nextInt();
			char character = mapIn.next().charAt(0);


			TextMap myMap = new TextMap(rows, columns, character);
			MapCoord coordinates = new MapCoord(rows, columns);
			System.out.println(myMap);
			
			boolean test = myMap.isValidPosition(coordinates);*/


			System.out.println("Enter rows, columns, and default character:");
			int rows = mapIn.nextInt();
			int columns =  mapIn.nextInt();
			char character = mapIn.next().charAt(0);

			TextMap myMap = new TextMap(rows, columns, character);
			boolean test = true;
			System.out.println(myMap);
			System.out.println();

			while(test == true)
			{
				System.out.println("Enter rows, columns, and default character:");
				rows = mapIn.nextInt();
				columns = mapIn.nextInt();
				character = mapIn.next().charAt(0);
				MapCoord coordinates = new MapCoord(rows, columns);
				
				test = myMap.isValidPosition(coordinates);
				
				System.out.println(test);
				myMap.setPos(coordinates, character);
				System.out.println(myMap);
				System.out.println();
			}
			
	}
}