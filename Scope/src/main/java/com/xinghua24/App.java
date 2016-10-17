package com.xinghua24;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
		
		Singleton singleton1 = context.getBean("singleton", Singleton.class);
		
		Singleton singleton2 = context.getBean("singleton", Singleton.class);
		
		System.out.println("singleton1 == singleton2? " + (singleton1 == singleton2) );
		
		
		Prototype proto1 = context.getBean("prototype", Prototype.class);
		
		Prototype proto2 = context.getBean("prototype", Prototype.class);
		
		System.out.println("proto1 == proto2? " + (proto1 == proto2) );
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
