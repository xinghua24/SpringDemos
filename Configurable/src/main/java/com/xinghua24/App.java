package com.xinghua24;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinghua24.entities.Baz;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");

       Baz baz = context.getBean(Baz.class);
       baz.run();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
