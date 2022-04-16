import java.io.*;
import java.util.LinkedList;
public class sallary_calculator{
	public static void main(String[] args) throws IOException
	{ 
		File time_card = new File(args[0]);

		BufferedReader read = new BufferedReader(new FileReader(time_card));
		int lineCount = 0;
		String s;
		//System.out.println("\nTest Input: \n");
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
				num_hour++;
			}
			try{
				for(int r = 0; r < int_hours.size(); r++){
					for(int t = 0; t < 7; t++){
						if(int_hours.get(t) < 0 || int_hours.get(t) > 24){
						throw new Exception(Integer.toString(int_hours.get(t))  + " hours in line: " + (lineCount + 1));
						}
						else if(num_hour < 7){
							throw new Exception("Invalid number of hours of the week in line: " + (lineCount + 1));
						}
					}
				}
			}
			
			catch(Exception e){
				System.out.println("Invalid data!\nCause of error: " + e.getMessage());
				System.exit(0);
			}
			/*This is to test if the input values are valid or not*/
			//System.out.println("Linked list: " + int_hours );
			System.out.println();
			System.out.println("Line #" + ++lineCount + ": " + s);
			
			double sallary = 0;
			int hour_per_week = 0; 
			System.out.print("Output #" + lineCount + ": ");
			
			for(int hour_reader = 0; hour_reader < int_hours.size(); hour_reader++){
				int hour = int_hours.get(hour_reader);
				hour_per_week += hour;
				sallary += hour_sallary(hour);
			}
			if(hour_per_week > 40){
				sallary += add_sallary((hour_per_week - 40), 2.50);
			}

			sallary += weekend_sallary_bonus(int_hours.get(0), int_hours.get(6));

			System.out.println("$" + sallary + " Number of hours: " + hour_per_week);
		}
	}

	public static double weekend_sallary_bonus(int sun, int sat){
		double sunday_sallary = hour_sallary(sun) * 0.50;
		//sunday_sallary += (sunday_sallary * 0.25) - sunday_sallary;
		double saturday_sallary = hour_sallary(sat) * 1.25;
		//saturday_sallary += (saturday_sallary * 2.25) - saturday_sallary;
		double sat_sun_sallary = sunday_sallary + saturday_sallary;
		return sat_sun_sallary;
	}
	
	public static double hour_sallary(int hours){
		int sallary = 0; 
		if(hours > 8){
			sallary += add_sallary(hours, 10);
			sallary += add_sallary(hours - 8, 1.50);
		}	
		else{
			sallary += add_sallary(hours, 10);
		}
		return sallary;
	}

	public static double add_sallary(int hours, double amount){
		double s = 0;
		for(int i = 0; i < hours; i++){
			s += amount;
		}
		return s;
	}
}