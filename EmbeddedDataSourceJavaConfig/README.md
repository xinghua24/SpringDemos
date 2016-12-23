#Creating an embedded database programmatically

EmbeddedDatabase class can be build using a fluent API provided by EmbeddedDatabaseBuilder

```java
	@Bean
	public DataSource dataSource(){
		return new EmbeddedDatabaseBuilder()
				.generateUniqueName(true)
				.setType(EmbeddedDatabaseType.H2)
				.setScriptEncoding("UTF-8")
				.ignoreFailedDrops(true)
				.addScripts("schema.sql", "data.sql")
				.build();
	}
```
Reference
* [Spring docs - Embedded database support section](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#jdbc-embedded-database-support)