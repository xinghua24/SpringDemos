To create a PropertyPlaceholderConfigurer to load properties file
```xml
	<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="location" value="classpath:app.properties" />
	</bean>
```

This is the same as
```xml
<context:property-placeholder location="classpath:app.properties"/>
```

After declaring the properties file, you can access the property value using EL.
```xml
	<bean class="com.xinghua24.Foo" id="foo">
		<property name="value1" value="${properties.property1}" />
		<property name="value2" value="${properties.property2}" />
		<property name="value3" value="${properties.property3}" />
	</bean>
```

API
- [PropertyPlaceholderConfigurer](http://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/PropertyPlaceholderConfigurer.html)

