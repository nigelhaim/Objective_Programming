package FinalAcademicProject;

import java.time.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
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

	public person(String name, LocalDate birthday, int age){
		this.name = name;
		this.birthday = birthday; 
		this.age = age; 
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

	public String getFormattedBday(){
		LocalDate rawBirthday = getBday();
		DateTimeFormatter dateSlashFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dateSlashFormat.format(rawBirthday);
	}

	public String program_printer(){
		return getName() + "              " + getFormattedBday() + "            " + getAge();
	}

	public void upload_data() throws IOException{
		database  = new File("database.txt");

		PrintWriter print = new PrintWriter(new FileWriter(database, true));

		String data = getName() + "," + getBday() + "," + getAge();
		print.println(data);
		print.close();
		return;
	}
}