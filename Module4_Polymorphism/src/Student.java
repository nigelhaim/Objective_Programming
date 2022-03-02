public class Student{
	//Initiates the variables 
	private String name;
	private String course;
	private Float tuitionFee;
	private static int counter; 
	private int studentNumber;

	//Method that if Student has no values 
	public Student()
	{}

	//Method that sets the values to each student details 
	public Student(String name, String course, float tuitionFee){
		this.name = name;
		this.course = course; 
		this.tuitionFee = tuitionFee;
		counter++;//Increments 1 to tell that 1 student per student
		this.studentNumber = counter;
	}

	public String getName(){//Returns the name of the student 
		return name;
	}

	public String getCourse(){//Returns the course of the student 
		return course;
	}

	public float getTuitionFee(){//Returns the tuitionFee of the student 
		return tuitionFee;
	}

	public int getStudentNumber(){
		return studentNumber;//returns to the student number 
	}

	public String toString(){//Returns the string to the TestStudent.java
		return  "\n" + "Student # " + getStudentNumber() + " : " + getName() + " is taking up " + getCourse() + " with a tuition fee of " + getTuitionFee();
	}
}
