package com.jaga22Sep;

public class LinkedListApi {
	Node head ;
	LinkedListApi(){
		head = null;
	}
	
	public void insert(int i){
		//check length and vary according ly
		Node node = new Node(i);
		node.next = head;
		//node.setNext(head);
		head = node;
	}
	
	public void insertEnd(int i){
		Node node = new Node(i);
		Node p = head;
		while(p.next != null){
			p = p.next;
		}
		p.setNext(node);
	}
	
	public void insetPos(int i,int pos){
		Node node = new Node(i);
		Node p = head,q = null;
		for(int j=1;j<pos;j++){
			q=p; // pos =2, q = node at 2
			p=p.next;	//pos=2, p = node at 3		
		}
		q.next = node;
		node.setNext(p);
	}
	
	public void delAtStart(){
		Node node = head;
		//node.setNext(head.getNext()); -- doesn't work
		node = head.getNext();
		head = node;
	}
	public void delAtEnd(){
		Node node = head;
		Node p = null;
		while(node.getNext() != null){
			p =node;
			node = node.next;
		}
		p.next = null;
	}
	public void delAtPos(int pos){
		Node node = head;
		Node p = null;
		for(int i=1;i<pos;i++){
			p = node; //prev node at pos
			node = node.next; // curr
		}
		p.next = node.next;
		
	}
	
	//Need to look into it
	public void reverse(){
		Node node = head;
		Node nextNode = null, prevNode = null;
		while(node != null){
			nextNode = node.next;
			node.next = prevNode;
			prevNode = node;
			node = nextNode;
		}
		head = prevNode;
	}
	public void display(){
		Node p = head;
		while(p != null){
			System.out.print(p.getData() +"--->");
			p = p.next;
		}
	}
}
