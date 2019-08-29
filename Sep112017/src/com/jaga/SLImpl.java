package com.jaga;

public class SLImpl {
	SL head;
	public void insertBegin(SL node){
		node.next = head;
		head = node;
	}
	
	public void insertEnd(SL node){
		SL curr = head;
		while(curr.next != null){
			curr = curr.next;
		}
		curr.next = node;
	}
	
	public void insertPos(SL node, int pos){
		SL p,q = null;
		if(pos ==1){
			insertBegin(node);
		}else if(pos>1){
			//get length length 
			int length;
			p = head;
			for(int i=0;i<=pos;i++){
				q = p.next;
			}
			// q contains next head
			node.setNext(q.next);
			q.setNext(node);
			
		}
	}
	
	public void delBegin(){
		SL node  = head;
		head = node.next;
	}
	
	public void delEnd(){
		SL node = head;
		while(node.next != null){
			node = node.next;
		}
		node.setNext(null);
	}
	
	public void delPos(int pos){
		SL node = head;
		SL p = null,q = null;
		for(int i=0;i<=pos;i++){
			p=node; //old node
			node = node.next;
			q = node; //next node
		}
		
		p.setNext(q.next);
		
	}
	
}
