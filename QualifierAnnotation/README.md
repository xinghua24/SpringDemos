@Autowired and @Qualifier are often used together to remove confusion about which bean is used for wiring. By default, @Autowired inject beans by Type, not by name.

If there are two beans of the same type, then autowiring cannot determine which bean to use. In this situation, @Qualifier can be used to distinguish them.

Qualifier can be used in constructor, setter or method.

```java
    @Autowired
    public Foo(@Qualifier("barA") Bar bar) {
        super();
        this.bar = bar;
    }
```

```java
    @Autowired
    public void setDependencies(@Qualifier("barB") Bar bar) {
        this.bar = bar;
    }
```

```java
    @Autowired
    @Qualifier("barB")
    public void setBar( Bar bar) {
        this.bar = bar;
    }
```