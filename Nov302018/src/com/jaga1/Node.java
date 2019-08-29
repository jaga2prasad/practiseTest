package com.jaga1;

import java.util.ArrayList;
import java.util.List;

public class Node {
	Node node;
	String label;
	List<Node> childList = new ArrayList<>();
	
	Node(String label){
		this.label = label;
	}
	
	public void addChild(String label){
		Node n = new Node(label);
		childList.add(n);
	}
	
	public Node getChild(int index){
		if(index<childList.size())
			return childList.get(index);
		return null;
	}
	
	public List<Node> getChildren(){
		return new ArrayList<>(childList);
	}
	
	public static void print(Node root){
		System.out.println(root.label);
		for(Node child:root.getChildren()){
			print(child);
		}
	}
	
	
}
