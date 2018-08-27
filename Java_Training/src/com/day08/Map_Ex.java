	package com.day08;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.Map;
	import java.util.Set;
	
public class Map_Ex {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> oMap = new HashMap<>();
		oMap.put(100, "Selenium");
		oMap.put(101, "Selenium");
		oMap.put(102, "Java");
		oMap.put(103, null);
		oMap.put(104, null);
		oMap.put(null, "QTP");
		oMap.put(null, "Selenium");
		System.out.println(oMap);
		System.out.println(oMap.get(100));
		System.out.println("Contains Method : "+oMap.containsKey("107"));
		Set<Integer> oKey = oMap.keySet();
		for(Integer i : oKey) {
			System.out.println(i+" == "+oMap.get(i));
		}

	}

}










