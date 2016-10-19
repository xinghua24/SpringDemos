@ComponentScan can be used to scan package. it has the same effect as component-scan element in XML configuration file.

```java
@Configuration
@ComponentScan("com.xinghua24")
public class ApplicationConfig {

}
```