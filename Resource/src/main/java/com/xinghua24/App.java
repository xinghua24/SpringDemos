package com.xinghua24;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Foo foo = context.getBean("foo", Foo.class);
		foo.getResource();
		((AnnotationConfigApplicationContext)context).close();
	}
}
