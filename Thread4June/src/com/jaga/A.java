package com.jaga;

public class A {
	
	public static void main(String[] args) {
		Thread a = new Thread(new Runnable(){
			@Override
			public void run() {
				try{
				for(int i=0;i<4;i++)
					 System.out.println("j "+i);
					Thread.sleep(2000);
				}catch(InterruptedException e) {
					System.out.println("thread is interrupted");
					return;
				}
			}			
		});
		
		Thread b = new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0;i<4;i++)
					 System.out.println("jp "+i);				
			}			
		});
	//	a.interrupt();
		a.start();
	a.yield(); 
		b.start();
		//b.interrupt();
	}
}
