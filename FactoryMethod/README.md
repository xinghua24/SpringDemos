Inject bean using factory method.

```xml
<beans>
	<bean id="foo" class="com.xinghua24.Foo"  factory-method="getInstance" />
	
	<bean id="objectFactory" class="com.xinghua24.ObjectFactory" />
	<bean id="bar" class="com.xinghua24.Bar" factory-bean="objectFactory" factory-method="getBar" />
</beans>
```
Result
calling Foo.getInstance()
This is Foo!