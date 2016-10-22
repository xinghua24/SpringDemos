package com.xinghua24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.otherconfig.BazConfig;

@Configuration
@ComponentScan("com.xinghua24")
@Import(BazConfig.class)
public class ApplicationConfig {
    
    @Autowired
    private Baz baz;
    
    @Bean
    public Bar bar(){
        Bar bar = new Bar();
        bar.setBaz(baz);
        return bar;
    }
}
