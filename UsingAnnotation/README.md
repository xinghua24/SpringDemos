To enable Annotation, add the following element to xml config file

```xml
<context:annotation-config />
```

After enabling Annotation, many annotations can be used including @Value, @Required, @Autowire, @PostConstruct, @PreDestroy etc.

Using @Value as example. @Value can be used with property or setter method to set the value of the property.

```java
public class Foo {
    @Value("DEF")
    private String myValue;
}
```


Reference:
- [http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans-annotation-config](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans-annotation-config)