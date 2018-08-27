package com.day05;

public class Array_Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[][] = {{10,20,30},{40,50},{70,80,90}};
		
		System.out.println(a[1][0]);
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i].length);
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j]+"  ");
			}
			System.out.println();
		}
	
		
}
}







