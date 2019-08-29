package com.jaga;

public class SL {
	int data;
	SL next;
	SL(int data){
		this.data = data;
		this.next = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public SL getNext() {
		return next;
	}
	public void setNext(SL next) {
		this.next = next;
	}
	
}
