import java.io.*; 

public class ListSorter{
	public static void main(String[] args) {
		File List = new File(args[0]);
		Reader(List);
	}

	public static void Reader(File r)
	{
		int ctr = 0;
		File userList = new File(r);

		BufferedReader read = new BufferedReader(new FileReader(userList));
		String s; 

		while((s = read.readLine()) != null){
			System.out.println(++ctr + ": " + s);
		}

		read.close();
	}
}