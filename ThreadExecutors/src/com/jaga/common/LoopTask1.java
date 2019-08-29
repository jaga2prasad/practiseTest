package com.jaga.common;

public class LoopTask1 implements Runnable{
	 static int count = 0;
	private int id = 0;
	@Override
	public void run() {
		System.out.println("###### TASK "+id+" started###########");
			for(int i=0;i<5;i++) {
				System.out.println("value "+i);
			}
		System.out.println("******** TASK "+id+" END **************");
		
	}
	
	public LoopTask1(){
		this.id=++count;
	}
}
