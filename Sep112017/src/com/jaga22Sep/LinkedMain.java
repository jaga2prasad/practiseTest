package com.jaga22Sep;

public class LinkedMain {
	public static void main(String[] args) {
		LinkedListApi lApi = new LinkedListApi();
		lApi.insert(2);
		lApi.insert(4);
		lApi.insert(5);
		
		lApi.insetPos(6, 2);
		lApi.insertEnd(8);
		
		
		
		lApi.display();
		System.out.println("");
		lApi.delAtStart();
		lApi.delAtEnd();
		lApi.delAtPos(2);
		lApi.display();
		System.out.println("abc");
		lApi.reverse();
		lApi.display();
	}
}
