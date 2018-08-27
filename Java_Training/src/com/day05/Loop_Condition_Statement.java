package com.day05;

public class Loop_Condition_Statement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {10,20,30,40,50};
		/*int []b = {10,20,30,40,50};
		int [] c = {10,20,30,40,50};
		int[]  d= {10,20,30,40,50};
		int e[] = new int[5];
		e[0] =10;
		e[1] =20;*/
		
		System.out.println(a[3]);
		
		for(int i=0;i<5;i++) {
			System.out.println(a[i]);
			if(a[i]==30) {                        
				System.out.println("Value is 30 : "+a[i]);
				break;
			}else {
				System.out.println("Value is not 30 : "+a[i]);
			}
		}
		
		System.out.println("========If-Else If-Else===========");

		for(int i=0;i<5;i++) {
			System.out.println(a[i]);
			if(a[i]==30) {
				System.out.println("Value is 30 : "+a[i]);
				
			}else if (a[i]==40) {
				System.out.println("Value is 40 : "+a[i]);
			}else if (a[i]==50) {
				System.out.println("Value is 50 : "+a[i]);
			}else {
				System.out.println("Value is not 30 : "+a[i]);
			}
		}
		
		System.out.println("========Swich Case===========");
		for(int i=0;i<5;i++) {
			switch (a[i]) {
			case 10:
				System.out.println("Value is 10 : "+a[i]);
				break;
			case 20:
				System.out.println("Value is 20 : "+a[i]);
				break;
			case 30:
				System.out.println("Value is 30 : "+a[i]);
				break;
			case 40:
				System.out.println("Value is 40 : "+a[i]);
				break;

			default:
				System.out.println("Value is 50 : "+a[i]);
				break;
			}
		}
		System.out.println("=======While Loop=======");
		int i=0;
		while(i<5) {
			System.out.println(a[i]);
			i++;
		}
		System.out.println("======Do While Negative========");
		do {
			System.out.println("I value is : "+i);
			System.out.println(a[i]);
			i++;
		} while (i<5);
		

}
}







