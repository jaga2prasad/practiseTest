package com.jaga;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadObjects {
	public static void main(String[] args) {
		String fileName = "files/float-externalizable.bin";
		File file =new File(fileName);
		try(InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);){
			//List<Person> list = (List<Person>)ois.readObject();
			//list.forEach(System.out::println);
			
			//Person1 p = (Person1)ois.readObject();
			//System.out.println(p);
			
			Person2 p = (Person2)ois.readObject();
			System.out.println(p);
			
			//Person3 p = (Person3)ois.readObject();
			//System.out.println(p);
			
		}catch(IOException | ClassNotFoundException e) {
			
		}
	}
}
