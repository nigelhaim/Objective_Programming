import java.time.*;
public class person{
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
}