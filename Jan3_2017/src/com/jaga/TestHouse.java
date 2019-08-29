package com.jaga;

public class TestHouse {
	public static void main(String[] args) {
		House blueHouse = new House("blue");
		House anotherHouse = blueHouse;
		
		System.out.println(blueHouse.getColor());
		System.out.println(anotherHouse.getColor());
		
		anotherHouse.setColor("red");
		//blueHouse.setColor("green");
		
		System.out.println("==========");
		
		System.out.println(blueHouse.getColor());
		System.out.println(anotherHouse.getColor());
		
		
	}
}
