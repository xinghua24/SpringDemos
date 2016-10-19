package com.xinghua24;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.xinghua24")
@ImportResource(value="ApplicationContext.xml")
public class ApplicationConfig {
    
}
