package com.jaga20Oct;

public class CLLImpl {
	Node tail;
	Node head;
	int size;
	
	public void addFirst(int data){
		Node tmp = new Node(data);
		if(size == 0){
			head = tmp;
			tail = tmp;
			tmp.next = head;
			size++;
		}else{
			tmp.next = head;
			head = tmp;
			tail.next = tmp;
			size++;
		}
	}
	
	public void addLast(int data){
		Node tmp = new Node(data);
		if(size == 0){
			head = tmp;
			tail = tmp;
			tmp.next = head;
			size++;
		}else{
			tail.next = tmp;
			tail = tmp;
			tmp.next = head;
			size++;
		}
	}
	
	public void removeFirst(){
		head = head.next;
		tail.next = head;
		size--;
	}
	
	public void removeLast(){
		Node tmp = head;
		//intially tmp equals to head so do while
		//System.out.println(size);
		for(int i=1;i<size-1;i++){
			//System.out.println(tmp.data+"this is data11");
			tmp = tmp.next;
			
		}
		tmp.next = head;
		tail = tmp;
		size--;
		//System.out.println(tmp.data+"this is data");
		
		//System.out.println(tmp.data+"this is data");
	}
	public void print(){
		Node tmp = head;
		do{
			System.out.println(tmp.data);
			tmp = tmp.next;
		}while(tmp!=head);
	}
	
	public static void main(String[] args) {
		CLLImpl imp = new CLLImpl();
		imp.addFirst(20);
		imp.addFirst(30);
		imp.addLast(80);
		imp.print();
		System.out.println("==============");
		imp.removeFirst();
		imp.removeLast();
		imp.print();
	}
}
