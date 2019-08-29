package com.jaga;

import java.util.LinkedList;
import java.util.List;

public class ImplBlockingQueue {
	private List queue = new LinkedList();
	int limit = 10;
	

	public synchronized void enqueue(Integer i) throws InterruptedException{
		if(queue.size() == limit)
			wait();
		if(queue.size() == 0)
			notifyAll();
		queue.add(i);
	}
	
	public Integer dequeue() throws InterruptedException{
		if(queue.size() == 0)
			wait();
		if(queue.size() == limit)
			notifyAll();
		return (Integer) queue.remove(0);
	}
	
	public static void main(String[] args)  {
		ImplBlockingQueue impl = new ImplBlockingQueue();
		for(int i=0;i<15;i++) {
			try {
				impl.enqueue(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Jaga");
	}
}
