package com.jaga;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
	public static void main(String[] args) {
		System.out.println("main thread starts here");
		Exchanger<Integer> exc = new Exchanger<Integer>();
		new Thread(new FirstThread(exc)).start();
		new Thread(new SecondThread(exc)).start();
		System.out.println("end of main thread");
	}
}

class FirstThread implements Runnable {
	private Exchanger<Integer> exchange;
	private int counter;
	FirstThread(Exchanger<Integer> exchange){
		this.exchange = exchange;
	}
	@Override
	public void run() {
		System.out.println("starting run method of FirstThread");
		while(true) {
			System.out.println("incrementing counter value");
			counter = counter+1;
			try {
				counter = exchange.exchange(counter);
				System.out.println("counter value from firstThread after inc "+counter);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}

class SecondThread implements Runnable {
	private Exchanger<Integer> exchange;
	private int counter;
	SecondThread(Exchanger<Integer> exchange){
		this.exchange = exchange;
	}
	@Override
	public void run() {
		System.out.println("starting run method of SecondThread");
		while(true) {
			System.out.println("decrementing counter value");
			counter = counter-1;
			try {
				Thread.sleep(2000);
				counter = exchange.exchange(counter);
				System.out.println("counter value from secondThread after dec "+counter);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
