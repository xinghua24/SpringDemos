Why do we need Dependency Injection?
Hard coding a dependencies( using new ) into a class increases coupling. It makes it difficult to switch to other implementation of the dependency. In Spring, objects are stored as beans in Spring IoC Container. client code get the bean from the Spring IoC Container. Spring IoC Container is more flexible. Dependency can be replaced easily. Testing becomes much more easier.

ApplicationContext represents the Spring IoC container. There are many implementation for this interface.  

To tell Spring container how to instantiate, configure, and assemble beans, we need to supply configuration metadata to the application. Traditionally configuration metadata is supplied in XML format. Nowadays it is more popular to use annotation-based configuration and java-based configuration.

This project uses XML-based configuration approach.

ClassPathXmlApplicationContext Class is a subclass of ApplicationContext. it uses an XML file to configure Spring Container.

In this project, we use setter injection. A bean of type userView is defined in configuration file ApplicationContext.xml. App.java get the bean instance from the container and calls the userView bean's displayUser method.

```xml
	<bean id="serviceA" class="com.xinghua24.AUserService"></bean>
	
	<bean id="serviceB" class="com.xinghua24.BUserService"></bean>
	
	<bean id="userView" class="com.xinghua24.UserView">
		<property name="userService" ref="serviceB" />
	</bean>
```

result from running the project:
Hi I am User B

Reference
[http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans)