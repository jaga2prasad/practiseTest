package com.jaga;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person1 implements Serializable{
	private int id;
	private String name;
	
	Person1(){
		
	}
	Person1(int id, String name) {
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
	
	private void writeObject(ObjectOutputStream oos) throws Exception {
		DataOutputStream dos = new DataOutputStream(oos);
		dos.writeUTF(name+"::"+id);
	}
	
	private void readObject(ObjectInputStream ois) throws Exception {
		DataInputStream dis = new DataInputStream(ois);
		String content = dis.readUTF();
		String[] test = content.split("::");
		this.name = test[0];
		this.id = Integer.valueOf(test[1]);
	}
	@Override
	public String toString() {
		return "Person1 [id=" + id + ", name=" + name + "]";
	}
}
