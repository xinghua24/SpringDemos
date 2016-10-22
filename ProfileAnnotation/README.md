Most projects have different environments like Dev, Test, Production. These profiles have different database connections, endpoint urls. 

Starting from Spring 4.0, @Profile can be apply at the class level or method level.

use of @Profile at the method level

```java
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
    //......
}


One way to activate a profile is to provide a JVM argument.

```
-Dspring.profiles.active=dev
```

@ActivateProfiles can be used to activate a profile when creating JUnit test.

Reference:
- [http://javapapers.com/spring/profile-annotation-improvements-in-spring-4/](http://javapapers.com/spring/profile-annotation-improvements-in-spring-4/)