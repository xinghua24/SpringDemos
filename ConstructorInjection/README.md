Why do we need Dependency Injection?
Hard coding a dependencies( using new ) into a class increases coupling. It makes it difficult to switch to other implementation of the dependency. In Spring, objects are stored as beans in Spring IoC Container. client code get the bean from the Spring IoC Container. Spring IoC Container is more flexible. Dependency can be replaced easily. Testing becomes much more easier.

ApplicationContext represents the Spring IoC container. There are many implementation for this interface.  

To tell Spring container how to instantiate, configure, and assemble beans, we need to supply configuration metadata to the application. Traditionally configuration metadata is supplied in XML format. Nowadays it is more popular to use annotation-based configuration and java-based configuration.

This project uses XML-based configuration approach.

ClassPathXmlApplicationContext Class is a subclass of ApplicationContext. it uses an XML file to configure Spring Container.

In this project, a bean of type User is defined in configuration file ApplicationContext.xml. App.java get the bean instance from the container and calls the User bean's sayHello method.

result from running the project:
Hello from: John Doe

Reference
[http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans)