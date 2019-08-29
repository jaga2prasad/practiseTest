package com.jaga;

public class PC1 {
	public static void main(String[] args) {
		ApiMethod api= new ApiMethod();
		Thread t = new Thread(new Producer1(api,1));
		Thread t1 = new Thread(new Consumer1(api,1));
		
		t.start();
		t1.start();
	}
}

class ApiMethod {
	private int contents;
	public boolean avilable;
	public synchronized void put(int i) {
		while(avilable == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		avilable = true;
		contents = i;
		notifyAll();
	}
	
	public synchronized int get() {
		while(avilable == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		avilable = false;
		notifyAll();
		return contents;
	}
}

class Producer1 implements Runnable{
	public ApiMethod apiMethod;
	public int contents;
	
	Producer1(ApiMethod apiMethod, int contents) {
		this.apiMethod = apiMethod;
		this.contents = contents;
	}
	int i = 0;
	public void run(){
		while(true) {
			System.out.println("produced" + ++i);
			apiMethod.put(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer1 implements Runnable {
	public ApiMethod apiMethod;
	public int contents;
	
	Consumer1(ApiMethod apiMethod, int contents) {
		this.apiMethod = apiMethod;
		this.contents = contents;
	}
	@Override
	public void run() {
		while(true) {
		int con = apiMethod.get();
		System.out.println(con + " consumed");
	
		}
	}
	
}