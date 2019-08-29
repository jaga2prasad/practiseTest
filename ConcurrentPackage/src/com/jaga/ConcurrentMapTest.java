package com.jaga;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapTest {
	public static void main(String[] args) {
		System.out.println("start of main thread");
		ConcurrentHashMap<String, Integer> cmap = new ConcurrentHashMap<>();
		new Thread(new FirstWorker1(cmap)).start();
		new Thread(new SecondWorker1(cmap)).start();
		System.out.println("end of main thread");
	}
}

class FirstWorker1 implements Runnable {
	ConcurrentHashMap<String,Integer> map;
	FirstWorker1(ConcurrentHashMap<String,Integer> cMap) {
		this.map = cMap;
	}
	@Override
	public void run() {
		map.put("A", 1);
		map.put("Z", 10);
		map.put("F", 12);
		map.put("K", 5);
	}
}

class SecondWorker1 implements Runnable {
	ConcurrentHashMap<String,Integer> map;
	SecondWorker1(ConcurrentHashMap<String,Integer> cMap) {
		this.map = cMap;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			
			
			for(Map.Entry<String, Integer> entry: map.entrySet()){
				System.out.println(entry.getKey()+"------"+entry.getValue());
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
