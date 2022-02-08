public class Arraycopy{
	public static void main(String args[])
	{
		int src[] = {10, 20, 30, 40, 50};
		int temp[] = new int[7];
		System.out.println("Original Array (src): ");
		for (int num : src)
		{
			System.out.print(num + "\t");
		}

		System.out.println();
				       //src --copy to --> temp
		System.arraycopy(src, 0, temp, 0, src.length); //temp = 10 20 30 40 50 700 800
		src = temp; 
		temp = null;

		System.out.println("After Arraycopy(): ");
		for (int num : src)
		{
			System.out.print(num + "\t");
		}
		System.out.println();
	}
}