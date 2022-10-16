To Inject a List/Set, we can first define individual elements as Spring beans and Inject List/Set to the target bean.

App Configuration that defines two beans of type Item
```java
@Configuration
public class AppConfig {
  @Bean
  public Item myNewMac() {
    return new Item("New Macbook Pro", "My super new MBP");
  }

  @Bean
  public Item myNewPhone() {
    return new Item("New IPhone", "My New IPhone");
  }
}
```

Inject List/Set of Items. The beans defined of type Item will be added to the List/Set
```java
	@Component
	@AllArgsConstructor
	public class MyCommandLineRunner implements CommandLineRunner {
		private List<Item> items;

		@Override
		public void run(String... args) throws Exception {
			items.forEach(System.out::println);
		}
	}
```

Sample Output
```
Item(name=New Macbook Pro, description=My super new MBP)
Item(name=New IPhone, description=My New IPhone)
```


Reference:
- [Spring Injecting Collections](https://www.baeldung.com/spring-injecting-collections)