package Practice;

public class string_compare {

	String s1 = "STRING";
	String s2 = "STRONG";
	int i;

	
	public void character()
	{
		
		System.out.println("Length Of String1 : "+s1.length());
		
		String sSplit1[] = s1.split("");
		
	System.out.println("Length Of String2 : "+s2.length());
		
		String sSplit2[] = s2.split("");
		
			for(i=0;i<sSplit1.length;i++)
			
		{
				System.out.println("Split String1 : "+sSplit1[i]);	
					
								
				System.out.println("Split String2 : "+sSplit2[i]);
				
				
		if (sSplit1[i].equals(sSplit2[i]))
		{
						
			System.out.println("Both character are equal : "+sSplit1[i]);
		
			
		}
		else {
			System.out.println("Both character are not equal  ");
			
		}
		}
		
		}
			
	
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		string_compare oString = new string_compare();
		oString.character();
		
	}
}




