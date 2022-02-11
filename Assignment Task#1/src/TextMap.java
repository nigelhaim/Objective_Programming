public class TextMap{
	private int rowCnt;
	private int colCnt;
	private char defaultC;
	private	char char_arr[][];

	public TextMap(int rowCnt, int colCnt, char defaultChar){
		//Gets the data from the MapEditor
		this.rowCnt = getRowCnt(rowCnt);
		this.colCnt = getColumnCnt(colCnt);
		this.defaultC = defaultChar;
		this.char_arr = new char[rowCnt][colCnt];

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
	//Dont mind me 
	public boolean isValidPosition(MapCoord coord){

		//Need to separate the MapCoord's two integers (row and column)
		int row_edit = coord.getRow();
		int col_edit = coord.getColumn();

		if (row_edit <= rowCnt && col_edit <= colCnt){
			return true;
		}

		else{
			return false;
		}

	}
	//Taga set ng symbol kung defult or papalitan 
	 public char getPos(MapCoord coord){
	 	if (isValidPosition(coord) == true){
	 		return char_arr[coord.getRow()][coord.getColumn()];
	 	}
	 	else{
	 		return defaultC;
	 	}
	 }
	 //Taga append
	 public boolean setPos(MapCoord coord, char c){
	
	 		if (isValidPosition(coord) == true){
	 			char_arr[coord.getRow()][coord.getColumn()] = c;
	 			return true;
	 		}
	 		else {
	 			return false;
	 		}
	 	}
	 public String toString(){
	 	String ret_str = "";
	 	for (int i = 0; i < rowCnt; i++){
	 		for(int j = 0; j < colCnt; j++){
	 			char cc = char_arr[i][j];
	 			String str = Character.toString(cc);
	 			ret_str += str;
	 		}
	 		ret_str += "\n";
	 	}
	 	return ret_str;
	}
}