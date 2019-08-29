package com.jaga;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WiteObject {
	public static void main(String[] args) {
		String fileName = "files/float-externalizable.bin";
		File file = new File(fileName);
		//Person p1 = new Person(1,"jaga");
		//List<Person> list = new ArrayList<>();
		//list.add(p1);
		
		//Person1 p1 = new Person1(1,"jaga");
		
		Person2 p1 = new Person2(2,"teeka");
		
		//Person3 p1 = new Person3(2,"teeka");
		//Person3 p2 = new Person3(4,"jaga");
		
		try(OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);){
			//oos.writeObject(list);
			oos.writeObject(p1);
			//oos.writeObject(p2);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(Files.size(Paths.get(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
