import java.util.Objects;
public class Student{
	//Initiates private variables name, id, and course 
	private String name;
	private int id;
	private String course;

	public Student(){}
	
	//Sets the Student name, id, and course 
	public Student(String name, int id, String course){
		this.name = name;
		this.id = id;
		this.course = course;
	}

	public String getName(){//Gets the name 
		return name;
	}

	public int getId(){//Gets the id 
		return id;
	}
	public String getCourse(){//Gets the course 
		return course;
	}

	//Override toString method 
	public String toString(){//Returns the string compiled of student details(name, id, course)
		return "Name: " + getName() + " | Id number: " + getId() + " | Course: " + getCourse();
	}

	//A method that compares both objects if they are the same 
	public boolean equals(Object obj){
		boolean result = false;//initialize the result to false  

		/*If statement that if method has no missing object and 
		if that object the same instance object which is student*/
		if(obj != null && obj instanceof Student)
		{
			Student s_2 = (Student) obj;//Sets the object variable student to s_2
			/* Compares if the name, id, and course equal to both objects */
			if(this.getName().equals(s_2.getName()) && 
				this.getId() == s_2.getId() && 
				this.getCourse().equals(s_2.getCourse()))
				{
					result = true;
				}
		}
		return result;//Returns the result 
	}

	public int hashCode(){//converts the internal address of the student into an integer 
		return (getName().hashCode() + getCourse().hashCode()) ^ getId();
	}
}