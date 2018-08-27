package selenium.com.day4;

import java.lang.*;
import java.io.*;
import java.util.*;

public class reverse_string {
	// Java program to Reverse a String  by
	// converting string to characters  one
	// by one
	//StringBuilder
	
	    public static void main(String[] args)
	    {
	        String input = "GeeksForGeeks";
	 
	        // convert String to character array
	        // by using toCharArray
	        char[] set = input.toCharArray();
	 
	        for (int i = set.length-1; i>=0; i--)
	            System.out.print(set[i]);
	    }
	}
