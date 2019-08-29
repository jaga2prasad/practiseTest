package com.jaga;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Person3 implements Serializable{
	private int id;
	private String name;
	
	Person3(){
		
	}
	Person3(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	private Object writeReplace() throws ObjectStreamException {
		return new PersonProxy(name+"::"+id);
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
		return "Person3 [id=" + id + ", name=" + name + "]";
	}
	
}
