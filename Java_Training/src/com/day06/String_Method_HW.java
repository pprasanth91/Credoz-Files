package com.day06;

public class String_Method_HW {
	String s1 = "SriKamatchi";
	int i;
	int j =0;
	
	public void character()
	{
		System.out.println("Lower Case Method : "+s1.toLowerCase());
		s1=s1.toLowerCase();
		System.out.println("Length Of String : "+s1.length());
		
		String sSplit[] = s1.split("");
		
			for(i=0;i<sSplit.length;i++)
		{
			System.out.println("Split String : "+sSplit[i]);
			
				
		if (sSplit[i].equals("a")||sSplit[i].equals("e")||sSplit[i].equals("i")||sSplit[i].equals("o")||sSplit[i].equals("u"))
		{
						
			System.out.println("Compare string a present : "+sSplit[i]);
			j =j+1;
			
		}
		else {
			System.out.println("Compare string a not present : "+sSplit[i]);
		}
		
		}
			System.out.println("Length of a:"+j);	
	}

	
	public void replace() {
		String sSplit[] = s1.split("");
		
		for(i=0;i<sSplit.length;i++)
	{
			
			
	if (sSplit[i].equals("a"))
	{
		System.out.print(""+sSplit[i].replace('a', 'A'));			
				
	}
	else {
		System.out.print(""+sSplit[i]);
	}
		}
		System.out.println();
		}
	
	public void trim() {
		String sSplit[] = s1.split("");
		
		
			System.out.println("Sub String : "+s1.substring(0,sSplit.length-1));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String_Method_HW oString = new String_Method_HW();
		oString.character();
		oString.replace();
		oString.trim();
				
	}

}
