package com.xinghua24;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");

        Foo foo = context.getBean("foo", Foo.class);
        Bar bar = context.getBean("bar", Bar.class);
        
        context.close();
    }
}
