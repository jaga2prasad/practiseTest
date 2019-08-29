package com.jaga;

import java.util.concurrent.Callable;

public class TestCall implements Callable<String>{

	@Override
	public String call() throws Exception {
		return new String("hello");
	}

}
