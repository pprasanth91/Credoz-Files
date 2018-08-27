package com.day06;

public class String_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Mathan";
		String s2 = "MATHAN";
		String s3 = "Mathan";
		String s4 = "   Mathan Chandrasekaran    ";
		String s5 = "This is Java Session";
		String s6 = "Price is 100";
		String s7 = "Price is : 100 $";
		
		System.out.println("Equal Method : "+s1.equals(s2));
		System.out.println(s1.startsWith("m"));
		System.out.println("Equal Method : "+s1.equals(s3));
		System.out.println("Equal Method Ignore case: "+s1.equalsIgnoreCase(s2));
		System.out.println(s1.concat(s2));
		System.out.println(s1.indexOf(s1));
		System.out.println(s1.contentEquals(s3));
		System.out.println(s1.matches(s3));
		System.out.println(s1.endsWith("n"));
		System.out.println("Equal Operator : "+(s1==s2));
		
		System.out.println("Equal Operator : "+(s1==s3));
		
		System.out.println("Compare Method : "+s1.compareTo(s2));
		System.out.println("Compare Method : "+s1.compareTo(s3));
		System.out.println("Compare Ignore case Method : "+s1.compareToIgnoreCase(s2));
		
		System.out.println("Lower Case Method : "+s2.toLowerCase());
		System.out.println("Lower Case Method : "+s2.toUpperCase());
		
		System.out.println("Length Of String : "+s4.length());
		
		System.out.println("Trim Method : "+s4.trim());
		s4 = s4.trim();
		System.out.println("Length Of String : "+s4.length());
		
		System.out.println("Sub String : "+s1.substring(2));
		System.out.println("Sub String : "+s1.substring(2, 4));
		System.out.println("Sub String : "+s1.substring(0,1));
		System.out.println("Sub String : "+s1.substring(5,6));
		System.out.println("Sub String : "+s1.substring(0,5));
		
		System.out.println("Replace Char : "+s1.replace('a', 'e'));
		System.out.println("Replace Char : "+s1.replaceFirst("a", ""));
		System.out.println("Replace String : "+s5.replace("Java", "Selenium"));
		System.out.println("Replace String : "+s5.replace(" Java", ""));
		System.out.println("Replace with Regx :"+s6.replaceAll("[A-Z a-z]", ""));
		System.out.println("Replace with Regx :"+s6.replaceAll("[0-9]", "").trim());
		System.out.println("Replace with Regx :"+s7.replaceAll("[A-Z a-z : $]", ""));
		System.out.println("Replace with Regx :"+s7.replaceAll("[^0-9]", "").trim());
		s7 = s7.replaceAll("[^0-9]", "").trim();
		int i7 = Integer.parseInt(s7);
		if(i7>0) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		String sDate = "11-03-2018";
		String sSplit[] = sDate.split("-");
		System.out.println(sSplit[1]);
		for(int i=0;i<sSplit.length;i++) {
			System.out.println(sSplit[i]);
		}
		System.out.println("===============");
		String sName[] = s1.split("");
		for(int i=0;i<sName.length;i++) {
			System.out.println(sName[i]);
		}
	}

}
