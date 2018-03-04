package com.xinghua24.entities;

import org.springframework.stereotype.Component;

@Component
public class Baz {
	public void run(){
        Foo foo = new Foo();
        foo.greet();
	}
}
