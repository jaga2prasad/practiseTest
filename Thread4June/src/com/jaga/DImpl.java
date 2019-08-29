package com.jaga;

public class DImpl {
	public static void main(String[] args) {
		D instance = D.getInstance();
		System.out.println(instance);
		D instance1 = D.getInstance();
		System.out.println(instance1);
	}
}
