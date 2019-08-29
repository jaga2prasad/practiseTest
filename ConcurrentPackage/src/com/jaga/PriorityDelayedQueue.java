package com.jaga;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityDelayedQueue {
	public static void main(String[] args) {
		BlockingQueue<Person> pq = new PriorityBlockingQueue<>();
		Thread t = new Thread(new FirstWorker(pq));
		Thread t1 = new Thread(new SecondWorker(pq));
		
		t.start();
		t1.start();
	}
}

class Person implements Comparable<Person>{
	private int id;
	private String name;
	Person(int id,String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.id+"---"+this.name;
	}
	@Override
	public int compareTo(Person o) {
		//return this.name.compareTo(o.getName());
		return Integer.compare(this.id, o.getId());
	}
}

class FirstWorker implements Runnable {
	BlockingQueue<Person> pq;
	FirstWorker(BlockingQueue<Person> person) {
		this.pq = person;
	}
	@Override
	public void run() {
		try {
			pq.put(new Person(10,"jaga"));
			pq.put(new Person(20,"prasad"));
			pq.put(new Person(50,"teeka"));
			pq.put(new Person(30,"ambi"));
			pq.put(new Person(80,"seena"));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}

class SecondWorker implements Runnable {
	BlockingQueue<Person> pq;
	SecondWorker(BlockingQueue<Person> person) {
		this.pq = person;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println(pq.take());
			Thread.sleep(1000);
			System.out.println(pq.take());
			Thread.sleep(1000);
			System.out.println(pq.take());
			System.out.println(pq.take());
			System.out.println(pq.take());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}