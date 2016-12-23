package com.xinghua24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("com.xinghua24")
@PropertySource("classpath:app.properties")
public class ApplicationConfig {
	
	@Value("${properties.property1}") // get property using @Value
	private String prop1;
	
	@Autowired
	private Environment env;
	
	@Bean
	public String str1(){
		return prop1;
	}
	
	@Bean
	public String str2(){
		return env.getProperty("properties.property2"); // get property from env
	}
	
	// To resolve ${} in @Value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfig(){
		return new PropertySourcesPlaceholderConfigurer();
	}
}