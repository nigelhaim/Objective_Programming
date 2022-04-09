import java.io.*;

public class fileReader
{
	public static void main(String args[]) throws IOException
	{
		//int ctr = 0;
		File userList = new File(args[0]);

		BufferedReader read = new BufferedReader(new FileReader(userList));
		String s; 

		/*while((s = read.readLine()) != null){
			System.out.println(++ctr + ": " + s);
		}*/
		File user_list = new File("usernames.txt");
		File pass_list = new File("passwords.txt");
		PrintWriter user = new PrintWriter(new FileWriter(user_list));
		PrintWriter pass = new PrintWriter(new FileWriter(pass_list));

		for(int i = 1; (s = read.readLine()) != null; ++i){
			boolean even = check_odd_even(i);
			if(even){
				pass.println(s);
			}
			else{
				user.println(s);
			}
		}

		read.close();
		user.close();
		pass.close();
	}

	public static boolean check_odd_even(int num){
		boolean even = false;
		if(num % 2 == 1){
			even = false;
		}
		else if(num % 2 == 0){
			even = true;
		}

		return even;
	}
}