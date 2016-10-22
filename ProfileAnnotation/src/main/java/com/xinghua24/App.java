package com.xinghua24;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
	    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	    
	    Endpoint endpoint = context.getBean("endpoint", Endpoint.class);
	    System.out.println(endpoint.getUrl());

		context.close();
	}
}
