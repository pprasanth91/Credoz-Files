package com.day08;

public class Exceptions_Handling {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {10,20,30,40,50};
		try {
			System.out.println(a.length);
		for(int i=0;i<a.length;i++) {
			
			System.out.println(a[i]);
		}
		//System.exit(0);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}catch(ArithmeticException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("Rest of the code");
		}
		
		
		
	
	

}
}

