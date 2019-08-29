package com.jaga;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedQueue {
	public static void main(String[] args) {
		System.out.println("start of main method");
			BlockingQueue<Worker> queue = new DelayQueue<>();
			try {
				queue.put(new Worker(1000,"first message")); //queue waits for 1 second 
				queue.put(new Worker(10000,"second message")); //queue waits for 10 sec
				queue.put(new Worker(4000,"thrid message")); //queue waits for 4 sec
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(!queue.isEmpty()) {
				try {
					System.out.println(queue.take()); //once above mentioned delay is expired take will fetch items.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		System.out.println("end of main method");
	}
}

class Worker implements Delayed {
	private long delayTime;
	private String message;
	
	Worker(long delay , String msg) {
		this.delayTime = System.currentTimeMillis()+ delay;
		this.message = msg;
	}
	
	public long getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(long delayTime) {
		this.delayTime = delayTime;
	}

	@Override
	public int compareTo(Delayed time) {
		if(this.delayTime < ((Worker) time).getDelayTime()) {
			return -1;
		}
		if(this.delayTime < ((Worker) time).getDelayTime()) {
			return +1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.delayTime-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}
	
	@Override
	public String toString() {
		return this.message;
	}
	
}
