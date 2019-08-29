package com.jaga17Oct;

public class DLLImpl1 {
	DLL head;
	DLL tail;
	int size;
	DLLImpl1(){
		size = 0;
	}
	
	public void addFirst(int data){
		DLL tmp = new DLL(data,head,tail);
		if(head != null){
			head.prev = tmp;
		}
		head = tmp;
		size++;
		if(tail == null){tail = head;}
		size++;
	}
	
	public void addLast(int data){
		DLL tmp = new DLL(data,null,tail);
		if(tail != null) {tail.next = tmp;}
		tail = tmp;
		size++;
		if(head == null){head = tail;}size++;
	}
	
	public void addPos(int data,int pos){
		DLL tmp = new DLL(data,null,null);
		DLL current = head;
		for(int i=1;i<pos;i++){
			current = current.next;
		}
		
		System.out.println(current.data +"this is data");
		System.out.println(current.prev.data+"this is prev data");
		
		tmp.prev = current.prev;
		current.prev.next = tmp;
		tmp.next = current;
		current.prev = tmp;
			
		//tmp.next = current.next;
		//current.next = tmp;
		//tmp.prev = current;
		//current.next.prev = tmp;
		size++;
	}
	public void iterate(){
		DLL tmp = head;
		while(tmp != null){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	
	public void removeFirst(){
		//DLL tmp = head;
		head = head.next;
		head.prev = null;
		size--;
	}
	
	public void removeLast(){
		tail = tail.prev;
		tail.next = null;
		size--;
	}
	
	public void removePos(int pos){
		DLL tmp = head;
		for(int i=1;i<pos;i++){
			tmp = tmp.next;
		}
		
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;
		size--;
	}
	
	public static void main(String[] args) {
		DLLImpl1 imp = new DLLImpl1();
		imp.addFirst(30);
		imp.addFirst(40);
		imp.addLast(70);
		imp.addPos(80, 2);
		imp.iterate();
		System.out.println("=======");
		//imp.removeFirst();
		//imp.removeLast(); 
		imp.removePos(2);
		imp.iterate();
	}
}
