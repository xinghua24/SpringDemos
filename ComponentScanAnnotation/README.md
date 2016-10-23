@ComponentScan can be used to scan package. it has the same effect as component-scan element in XML configuration file. If no base package is provided, then it will use the current package as the package to scan.

```java
@Configuration
@ComponentScan("com.xinghua24")
public class ApplicationConfig {

}
```