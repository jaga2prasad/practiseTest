package com.jaga;

public  class A1 {
	A1(){super();
		System.out.println("test A!");
	}
	
	A1(int a,int b) {
		System.out.println("test A1 paramter");
	}
}

class B1 extends A1{
	B1(){
		System.out.println("test B1");
	}
	
	B1(int a,int b) {
		System.out.println("test B1 paramter");
	}
}

