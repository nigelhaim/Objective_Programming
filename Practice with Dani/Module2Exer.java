/*
 * Module 2 Assignment / Exercise
 * Sophia Danielle F. Durana - 1CSA
 * February 8, 2022 :>
 */

import java.util.*;
public class Module2Exer
{
	static Scanner in = new Scanner(System.in);
	public static void main(String args[])
	{
		int stringValuesInput, i, stringLength;
		/* stringValuesInput is for storing user-inputed
		 * values of how many Strings they desire.
		 * i is for loop counter.
		 * stringLength is for determining and
		 * storing the length of the string input. */
		/* userStringInput for storing user inputs per line
		 * characterType stores the String result of lastChar. */
		char lastChar = ' '; //initialized empty char
		// for storing last character of userStringInput

		programDescriptionIntro();
		stringValuesInput = in.nextInt();
		String[] array =  new String[stringValuesInput];
		System.out.println("Enter your String inputs ["
							+ stringValuesInput + "] times: ");

        

		// args[] = new String[stringValuesInput];
		// Empty String with the size of stringValuesInput							
		in.nextLine();
		for (i = 0; i < array.length; i++)
		{
			System.out.print("[" + i + "] : ");
			String userStringInput = in.nextLine();
			array[i] = userStringInput;

		}

		// printing final output
		showFinalOutput(array);
	}
	
	// Methods Used here
	public static char autoLastChar(String userStringInput)
	{
		// automatically format lastChar
		String lastCharr = userStringInput.toLowerCase();
		int len = lastCharr.length();
		char character = lastCharr.charAt(len-1);

		return character;
	}
	
	public static String charTest(String userStringInput)
	{
		char lastChar = autoLastChar(userStringInput);
			//Solving characterType here:
		String characterType = "";
		if (lastChar >= 'a' && lastChar <= 'z')
			if (lastChar == 'a' || lastChar == 'e' || lastChar == 'i' || lastChar == 'o' || lastChar == 'u')
				characterType = "vowel";
			else //Consonant characters
				characterType = "consonant";
		
		else if (lastChar >= '0' && lastChar <= '9') // number characters
			characterType = "number";
			// vowel characters
		else
			characterType = "symbol";

		return characterType;
	}

	public static void programDescriptionIntro()
	{
		// this method should print instructions for the user.
		System.out.println("This program will ask the user to input any type"
							+ "\nof String. The output will contain the args[i] value"
							+ "\nthe length of the inputted String, the actual String"
							+ "\nand the type of character of the last character of"
							+ "\nthe inputted String."
							+ "\n\nHow many String values would you like to enter?");
	}

	public static void showFinalOutput(String[] array)
	{
		/* this method should display the 
		 * array args[], the inputted String,
		 * the length of the inputted String,
		 * and the type of character
		 */
		
		for (int i = 0; i < array.length; i++) //i = counter
		{
			String userStringInput = array[i];
			int stringLength = userStringInput.length();
			String characterType = charTest(userStringInput);
			System.out.println("\nargs[" + i + "] = "
							+ userStringInput + " = "
							+ stringLength + " = "
							+ characterType);
		}
	}
}