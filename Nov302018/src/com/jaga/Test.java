package com.jaga;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		String s = String.format(",Site Location:"+"modified from jaga123 to jaga1");
		
		//System.out.print(s);
		
		
		String value = "jaga";
		
		List<String> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add(value+" "+i);
		}
		
		for(String v : list) {
			System.out.println(v);
		}
		
	}
}
