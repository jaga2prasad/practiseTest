package com.jaga;

public class TImpl {
	Node root;
	public void addNode(int key,String name){
		Node newNode = new Node(key,name);
		if(root == null){
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent ;
			while(true){
				parent = focusNode;
				if(key < focusNode.key) {
					focusNode = focusNode.left;
					if(focusNode == null) {
						parent.left = newNode; 
						return;
					}
				} else {
					focusNode = focusNode.right;
					if(focusNode == null){
						parent.right = newNode;
						return;
					}
				}
				
			}
		}
	}
	
	public void inorderTransversal(Node focusNode){
		if(focusNode != null) {
		inorderTransversal(focusNode.left);
		System.out.println(focusNode);
		inorderTransversal(focusNode.right);
		}
	}
	
	public void preorderTransversal(Node focusNode){
		if(focusNode!=null){
			preorderTransversal(focusNode);
			preorderTransversal(focusNode.left);
			preorderTransversal(focusNode.right);
		}
	}
	
	public void postOrderTrasnversal(Node focusNode){
		if(focusNode!=null){
			postOrderTrasnversal(focusNode.left);
			postOrderTrasnversal(focusNode.right);
			postOrderTrasnversal(focusNode);
		}
	}
	
	public Node findKey(int key) {
		Node focusNode = root;
		while (focusNode.key != key) {
			if(key < focusNode.key){
				focusNode = focusNode.left;
			}else{
				focusNode = focusNode.right;
			}
			if(focusNode == null) return null;
		}
		return focusNode;
	}
	
	public static void main(String[] args) {
		TImpl t = new TImpl();
		t.addNode(50, "Boss");
		t.addNode(25, "Vice President");
		t.addNode(15, "Office Manager");
		t.addNode(30, "Secretary");
		t.addNode(75, "Sales Manager");
		t.addNode(85, "Salesman 1");
		t.inorderTransversal(t.root);
		//System.out.println(t.findKey(75).name);
	}
}
