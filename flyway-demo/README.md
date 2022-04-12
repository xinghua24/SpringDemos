

run_postgres.sh - used to start Postgres database.
```sh
#!/bin/bash
########################
# run two containers at network mynet
# * postgres at port 5432
# * adminer at port 5555. Open browser and go to http://localhost:5555/?pgsql=postgres&username=postgres&db=postgres to access adminer
########################
docker network create -d bridge  mynet
docker run --name postgres --network mynet -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres
docker run --name adminer --network mynet -p 5555:8080 -d adminer
```

To automatically run Flyway database migrations on startup, add the org.flywaydb:flyway-core to your classpath.

pom.xml - need to add database related dependencies and flyway-core dependency
```xml
<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<scope>runtime</scope>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
	<groupId>org.flywaydb</groupId>
	<artifactId>flyway-core</artifactId>
</dependency>
```

application.properties file contains database connection info. Additional properties are available to disable flyway migration or switch off the location checking.
```properties
spring.datasource.url= jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=validate
```

The migrations are scripts in the form `V<VERSION>__<NAME>.sql`

V1__init.sql
```sql
CREATE TABLE IF NOT EXISTS joke (
	jokeid  SERIAL,
	content varchar(255) NOT NULL,
	PRIMARY KEY(jokeid)
)
```



Reference
* [Execute Flyway Database Migrations on Startup](https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/html/howto-database-initialization.html#howto-execute-flyway-database-migrations-on-startup)
* [Flyway sample](https://github.com/spring-projects/spring-boot/tree/v2.1.0.RELEASE/spring-boot-samples/spring-boot-sample-flyway)