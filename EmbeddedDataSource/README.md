Embedded datasource type
- HSQL (default)
- H2
- Derby


Add H2 driver
```
dependencies {
	compile group: 'com.h2database', name: 'h2', version: '1.4.188'
}
```

create embedded database instance in XML config file. The embedded database will be created by schema.sql and data.sql
```xml
	<jdbc:embedded-database id="dataSource" type="H2">
		<jdbc:script location="classpath:schema.sql" />
		<jdbc:script location="classpath:data.sql" />
	</jdbc:embedded-database>
```	
Reference
* [Spring docs - Embedded database support section](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#jdbc-embedded-database-support)