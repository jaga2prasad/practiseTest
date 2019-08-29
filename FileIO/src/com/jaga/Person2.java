package com.jaga;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person2 implements Externalizable{
	private int id;
	private String name;
	
	Person2(){
		
	}
	Person2(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Person2 [id=" + id + ", name=" + name + "]";
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		String add = name+"::"+id;
		out.write(add.getBytes());
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		byte[] buffer = new byte[1024];
		int read = in.read(buffer);
		String strings = new String(buffer,0,read);
		String[] test = strings.split("::");
		this.name = test[0];
		this.id = Integer.valueOf(test[1]);
		
	}
}
