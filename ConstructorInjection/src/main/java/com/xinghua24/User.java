package com.xinghua24;

public class User {
	private String name;
	
	public User(){
		
	}
	
	public User(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void display() {
		System.out.println("Hi I am " + name);
	}
}
