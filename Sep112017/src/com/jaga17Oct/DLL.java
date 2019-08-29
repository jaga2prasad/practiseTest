package com.jaga17Oct;

public class DLL {
	DLL next;
	DLL prev;
	int data;
	
	public DLL(int data,DLL next, DLL prev){
		this .data = data;
		this.next = next;
		this.prev = prev;
	}
	
}
