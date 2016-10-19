Use **@ImportResource** If Java based config file needs to import a XML config file.

```java
@Configuration
@ComponentScan("com.xinghua24")
@ImportResource(value="ApplicationContext.xml")
public class ApplicationConfig {
    
}

```