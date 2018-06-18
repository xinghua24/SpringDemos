package com.xinghua24;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ApplicationConfig {
    @Bean
    @DependsOn("bar")
    public Foo foo(){
    	System.out.println("entering foo()");
        Foo foo = new Foo(bar());
        System.out.println("exiting foo()");
        return foo;
    }
    
    @Bean
    public Bar bar(){
    	System.out.println("entering bar()");
        Bar bar = new Bar("Hello Spring");
        System.out.println("exiting bar()");
        return bar;
    }
}
