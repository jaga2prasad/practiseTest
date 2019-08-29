package com.jaga;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.jaga.common.LoopTask1;
//Here we need to synchronize read and wites of resources if we are using same resources.
public class SingleThreadPool {
	public static void main(String[] args) {
		ExecutorService exeService = Executors.newSingleThreadExecutor();
		exeService.submit(new LoopTask1());
		exeService.submit(new LoopTask1());
		exeService.submit(new LoopTask1());
		
		exeService.shutdown();
	}
}
