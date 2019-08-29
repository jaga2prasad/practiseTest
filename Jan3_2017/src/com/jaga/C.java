package com.jaga;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
public class C {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("123abc", "bbbb");
		map.put("321cba", "prasad");
		map.put("456", "jp");
		
		if(map.containsKey("123abc")){
		  String value = map.get("123abc");
		  System.out.println(value);
		}
		
		List<String> a = new CopyOnWriteArrayList();
		
		a.add("jaga");
		a.add("prasad");
		
		a.add("jjj");
		
		for(String b : a) {
			if(b.equals("jaga")) {
				continue;
			}
			System.out.println(b);
		}
		
				
	}
}
