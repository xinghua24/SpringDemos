
run the following sql to initialize H2 database table
```sql
drop table if exists comment;
create table comment(id bigint primary key  auto_increment, author_name varchar(255), content varchar(500), post_id bigint, foreign key(post_id) references post(id));

drop table if exists post;
create table post(id bigint primary key  auto_increment, title varchar(255), content varchar(2000), visited int);
```

# Maven Dependency
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-r2dbc</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>io.r2dbc</groupId>
    <artifactId>r2dbc-h2</artifactId>
    <version>0.9.1.RELEASE</version>
</dependency>
```
R2DBC is a specification designed from the ground up for reactive programming with SQL databases.


properties
```properties
spring.r2dbc.url=r2dbc:h2:file:///~/testdb
spring.r2dbc.username=sa
spring.r2dbc.password=
```

DemoApplication.java 
```java
        postRepository.deleteAll().block();
        commentRepository.deleteAll().block();

        Post post1 = new Post();
        post1.setId(1l);
        post1.setTitle("post1");
        post1.setContent("This is post1!!!!");
        post1.setVisited(1);

        Comment comment1 = new Comment();
        comment1.setAuthorName("John Smith");
        comment1.setContent("This is comment1");

        try {
          postRepository.save(post1).subscribe();
          postRepository.findAll().collectList().block().forEach(System.out::println);
          Comment ret = commentRepository.save(comment1).block();
          commentRepository.findAll().collectList().block().forEach(System.out::println);
        } catch (Exception e) {
          e.printStackTrace();
        }
```



