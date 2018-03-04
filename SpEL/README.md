# Spring Expression Language(SpEL)

SpEL is a powerful expression language that supports querying and manipulating an object graph at runtime. <br>
SpEL is not tied to Spring, it can be used without a spring context.


**HelloWorld**
```java
ExpressionParser parser = new SpelExpressionParser();
String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
System.out.println(helloWorld);
```


Reference
* [SpEL Reference](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/expressions.html)
* [SpEL Language Reference](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/expressions.html#expressions-language-ref)
