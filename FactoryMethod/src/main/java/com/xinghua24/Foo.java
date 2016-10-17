package com.xinghua24;

public class Foo {
	private static final Foo instance = new Foo();
	
	//private constructor
	private Foo(){}
	
	public void greet(){
		System.out.println("This is Foo!");
	}
	
	public static Foo getInstance() {
		System.out.println("calling Foo.getInstance()");
		return instance;
	}
}
