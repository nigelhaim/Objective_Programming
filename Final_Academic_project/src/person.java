 import java.time.*;
 import java.io.*;
public class person{

	private File database;

	private String name;
	private LocalDate birthday;
	private int age;

	public person(String name, LocalDate birthday){
		this.name = name;
		this.birthday = birthday; 
		age = setAge(birthday); 
	}

	public int setAge(LocalDate birthday){
		LocalDate today = LocalDate.now();
		LocalDate birthDate = birthday;
		int age = Period.between(birthDate, today).getYears();
		return age;
	}

	public int getAge(){
		return age;
	}
	public String getName(){
		return name;
	}

	public LocalDate getBday(){
		return birthday;
	}

	public String getString(){
		return "Name: " + getName() + "\nBirthday: " + getBday() + "\nAge: " + getAge();
	}

	public void upload_data() throws IOException{
		database  = new File("database.txt");

		PrintWriter print = new PrintWriter(new FileWriter(database, true));

		String data = getName() + "|" + getBday() + "|" + getAge();
		print.println(data);
		print.close();
		return;
	}
}