**@Configuration** tells Spring that this class is used as configuration file. Beans will be annotated with **@Bean**

use **AnnotationConfigApplicationContext** to get the spring container. The constructor of AnnotationConfigApplicationContext takes a class.

Please note that even though dependencies are retrieve by method calls in the config file, the beans still have their specific scope.

```java
Bar bar1 = bar();
Bar bar2 = bar();
System.out.println("bar1 == bar2? " + (bar1 == bar2));  //true
```