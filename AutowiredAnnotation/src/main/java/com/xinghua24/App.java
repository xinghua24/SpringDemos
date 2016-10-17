package com.xinghua24;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinghua24.entity.Foo;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");

        Foo foo = context.getBean("foo", Foo.class);
        System.out.println(foo.getBar().getBaz().getMyValue());
        
        ((ClassPathXmlApplicationContext) context).close();
    }
}
