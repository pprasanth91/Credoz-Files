package Practice;

import java.util.Scanner;

public class Reverse_Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the Number");
		
		Scanner oscan = new Scanner(System.in);
		
		int Number = oscan.nextInt();
		
		for (int i=Number ; i>0; i--){
					
			for (int j=0 ; j<i ; j++){
				
				System.out.print("*");
			}
			
			System.out.println();
		}
			
	}

}
