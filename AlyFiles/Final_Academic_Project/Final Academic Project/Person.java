import java.text.*;
import java.util.*;

public class Person
{
	private String name;
	private Date birthDay;
	private int age;
	
	public Person(String name, Date birthDay, int age)
	{
		this.name = name;
		this.birthDay = birthDay;
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Date getBirthDay()
	{
		return birthDay;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String dateFormat()
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormatter.format(getBirthDay());
	}
	
	public String toString()
	{
		return "\t" + getName() + "\t\t" + dateFormat() + "\t\t" + getAge() + "\t";
	}
}