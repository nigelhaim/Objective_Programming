import java.util.Objects;
public class Student{
	private String name;
	private int id;
	private String course;

	public Student(String name, int id, String course){
		this.name = name;
		this.id = id;
		this.course = course;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
	public String getCourse(){
		return course;
	}

	//Override toString method 

	public String toString(){
		return "Name: " + getName() + " | Id number: " + getId() + " | Course: " + getCourse();
	}

	public boolean equals(Object obj){
		boolean result = false;//initialize the result 

		if(obj != null && obj instanceof Student)
		{
			Student s_2 = (Student) obj;
			if(this.getName().equals(s_2.getName()) && 
				this.getId() == s_2.getId() && 
				this.getCourse().equals(s_2.getCourse()))
				{
					result = true;
				}
		}
		return true;
	}

	public int hashCode(){
		return (getName().hashCode() + getCourse().hashCode()) ^ getId();
	}
}