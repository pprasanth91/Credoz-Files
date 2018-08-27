package Practice;

public class String_Mutabletry {

	public static void concat1(String s1)
    {
    	 //s1 = "Geeks";
        s1= "check";
        //s1 = s1 + "forgeeks";
        System.out.println("String: " + s1);
    }
	public static void concat2(String s1)
    {
    	 s1 = "Geeks";
        //s1= "check";
        //s1 = s1 + "forgeeks";
        System.out.println("String: " + s1);
    }
	
	public static void main(String[] args)
    {
        String s1 = "Geeks";
        
        concat1(s1);  // s1 is not changed
        concat2(s1);
        System.out.println("String: " + s1);
}
}