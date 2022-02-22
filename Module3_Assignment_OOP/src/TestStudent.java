public class TestStudent{
	public static void main(String[] args) {
		Student s1 = new Student("Nigel", 123456789, "CompSci");
		Student s2 = new Student("Nigel", 123456789, "CompSci");


		System.out.println("\nThis represents the result of .toString() method: \n");
		System.out.println(s1.toString());
		System.out.println(s2.toString());

		System.out.println("\nThis represents the result of .equals() method:");
		System.out.println(s1.equals(s2));

		System.out.println("\nThis represents the result of .hashcode() method:");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}	
}