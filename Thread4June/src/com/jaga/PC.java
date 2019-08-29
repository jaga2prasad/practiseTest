package com.jaga;

import java.util.Vector;

public class PC {
	public static void main(String[] args) {
		Vector v = new Vector();
		int size = 4;
		Thread tp = new Thread(new Producer(v,size));
		Thread tc = new Thread(new Consumer(v,size));
		
		tp.start();
		tc.start();
	}
}

class Producer implements Runnable{
	Vector vector;
	int size;
	
	Producer(Vector v, int s) {
		this.vector = v;
		this.size = s;
	}

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("produced value "+i);
			produce(i);
		}
	}

	private void produce(int i) {
		
		synchronized (this) {
			if(vector.size() == size) {
				System.out.println("vector is full from producer");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			vector.add(i);
			notifyAll();
		}
		
	}	
}

class Consumer implements Runnable{
	Vector vector;
	int size;
	
	Consumer(Vector v, int s) {
		this.vector = v;
		this.size = s;
	}
	@Override
	public void run() {
		while(true) {
			consume();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	private void consume() {
		synchronized (this) {

		if(vector.isEmpty()) {
			System.out.println("vector is empty from consumer");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(vector.remove(0));
		notifyAll();
	  }
		
	}
	
}
