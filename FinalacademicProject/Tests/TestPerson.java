import java.time.*;
import java.time.*;
public class TestPerson{
	public static void main(String[] args) {
		LocalDate birthday = LocalDate.of(2003, 03, 21);
		person persons[]  = 
		{
			new person("Nigel", birthday),
		};

		for(int i = 0; i < persons.length; i++){
			person data = persons[i];

			System.out.println(data.getName() + " || " + data.getAge() + " || " + data.getBday());
		}
	}
}