import java.util.HashMap;
import java.util.Scanner;
import java.io.*;	
public class login{
	public static void main(String[] args)throws IOException
	{

		Scanner in = new Scanner(System.in);

		File userList = new File(args[0]);

		BufferedReader read = new BufferedReader(new FileReader(userList));
		String s;
				//Key   Value
 		HashMap<String, String> users = new HashMap<String, String>();

 		int user = 1;
 		int pass = 2; 
 		while((s = read.readLine()) != null){		
 			String username = s;
 			s = read.readLine();
			String password = s;

			users.put(username, password);
 		}

 		System.out.print("Enter username: ");
 		String username_input = in.nextLine();
 		if(!users.containsKey(username_input)){
 			System.out.println("Username does not exist!");
 			System.exit(0);
 		}
 		System.out.print("Enter password: ");
 		String password_input = in.nextLine();

 		if(users.containsKey(username_input)){
 			String password_user = users.get(username_input);
 			if(password_user.equals(password_input)){
 				System.out.println("Access Granted!");
 			}
 			else{
 				System.out.println("Access Denied!");
 			}
 		}
 		in.close();
	}
}