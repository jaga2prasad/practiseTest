package com.jaga17Oct;

public class DLLImpl {
	DLL head;
	DLL tail;
	int size;
	
	DLLImpl(){
		size = 0;
	}
	
	public void addFirst(int data){
		DLL tmp = new DLL(data,head,tail);
		if(head!=null){head.prev = tmp;}
		head = tmp;
		size++;
		if(tail == null){tail = tmp;}
		size++;
	}
	
	public void addLast(int data){
		DLL tmp = new DLL(data,null,tail);
		if(tail!=null) {tail.next = tmp;}
		tail = tmp;
		size++;
		if(head == null){head = tmp;}
		size++;
	}
	public void iterateForward(){
		DLL tmp = head;
		while(tmp!=null){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	
	public void iterateBackward(){
		DLL tmp = tail;
		while(tmp!=null){
			System.out.println(tmp.data);
			tmp = tmp.prev;
		}
	}
	public void removeFirst(){
		//DLL tmp = head;
		head = head.next;
		head.prev = null;
		size--;
	}
	
	public void removeLast(){
		//DLL tmp = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
	}
	
	public static void main(String[] args) {
		DLLImpl imp = new DLLImpl();
		imp.addFirst(20);
		imp.addFirst(30);
		imp.addLast(50);
		imp.addFirst(60);
		imp.addFirst(70);
		imp.iterateForward();
		imp.removeFirst();
		imp.removeLast();
		System.out.println("=============");
		imp.iterateBackward();
	}
}
