package com.jaga;

public class TestThread {
	public static void main(String[] args) {
		Thread t = new Thread(new FirstTask());
		t.start();
		
		Thread t1 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				System.out.println("jagannatha");
			}
		});
		
		t1.start();
	}
}

class FirstTask implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("jaga "+i);
		}
	}
	
}