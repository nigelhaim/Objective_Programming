public class MapCoord{
	private int row;
	private int column;
	public MapCoord(int r, int c)
	{
		this.row = r;
		this.column = c;
	}
	public int getRow(){
		return row;
	}	

	public int getColumn(){
		return column;
	}
	public String toString(){
		String str = "(" + row + "," + column + ")";
		return str;
	}
}