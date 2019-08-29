package com.jaga;

public class B {
	public static void main(String[] args) {
		String a = "jaga";
		String b = "prasad";
		
		a = a+b;
		b=a.substring(0, a.length()-b.length());
		a=a.substring(b.length(),a.length());
		
		System.out.println(a);
		System.out.println(b);
		
		int x=2;
		int y=3;
		
		x=x+y;
		y=x-3;
		x=x-y;
		
		System.out.println(x);
		System.out.println(y);
		
		
	}
}
