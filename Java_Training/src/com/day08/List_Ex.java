package com.day08;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class List_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> oList = new ArrayList<>();
		oList.add("Mathan");
		oList.add("Karthick");
		oList.add("Vijay");
		oList.add("Jone");
		oList.add("Gopi");
		oList.add("Mathan");
		System.out.println("Size of an Array List is : "+oList.size());
		System.out.println("Collection Value : "+oList);
		oList.add(2, "Senthil");
		System.out.println("Collection Value After Adding new Value using Index : "+oList);
		System.out.println("Size of an Array List is : "+oList.size());
		List<String> oList1 = new ArrayList<>();
		oList1.add("Baskar");
		oList1.add("Sathish");
		oList1.add("Mathan");
		oList.addAll(oList1);
		System.out.println("Collection Value After Adding new List : "+oList);
		
		System.out.println("To Get Value Based on Index : "+oList.get(2));
		System.out.println("Size of an Array List is : "+oList.size());
		System.out.println("Contains Method : "+oList.contains("Vijay"));
		oList.add(null);
		oList.add(null);
		System.out.println("Collection Value After Adding Null Value: "+oList);
		System.out.println("Size of an Array List is : "+oList.size());
		System.out.println("========For Loop===========");
		for(int i=0;i<oList.size();i++) {
			System.out.println(oList.get(i));
		}
		System.out.println("========For Each Loop===========");
		for(String s:oList) {
			System.out.println(s);
		}
		System.out.println("==========Iterator==========");
		Iterator<String> oIT = oList.iterator();
		while(oIT.hasNext()) {
			System.out.println(oIT.next());
		}
		System.out.println("==========While Loop==========");
		int i=0;
		while(i<oList.size()) {
			System.out.println(oList.get(i));
			i++;
		}
		List<Integer> oLink = new LinkedList<>();
		
		oLink.add(500);
		oLink.add(100);
		oLink.add(50);
		oLink.add(500);
		oLink.add(50);
		oLink.add(null);
		oLink.add(null);
		System.out.println(oLink);
		
	//Remove duplicate values from list dropdown
		
	Set<Integer> hash_Set = new HashSet<Integer>(oLink);
   
    System.out.print("Set output without the duplicates");

    System.out.println(hash_Set);
    oLink.clear();
    oLink.addAll(hash_Set);
    System.out.println("Set output without the duplicates of list");
    System.out.println(oLink);
}

}





