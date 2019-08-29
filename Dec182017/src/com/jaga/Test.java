package com.jaga;

import java.util.ArrayList;
import java.util.List;

public class Test {
	List list = new ArrayList();
   public void test(){
	   synchronized(list) {
		   list.add(2);
		   System.out.println("added value");
	   }
   }
   
   public void test1(){
	   synchronized(list) {
		  // if(!list.isEmpty())
		   System.out.println(list.get(0));
	   }
   }
   
   public static void main(String[] args) {
	   final Test test = new Test();
	Thread t = new Thread(new Runnable(){

		@Override
		public void run() {
			for(int i=0;i<10;i++)
				test.test();			
		}
		
	});
	t.start();
	
	Thread t1 = new Thread(new Runnable(){

		@Override
		public void run() {
			for(int i=0;i<10;i++)
				test.test1();			
		}
		
	});
	t1.start();
   }
}
