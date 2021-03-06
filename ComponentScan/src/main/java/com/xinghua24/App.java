package com.xinghua24;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinghua24.entities.Foo;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");

        Foo foo = (Foo)context.getBean("foo");
        foo.getBar().greet();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
