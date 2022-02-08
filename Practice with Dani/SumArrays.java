public class SumArrays 
{
	public static void main(String args[])
	{
		int quiz[] = {100, 80, 90, 75, 85, 95};
		int length = quiz.length;
		double total = 0; 

		System.out.println();
		for (int q : quiz)
		{
			System.out.println(q);
			total += q;
		}
		System.out.println();
		System.out.println("The total of the quizes is: " + total);
		System.out.println("The average of the quizes is: " + (total/(length)));
	}
}