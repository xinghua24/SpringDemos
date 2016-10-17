To use constructor argument to construct a bean, you need to provide additional information as attributes to <constructor-arg> element.
- type(the exact type of the constructor parameter.)
- index (start from 0)
- name(exact name of the constructor parameter)
- ref(reference another bean)
- value(simple values)

```xml
	<bean id="userView" class="com.xinghua24.UserView">
		<constructor-arg ref="serviceA" type="com.xinghua24.UserService"/>
	</bean>
```

Reference
- [http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans-factory-ctor-arguments-resolution](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans-factory-ctor-arguments-resolution)