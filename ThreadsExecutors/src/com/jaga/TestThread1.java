package com.jaga;

public class TestThread1 {
 public static void main(String[] args) {
	Thread t = new Thread(new FirstTask());
	t.start();
}
}

class FirstTask implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("jaga " +i);
		}
	}
	
	public FirstTask(){
		new Thread(this).start();
	}
	
}
