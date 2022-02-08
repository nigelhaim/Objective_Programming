import java.util.*; 

public class Stringoutputs
{
    static Scanner str_in = new Scanner(System.in);
    public static void main(String[] args) 
    {
        System.out.print("Input Strings: \n\n");
        String input = str_in.nextLine();
        System.out.println();
        String stringarr[] = makearray(input);
        printer(stringarr);
        System.out.println();
    }

    public static String[] makearray(String str)
    {
        String[] words = str.split(" ");
        return words;
    }

    public static int numchar(String a)
    {
        int String_lenght = a.length();
        return String_lenght;
    }

    public static String last_character(String m)
    {
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
            String w = words[c];
            int num = numchar(w);
            String last_char = last_character(w);
            System.out.println("Args[" + c + "] = " + w + " = " + num + " = " + last_char + "\n");
        }
    }


}

