You can use Environment to access proeprty value in the config file.  
To resolve ${} in @Value, you need to provide a PropertySourcesPlaceholderConfigurer static bean.  

```java
@Configuration
@ComponentScan("com.xinghua24")
@PropertySource("classpath:app.properties")
public class ApplicationConfig {
	
	@Value("${properties.property1}")
	private String prop1;
	
	@Autowired
	private Environment env;
	
	@Bean
	public String str1(){
		return prop1;
	}
	
	@Bean
	public String str2(){
		return env.getProperty("properties.property2");
	}
	
	// To resolve ${} in @Value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfig(){
		return new PropertySourcesPlaceholderConfigurer();
	}
}
```

Reference
* [PropertySource Annotation](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/PropertySource.html)

For More
* [Mkyong Spring propertysources example](https://www.mkyong.com/spring/spring-propertysources-example/)