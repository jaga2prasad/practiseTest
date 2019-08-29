package com.jaga.common;

public class LoopTask2 implements Runnable{
	 static int count = 0;
	private int id = 0;
	@Override
	public void run() {
		Thread.currentThread().setName("Jaga"+id);
		String threadName = Thread.currentThread().getName();
		
		System.out.println("###### TASK "+threadName+" " +id+" started###########");
			for(int i=0;i<5;i++) {
				System.out.println("value "+i);
			}
		System.out.println("******** TASK "+threadName+" "+id+" END **************");
		
	}
	
	public LoopTask2(){
		this.id=++count;
	}
}
