//Made by: Nigel Haim N. Sebastian 
import java.util.*;

public class MapEditor{
	static Scanner mapIn = new Scanner(System.in);
	public static void main(String[] args) {

			//Creates the first table to be printed 

			//Greets the user 
			System.out.println("Welcome to character maps!");

			System.out.println("Made by: Nigel Haim Sebastian");
			
			//Gets the data from the user 
			System.out.println("Enter rows, columns, and default character:");
			int rows = mapIn.nextInt();
			int columns =  mapIn.nextInt();
			char character = mapIn.next().charAt(0);

			//A class that creates and changes the characters in the array.
			TextMap myMap = new TextMap(rows, columns, character);
			boolean test = true;//Initialize the test to start the looping of changing of characters in the map
			
			//Prints the first map
			System.out.println(myMap);
			System.out.println();

			//A continous loop that changes the characcter of the map in a given coordinate
			while(test == true)
			{
				//Gets the data from the user 
				System.out.println("Enter rows, columns, and default character:");
				rows = mapIn.nextInt();
				columns = mapIn.nextInt();
				character = mapIn.next().charAt(0);
				//Initiates the coordinates object
				MapCoord coordinates = new MapCoord(rows, columns);
				//Tests if the input coordinates is valid or not if the loop 
				//still continues else it is out of bounds
				test = myMap.isValidPosition(coordinates);
				
				//Imports the new character on the coordinates if valid
				myMap.setPos(coordinates, character);
				System.out.println(myMap);//Prints the map 
				System.out.println();
			}
			//If the coordinates is out of bounds the loop breaks and print
			System.out.println("Map is out of bounds!");
	}
}