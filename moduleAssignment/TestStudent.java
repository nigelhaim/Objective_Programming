// Module 2 Assignment
public class TestStudent
{
	public static void main(String args[])
	{
		Student s1 = new Student("Lawrence", 1111, "BS Computer Science");
		Student s2 = new Student();
		Student s3 = new Student();

		// set the properties of Student s2, assign a name, studentNumber and course
		s2.setName("Nigel");
		s2.setStudentnumber(2021164107);
		s2.setCourse("Computer Science");
		// set the properties of Student s3, assign a name, studentNumber and course
		s3.setName("Kiyoshi");
		s3.setStudentnumber(-2021164107); // This a test if the input is a negative number
		s3.setCourse("Reversed Computer Science");

		// print the identity of Student s1
		s1.showStudentInformation();

		// print the identity of Student s2 by calling the getter methods
		s2.showStudentInformation();
		// print the identity of Student s3 by calling the showStudentInformation() method
		s3.showStudentInformation();
	}
}

