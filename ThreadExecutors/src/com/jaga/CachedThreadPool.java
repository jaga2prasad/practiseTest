package com.jaga;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.jaga.common.LoopTask1;

public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService exeService = Executors.newCachedThreadPool();
		exeService.submit(new LoopTask1());       //submission phase
		exeService.submit(new LoopTask1());
		exeService.submit(new LoopTask1());
		
		exeService.submit(new LoopTask1());
		exeService.submit(new LoopTask1());
		
		exeService.shutdown();
	}
}
