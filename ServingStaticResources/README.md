Spring Boot comes with a pre-configured implementation of ResourceHttpRequestHandler to facilitate serving static resources.

By default, this handler serves static content from any of the /static, /public, /resources, and /META-INF/resources directories that are on the classpath.

MvcConfig.java serving src/main/resources/admin folder
```java
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        // register /admin/** resource handler.
        // serve static resource from classpath:/admin
        registry.addResourceHandler("/admin/**")
                .addResourceLocations("classpath:/admin/");

    }
}
```


Reference
* [Serve Static Resources with Spring by Eugen Paraschiv](https://www.baeldung.com/spring-mvc-static-resources)