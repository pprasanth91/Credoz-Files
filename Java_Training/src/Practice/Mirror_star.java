package Practice;

import java.util.Scanner;

public class Mirror_star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the Number");
		
		Scanner oscan = new Scanner (System.in);
		
		int Number = oscan.nextInt();
		
		int Space=0;
		
		for (int i=1 ; i<=Number ; i++ ){
			
				Space = Number-i;
			
			//Spaces
			for (int j=0 ; j<Space ;j++ ){
				
				System.out.print(" ");
							
			}
			
			for (int k=0 ; k<i ; k++ ){
				
				System.out.print("*");
			}
			
			System.out.println();
				
		}
		
	}

}
