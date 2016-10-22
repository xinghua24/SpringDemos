package com.otherconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xinghua24.Baz;

@Configuration
public class BazConfig {
    
    @Bean
    public Baz baz(){
        Baz baz = new Baz();
        baz.setMyValue("ABCDEFG");
        return baz;
    }
}
