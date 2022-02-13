public class TextMap{

	//Initiates the private variables 
	private int rowCnt;
	private int colCnt;
	private char defaultC;
	private	char char_arr[][];
	
	//sets the variables for the private variables 
	public TextMap(int rowCnt, int colCnt, char defaultChar){
		//Gets the data from the MapEditor
		this.rowCnt = rowCnt;//stores the value of the row counts in the private variable
		this.colCnt = colCnt;//stores the value of the column counts in the private variable
		this.defaultC = defaultChar;//Stores the default char
		this.char_arr = new char[rowCnt][colCnt];//Creates the default size of the array

		//Stores the default char to every coordinate in the array
		for(int i = 0; i < rowCnt; i++){
			for(int j = 0; j < colCnt; j++)
			{
				char_arr[i][j] = defaultChar;
			}
		}
	}


	public int getRowCnt(int rowCnt){
		return rowCnt;
	}

	
	public int getColumnCnt(int colCnt){
		return colCnt;
	}
	//Method that will test if the coordinate is in valid position 
	public boolean isValidPosition(MapCoord coord){

		//Need to separate the MapCoord's two integers (row and column)
		int row_edit = coord.getRow();//Gets the row coordinate that will be edited from the object
		int col_edit = coord.getColumn();//Gets the column coordinate that will be edited from the object 


		//Tests if the imported coordinates from the object does not go
		//out of bounds from the size of the map
		if (row_edit <= rowCnt && col_edit <= colCnt){
			return true;
		}

		else{//Else if the coordinates is out of bounds the program will print out of bounds and stop
			System.out.println("Map is out of bounds!");
			System.exit(0);
			return false;
		}

	}
	//Method gets the position of the coordinates that will be
	//edited else it will return the default character
	 public char getPos(MapCoord coord, char c){
	 	if (isValidPosition(coord) == true){//Tests if the position is valid
	 		return c;
	 	}
	 	else{//If false then it returns the default character
	 		return defaultC;
	 	}
	 }
	 /*Method that sets the returned character from the 
	 getPos method in the coordinates in the array

	 This method also tests if the coordinate has
	 already changed from the default character*/
	 public boolean setPos(MapCoord coord, char c){
	 	//gets the character from the array to test if it is still
	 	//in the default character
		char h = char_arr[coord.getRow()][coord.getColumn()]; 

		//tests if the position is valid and if the coordinate
		//is in the default character
 		if (isValidPosition(coord) == true && h == defaultC){
 			//If position is valid then it appends the returned
 			//character from the getPos method
 			char_arr[coord.getRow()][coord.getColumn()] = getPos(coord, c);
 			return true;//Returns true for a successful append
 		}
 		else {
 			//If the position is already taken by other characters then
 			//the method does not append the input character
 			System.out.println("Position taken character not changed!");
 			return false;//Returns false for a unsuccessful append
 		}
	 }

	 //Method that sets the map as a single String for printing 
	 public String toString(){
	 	System.out.println();
	 	String ret_str = "";//Initiates the string 

	 	//Loops the array to store every character in each column
	 	//in oneline and adds a new line for the next row 
	 	for (int i = 0; i < rowCnt; i++){//Loop for every row of the map
	 		for(int j = 0; j < colCnt; j++){//Loop for every column of the map
	 			//Gets the character of every cooridnate in the array
	 			char cc = char_arr[i][j];
	 			//Converts every character to a string type 
	 			String str = Character.toString(cc);
	 			ret_str += str;//Adds the converted character to the whole string 
	 		}
	 		//Adds the new line in the string for the next loop of row
	 		ret_str += "\n";
	 	}
	 	return ret_str;//Retruns the map string 
	}
}