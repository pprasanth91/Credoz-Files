	package Practice;

public class Reverse_String_Append {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S1 =  "level",Rstr;
		StringBuilder Str = new StringBuilder(S1);
		Rstr = Str.reverse().toString();
		System.out.println("Reverse String of S1:" + Rstr);
		if (S1.equals(Rstr))
		{
			System.out.println("The given string is an Palindrome");
		}
		else
		{
			System.out.println("The given string is not an Palindrome");
		}
	}

}

