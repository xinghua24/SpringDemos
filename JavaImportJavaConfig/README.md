BazConfig.java is another java config file. Use **@Import** annotation to import java config file.

```java
@Configuration
@ComponentScan("com.xinghua24")
@Import(BazConfig.class)
public class ApplicationConfig {
    @Autowired
    private Baz baz;
}
```

