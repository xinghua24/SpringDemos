package com.xinghua24;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xinghua24.entity.Foo;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Foo foo = (Foo) context.getBean("foo", Foo.class);
		System.out.println(foo);

		System.out.println(context.getBean("str1", String.class));

		System.out.println(context.getBean("str2", String.class));
		
		context.close();
	}
}
