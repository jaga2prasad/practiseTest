package com.jaga.Naming;

import com.jaga.common.LoopTask2;

public class FirstType {
	public static void main(String[] args) {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName +" starts here");
		Thread t = new Thread(new LoopTask2());
		Thread t1 = new Thread(new LoopTask2());
		
		t.start();
		t1.start();
		
		System.out.println(threadName +" ends here");
	}
}
