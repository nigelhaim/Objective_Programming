public class MapCoord{
	//Initiates the private variables 
	private int row;
	private int column;

	//Gets and sets the value of private variables named row and column
	public MapCoord(int r, int c)
	{
		this.row = r;
		this.column = c;
	}

	//Gets the value of private row and returns 
	//to the line that calls the method
	public int getRow(){
		return row;
	}	
	//Gets the value of private column and returns 
	//to the line that calls the method
	public int getColumn(){
		return column;
	}

	//Returns a string of row and column for testing 
	public String toString(){
		String str = "(" + row + "," + column + ")";
		return str;
	}
}