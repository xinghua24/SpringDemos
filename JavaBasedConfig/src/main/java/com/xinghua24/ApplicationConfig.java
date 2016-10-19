package com.xinghua24;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public Foo foo(){
        Foo foo = new Foo(bar());
        
        Bar bar1 = bar();
        Bar bar2 = bar();
        
        System.out.println("bar1 == bar2? " + (bar1 == bar2));  // true
        
        return foo;
    }
    
    @Bean
    public Bar bar(){
        Bar bar = new Bar();
        bar.setBaz(baz());
        return bar;
    }
    
    @Bean
    public Baz baz(){
        Baz baz = new Baz();
        baz.setMyValue("Hello!!");
        return baz;
    }
}
