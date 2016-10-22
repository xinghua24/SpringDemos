package com.xinghua24;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {

    @Bean(name="endpoint" )
    @Profile("dev")
    public Endpoint getDevEndpoint(){
        return new Endpoint("http://dev-endpoint-url.com");
    }
    
    @Bean(name="endpoint")
    @Profile("test")
    public Endpoint getTestEndpoint(){
        return new Endpoint("http://test-endpoint-url.com");
    }
    
    @Bean(name="endpoint")
    @Profile("prod")
    public Endpoint getProdEndpoint(){
        return new Endpoint("http://prod-endpoint-url.com");
    }
}
