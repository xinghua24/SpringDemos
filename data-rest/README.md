
# Spring Data Rest
Spring Data Rest Exposes Spring Data repositories over REST via Spring Data.

## Maven Dependency
Spring Data Rest Hal Explorer allows users to browse Spring Data REST repositories in your browser.
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.data</groupId>
	<artifactId>spring-data-rest-hal-explorer</artifactId>
</dependency>
```

## Repository
By default, all public Spring Data repositories are used to expose HTTP resources as described in [Repository resources](https://docs.spring.io/spring-data/rest/docs/current/reference/html/#repository-resources).


The @RepositoryRestResource **optional** annotation is used to customize the REST endpoint. 
```java
@RepositoryRestResource(collectionResourceRel = "products", path="products")
public interface ProductRepository extends JpaRepository<Product, Long> {
}
```

open http://localhost:8080 to use HAL Explorer to interact with the endpoints.

## Reference
* [Baeldung Introduction to Spring Data REST](https://www.baeldung.com/spring-data-rest-intro)
* [Spring Data REST REference Guide](https://docs.spring.io/spring-data/rest/docs/current/reference/html)