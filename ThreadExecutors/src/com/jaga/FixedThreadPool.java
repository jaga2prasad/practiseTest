package com.jaga;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.jaga.common.LoopTask1;

public class FixedThreadPool {
	public static void main(String[] args) {
		ExecutorService exeService = Executors.newFixedThreadPool(3); //intilization phase
		exeService.submit(new LoopTask1());       //submission phase
		exeService.submit(new LoopTask1());
		exeService.submit(new LoopTask1());
		
		exeService.submit(new LoopTask1());
		exeService.submit(new LoopTask1());
		
		exeService.shutdown();  //shutdown phase
		
		exeService.submit(new LoopTask1()); //we can't start once service is shutdown
		//we will get java.util.concurrent.RejectedExecutionException
	}
}
