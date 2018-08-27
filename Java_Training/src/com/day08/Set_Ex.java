package com.day08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Set_Ex {


		public static void main(String[] args) {
			Set<String> oSet = new HashSet<>();
			oSet.add("Mathan");
			oSet.add("Karthick");
			oSet.add("Vijay");
			oSet.add("Jone");
			oSet.add("Gopi");
			oSet.add("Mathan");
			oSet.add(null);
			System.out.println("Size of an Array List is : "+oSet.size());
			System.out.println("Collection Value : "+oSet);
			oSet.add("Varsha");
			oSet.add("arthi");
			oSet.add("Deepa");
			System.out.println("Size of an Array List is : "+oSet.size());
			System.out.println("Collection Value : "+oSet);
			List<String> oList1 = new ArrayList<>();
			oList1.add("Baskar");
			oList1.add("Sathish");
			oList1.add("Mathan");
			oSet.addAll(oList1);
			System.out.println("Size of an Array List is : "+oSet.size());
			System.out.println("Collection Value : "+oSet);
			System.out.println("=======For Each=======");
			for(String s:oSet) {
				System.out.println(s);
			}
			Set<String> oLinkSet = new LinkedHashSet<>();
			oLinkSet.add("Mathan");
			oLinkSet.add("Karthick");
			oLinkSet.add("Vijay");
			oLinkSet.add("Jone");
			oLinkSet.add("Gopi");
			oLinkSet.add("Mathan");
			oLinkSet.add(null);
			System.out.println("Size of an Array List is : "+oLinkSet.size());
			System.out.println("Collection Value : "+oLinkSet);
			
			Set<String> oTreeSet = new TreeSet<>();
			oTreeSet.add("Mathan");
			oTreeSet.add("Karthick");
			oTreeSet.add("Vijay");
			oTreeSet.add("Jone");
			oTreeSet.add("Gopi");
			oTreeSet.add("Mathan");
			//oTreeSet.add(null);//nullpointer Exception
			System.out.println("Size of an Array List is : "+oTreeSet.size());
			System.out.println("Collection Value : "+oTreeSet);
			
		}

	}










