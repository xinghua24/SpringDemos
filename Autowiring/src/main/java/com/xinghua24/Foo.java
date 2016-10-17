package com.xinghua24;

public class Foo {
	private Bar bar;
	
	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public void greet(){
		System.out.println("Calling Foo.greet()!");
		if( bar != null ){
			System.out.println("bar.getMyName() -> " + bar.getMyName());
		}
	}
}
