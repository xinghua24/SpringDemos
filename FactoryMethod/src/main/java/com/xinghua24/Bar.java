package com.xinghua24;

public class Bar {
	private Foo foo;

	public Foo getFoo() {
		return foo;
	}

	public void setFoo(Foo foo) {
		this.foo = foo;
	}

	public void greet() {
		System.out.println("This is Bar!");
	}
	
}
