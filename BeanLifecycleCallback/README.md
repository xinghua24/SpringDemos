InitializingBean and DisposableBean interface can be used to perform actions upon bean initialization and disposal.

Using InitializingBean and DisposableBean interface are too intrusive, a better way is to use init-method and destroy-method attribute.

```xml
<bean id="foo" class="com.xinghua24.Foo" init-method="init" destroy-method="destroy" />
```

@PreDestroy and @PostConstruct annotation can also be used to specify init and destroy methods. Because they are annotations, you need to provide $lt;context:annotation-config /&gt; configuration in the configuration file.

```java
public class Bar {
    
    @PostConstruct
    public void init() {
        System.out.println("Bar init() called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bar destroy() called");
    }
}
```

You can also implement init and destroy method when doing java based configuration. Just provide initMethod and destroyMethod attribute to @Bean annotation.
