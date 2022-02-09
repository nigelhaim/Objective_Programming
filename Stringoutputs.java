import java.util.*; 

public class Stringoutputs
{
    public static void main(String[] args) 
    {
        System.out.println();
        printer(args);
        System.out.println();
    }


    public static int numchar(String a)
    {
        //Returns the length of the array
        int String_lenght = a.length();
        return String_lenght;
    }

    public static String last_character(String m)
    {
        //Checks the last character if it is a vowel/consonant/number/Symbol 
        String s = m.toUpperCase();
        int len = numchar(s);
        char ch = s.charAt(len-1);
        String result = "";

        if (ch >= 65 && ch <= 90)
            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
                result = "Vowel";
            else
                result = "Consonant";

        else if (ch >= 48 && ch <= 57)
            result = "Number";
        else
            result = "Symbol";
        return result;

    }
    public static void printer(String[] words)
    {
        for(int c = 0; c < words.length; c++)
        {
            //Prints the result of the program 
            String w = words[c];
            int num = numchar(w);
            String last_char = last_character(w);
            System.out.println("Args[" + c + "] = " + w + " = " + num + " = " + last_char + "\n");
        }
    }


}

