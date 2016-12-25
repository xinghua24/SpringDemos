@Autowired can be used in property, constructor, setter method or plain methods.

If the autowired property is not required, then set required attribute to be false

```java
@Autowired(required=false)
```

@Autowired annotation inject beans **by Type**. @Qualifier annotation can be used to specify the bean name to be used for autowiring.


Reference
* [http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans-autowired-annotation](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans-autowired-annotation)
* [Spring @Autowired Annotaiton - JournalDev](http://www.journaldev.com/2623/spring-autowired-annotation)