package com.jaga;

import java.util.ArrayList;
import java.util.List;

public class B {
	public static void main(String[] args) {
		List<String> a = new ArrayList<>();
		a.add("abc");
		a.add("bcd");
		
		List<String> b = new ArrayList<>();
		b.add("xyz");
		b.add("pqr");
		
		a.addAll(b);
		
		List<String> c = new ArrayList<>();
		c.add("efg");
		c.add("rst");
		
		a.addAll(c);
		
		System.out.println(a);
	}
}
