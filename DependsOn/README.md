ApplicationConfig.java uses Java based configuration. Here `foo` bean depends on `bar` bean. 
The @DependsOn annotation guarantee`bar` bean is created before `foo`.
```java
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
```

```
entering bar()
exiting bar()
entering foo()
exiting foo()
Foo [bar=Bar [msg=Hello Spring]]
```