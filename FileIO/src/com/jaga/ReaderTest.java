package com.jaga;

import java.io.File;
import java.io.IOException;

public class ReaderTest {
	
	public static <T> T getName(T value){
		String name = (String)value;
		return (T) name;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		File file = new File("files/jaga.txt");
		System.out.println(file.getName());
		System.out.println(file.exists());
		
		File file1 = new File("files/prasad.txt");
		System.out.println(file1.exists());
		file1.createNewFile();
		
	}
}
