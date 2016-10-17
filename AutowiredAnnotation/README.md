@Autowired can be used in property, constructor, setter method or plain methods.

If the autowired property is not required, then set required attribute to be false

```java
@Autowired(required=false)
```

Reference

- [http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans-autowired-annotation](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans-autowired-annotation)