package com.day05;

public class Array_Hw 
{

	public static void main(String[] args) 
	{
		System.out.println("======Even and Odd Number========");
		int a[] = {6,1,10,7,8,5,9,3,2,1};
		System.out.println("a length is"+a.length);
	   for (int i=0;i<a.length;i++)
		{
			if (a[i]%2 ==0)
			{
				System.out.println("The given number is even num:"+a[i]);
			}
			else
			{
				System.out.println("The given number is odd num:"+a[i]);
			}
		}
	   		
		System.out.println("======Prime and Non Prime Number========");
		int flag=0;
		for(int i=0;i<a.length;i++)
		{
		for(int j=2; j<=a[i]/2; j++)
	    {
	        // condition for nonprime number
	        if(a[i]%j==0)
	        {
	            flag=1;
	            break;
	        }
	    }

	    if (flag==0)
	    {
	    	System.out.println("The given number is a prime number:"+a[i]);
	    }
	    else
	    {
	    	System.out.println("The given number is a not prime number:"+a[i]);
	    
	    }
		}
		System.out.println("======Smallest and Largest Number========");
		int max=a[0];
		int min=a[0];
		for(int i=1;i<a.length;i++)
		{
				if(a[i]>max) {
					max=a[i];
				}
				else if (a[i]<min)
				{
					min=a[i];
				}
				
		}
		System.out.println("The given number is the largest number of all:"+max);
		System.out.println("The given number is the smallest number of all:"+min);
		
		System.out.println("======Ascending and Descinding order of Number========");
		
}
	
}
