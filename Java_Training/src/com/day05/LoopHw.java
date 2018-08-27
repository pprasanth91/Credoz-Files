package com.day05;

public class LoopHw {

	public static void main(String[] args) {
		
		System.out.println("L star pattern");
			int a[] = {1,2,3,4,5};
		//int n=5;
		System.out.println(a[0]);
		
		for(int i=0;i<a.length;i++) {
			//System.out.println(a[i]);
			for(int j=0;j<a[i];j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println("L star pattern length assigned");
		
		int i, j;
		 int n=5;
            for(i=0; i<=n; i++)
       {

             for(j=0; j<=i; j++)
           {
                 System.out.print("* ");
           }

           System.out.println();
       }
             
             System.out.println("num pattern length assigned");
            
                 for(i=0; i<n; i++)
            {
                	 int num =1;
                  for(j=0; j<=i; j++)
                {
                      System.out.print(num+" ");
                      num++;
                }
                       
                System.out.println();
            } 
                 System.out.println("180 degree pattern length assigned");
                 	int k =2*n-2;
                 for(i=0; i<n; i++)
                 {
                     	 for (j=0;j<k;j++)
                     	 {
                     		 
                     		  System.out.print(" ");
                     	 }
                     	 k = k-2;
                       for(j=0; j<=i; j++)
                     {
                           System.out.print("* ");
                          
                     }
                            
                     System.out.println();
                 } 
                 System.out.println("Triangle  pattern length assigned");
              k=0;
              k=2*n-2;
              for(i=0; i<n; i++)
              {
                  	 for (j=0;j<k;j++)
                  	 {
                  		 
                  		  System.out.print(" ");
                  	 }
                  	 k = k-1;
                    for(j=0; j<=i; j++)
                  {
                        System.out.print("* ");
                       
                  }
                         
                  System.out.println();
              } 
	}
	
	
}
	
		
	
