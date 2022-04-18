import java.io.*;
import java.util.LinkedList;
public class TimeCard{
	public static void main(String[] args) throws IOException
	{ 
		File time_card = new File(args[0]);

		BufferedReader read = new BufferedReader(new FileReader(time_card));
		int lineCount = 0;
		String s;
		File sal_per_week = new File("Outputs.txt");
		PrintWriter output = new PrintWriter(new FileWriter(sal_per_week));	
		output.println("Salary per week:");
		//System.out.println("\nTest Input: \n");
		while((s = read.readLine()) != null){
			String[] arr_hours_string = s.split(", ");
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
			try{//Checks if the input hours is a positive integer that is lessthan or equal to 24
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
			
			catch(Exception e){//Prompts the user of the error 
				System.out.println("Invalid data!\nCause of error: " + e.getMessage());
				System.exit(0);
			}
			/*This is to test if the input values are valid or not*/
			//System.out.println("Linked list: " + int_hours );
			System.out.println();
			System.out.println("Line #" + ++lineCount + ": " + s);
			
			double salary = 0;
			int hour_per_week = 0; 
			System.out.print("Output #" + lineCount + ": ");
			
			for(int hour_reader = 0; hour_reader < int_hours.size(); hour_reader++){
				int hour = int_hours.get(hour_reader);
				hour_per_week += hour;
				salary += hour_salary(hour);
			}
			if(hour_per_week > 40){
				salary += add_salary((hour_per_week - 40), 2.50);
			}

			salary += weekend_salary_bonus(int_hours.get(0), int_hours.get(6));
			System.out.print("$");
			System.out.printf("%.2f", salary);
			System.out.println(" | Number of hours: " + hour_per_week);
			
			output.print("Week " + lineCount + ": $");
			output.printf("%.2f", salary);
			output.println();
		}
		read.close();
		output.close();
	}

	public static double weekend_salary_bonus(int sun, int sat){
		double sunday_salary = hour_salary(sun) * 0.50;
		double saturday_salary = hour_salary(sat) * 1.25;
		double sat_sun_bonus = sunday_salary + saturday_salary;
		return sat_sun_bonus;
	}
	
	public static double hour_salary(int hours){
		double salary = 0; 
		if(hours > 8){
			salary += add_salary(hours, 10);
			salary += add_salary(hours - 8, 1.50);
		}	
		else{
			salary += add_salary(hours, 10);
		}
		return salary;
	}

	public static double add_salary(int hours, double amount){
		double s = 0;
		for(int i = 0; i < hours; i++){
			s += amount;
		}
		return s;
	}
}