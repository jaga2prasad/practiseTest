package com.jaga.AVL;

public class AVLTree<T extends Comparable<T>> {
	Node<T> root;
	
	public void insert(T data){
		root = insert(root,data);
	}
	
	private Node<T> insert(Node<T> node,T data){
		if(node == null) {return new Node<>(data);}
		if(data.compareTo(node.getData())<0){
			node.setLeftNode(insert(node.getLeftNode(),data));
		} else {
			node.setRightNode(insert(node.getRightNode(),data));
		}
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
		return settleViolation(node,data);		
	}
	
	private Node<T> settleViolation(Node<T> node,T data) {
		int balance = getBalance(node);
		if(balance > 1 && data.compareTo(node.getLeftNode().getData())<0){
			return rightRotation(node);
		}
		if(balance<-1 && data.compareTo(node.getRightNode().getData())>0){
			return leftRotation(node);
		}
		if(balance >1 && data.compareTo(node.getLeftNode().getData())>0){
			node.setLeftNode(leftRotation(node.getLeftNode()));
			return rightRotation(node);
		}
		
		if(balance<-1 && data.compareTo(node.getRightNode().getData())<0){
			node.setRightNode(node.getLeftNode());
			return leftRotation(node);
		}
		return node;
	}
	
	
	public void delete(T data){
		root = delete(root,data);
	}
	
	private Node<T> delete(Node<T> node,T data) {
		if(node == null) {return node;}
		if(data.compareTo(node.getData())<0){
			node.setLeftNode(delete(node.getLeftNode(),data));
		} else if(data.compareTo(node.getData())>0){
			node.setRightNode(delete(node.getRightNode(),data));
		} else {
			if(node.getLeftNode() == null && node.getRightNode() == null) {
				return null;
			} 
			if(node.getLeftNode()==null){
				Node<T> tempRightNode = node.getRightNode();
				node = null;
				return tempRightNode;
			}
			if(node.getRightNode() == null) {
				Node<T> tempLeftNode = node.getLeftNode();
				node = null;
				return tempLeftNode;
			}
			
			Node<T> temp = getPredecessor(node.getLeftNode());
			node.setData(temp.getData());
			node.setLeftNode(delete(node.getLeftNode(),temp.getData()));			
		}
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
		return settleDeletion(node);
	}
	
	private Node<T> settleDeletion(Node<T> node) {
		int balance  = getBalance(node);
		if(balance >1) {
			if(getBalance(node.getLeftNode())<-1)
			node.setLeftNode(leftRotation(node.getRightNode()));
			return rightRotation(node);
		}
		if(balance < -1) {
			if(getBalance(node.getRightNode())>1) {
				node.setRightNode(rightRotation(node.getRightNode()));
			}
			return leftRotation(node);
		}
		return node;
	}
	
	public Node<T> getPredecessor(Node<T> node){
		if(node.getRightNode() != null) {
			return getPredecessor(node.getRightNode());
		}
		return node;
	}
	public void traverse(){
		if(root == null) return;
		inorder(root);
	}
	
	private void inorder(Node<T> root){
		if(root.getLeftNode() != null) {
			inorder(root.getLeftNode());
		}
		
		System.out.println(root.getData());
		
		if(root.getRightNode() != null) {
			inorder(root.getRightNode());
		}		
	}
	
	private Node<T> rightRotation(Node<T> node) {
		Node<T> tempLeftNode = node.getLeftNode();
		Node<T> temp = node.getRightNode();
		tempLeftNode.setRightNode(node);
		node.setLeftNode(temp);
		
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
		tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode()))+1);
		
		return tempLeftNode;
	}
	
	private Node<T> leftRotation(Node<T> node){
		Node<T> tempRightNode = node.getRightNode();
		Node<T> temp = node.getLeftNode();
		tempRightNode.setLeftNode(node);
		node.setRightNode(temp);
		
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
		tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftNode()), height(tempRightNode.getRightNode()))+1);
		
		return tempRightNode;
	}
	
	private int height(Node<T> node) {
		if(node == null) {return -1;}
		return node.getHeight();
	}
	
	private int getBalance(Node<T> node) {
		if(node == null) {return 0;}
		return height(node.getLeftNode()) - height(node.getRightNode());
	}
}
