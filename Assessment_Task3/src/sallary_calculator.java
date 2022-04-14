import java.io.*;
import java.util.LinkedList;
public class sallary_calculator{
	public static void main(String[] args) throws IOException
	{ 
		File sallary = new File(args[0]);

		BufferedReader read = new BufferedReader(new FileReader(sallary));
		int lineCount = 0;
		String s;
		System.out.println("\nTest Input: \n");
		while((s = read.readLine()) != null){
			String[] arr_hours_string = s.split(", ", 7);
			LinkedList<Integer> int_hours = new LinkedList<>();
			//This looop is to test if the split is correct in the string
			/*for(String a : arr_hours_string){
				System.out.println(a);
			}*/
			int num_hour = 0;
			for(String a : arr_hours_string){//Stores the string number of hours into integer array
				int_hours.add(Integer.parseInt(a));
			}
			try{
				for(int r = 0; r < int_hours.size(); r++){
					for(int t = 0; t < 7; t++){
						if(int_hours.get(t) < 0){
						throw new Exception(Integer.toString(int_hours.get(t))  + " hours in line: " + (lineCount + 1));
						}
					}
				}
			}
			
			catch(Exception e){
				System.out.println("Invalid hours!\nCause of error: " + e.getMessage());
				System.exit(0);
			}
			/*System.out.println("Linked list: " + int_hours );
			System.out.println();*/
			//System.out.println("Line #" + ++lineCount + ": " + s);
			++lineCount;
		}
	}
}