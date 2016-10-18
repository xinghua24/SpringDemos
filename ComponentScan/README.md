To enable Component Scan

```xml
	<context:component-scan base-package="com.xinghua24" />
```

Component scan will scan the base package and its sub package.

Annotate the class with @Component to indicate this is a class to be scan.

Spring will set the bean name to be the class name with the lower case first character. So the bean name for Foo class is "foo". You can assign a name to it as attribute too.

```java
@Component("Foo")
class Foo{
}
```

Component scan annotation types
- @Component
- @Repository
- @Service
- @Controller

@Repository, @Service and @Controller have the same effect as @Component. They are used for readability.