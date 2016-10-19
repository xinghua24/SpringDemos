package com.xinghua24;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public Baz baz(){
        Baz baz = new Baz();
        baz.setMyValue("Hello!!");
        return baz;
    }
}
