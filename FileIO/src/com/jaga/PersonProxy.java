package com.jaga;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class PersonProxy implements Serializable{
	private String name;
	PersonProxy(){
		
	}
	
	PersonProxy(String name) {
		this.name = name;
	}
	
	private Object readResolve() throws ObjectStreamException {
		String[] test = this.name.split("::");
		String name = test[0];
		int id = Integer.valueOf(test[1]);
		return new Person3(id,name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonProxy [name=" + name + "]";
	}
	
}
