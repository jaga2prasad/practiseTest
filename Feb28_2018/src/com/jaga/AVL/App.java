package com.jaga.AVL;

public class App {
	public static void main(String[] args) {
		AVLTree<Integer> avl = new AVLTree<>();
		avl.insert(10);
		avl.insert(20);
		avl.insert(30);
		avl.insert(40);
		
		//avl.traverse();
		
		avl.delete(20);
		
		avl.traverse();
	}
}
