package com.jaga;

public class D {
	private D(){
		
	}
	
	private volatile static D objInstance ;
	
	private static D test() {
		if(objInstance == null) {
			synchronized (D.class) {
				if(objInstance == null)
					objInstance = new D();
			}
		}
		return objInstance;
		
	}
	
	public static D getInstance(){
		return test();
	}
	
}
