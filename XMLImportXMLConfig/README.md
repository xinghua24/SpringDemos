XML Config file can import another XML Config file by import element.

ApplicationContext.xml

```xml
<import resource="./contexts/SubContext.xml"/>

<bean id="foo" class="com.xinghua24.Foo">
	<property name="bar" ref="bar" />
</bean>
```
