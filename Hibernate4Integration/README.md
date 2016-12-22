add Hibernate and Spring ORM dependencies

```
	compile group: 'org.hibernate', name: 'hibernate-core', version: '4.3.11.Final'
	compile group: 'org.springframework', name: 'spring-orm', version: project.ext.springVersion
```

ApplicationContext.xml  
add Hibernate SessionFactory and TransactionManger for Hibernate 4  
Do not use Hibernate's SessionFactory implementation, use Spring's instead.  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans>

	<jdbc:embedded-database id="dataSource" type="H2">
		<jdbc:script location="classpath:init.sql" />
	</jdbc:embedded-database>
	
	<bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="configLocation" value="classpath:hibernate.cfg.xml" />
	</bean>
	
	<bean id="transactionManager" class="org.springframework.orm.hibernate4.HibernateTransactionManager">
		<property name="sessionFactory" ref="sessionFactory" />
	</bean>

	<context:component-scan base-package="com.xinghua24.repo" />
</beans>


```