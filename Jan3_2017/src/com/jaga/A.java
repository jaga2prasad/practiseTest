package com.jaga;

public class A {
	public static void main(String[] args) {
		int a = 3100;
		int b = 500;
		
		int d = 0;
		
		System.out.println(a/b);
		System.out.println(a%b);
		int c = a/b;
		if(a%b > 0) {
			c = c+1;
		}
		for(int i=0;i<c;i++){
			System.out.println("limit"+b);
			System.out.println("offset"+d);
			d = d+b;
		}
		
		System.out.println("============");
		
		for(int i=0;i<a;i=i+500){
			System.out.println("limit " + b);
			System.out.println("offset " + i);
		}
		
		System.out.println(c);
		System.out.println(a + "----" +b);
	}
}
