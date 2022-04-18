
# Postgres Setup
run_postgres.sh - used to start Postgres database.
```sh
#!/bin/bash
########################
# run two containers at network mynet
# * postgres at port 5432
# * adminer at port 5555. Open browser and go to http://localhost:5555/?pgsql=postgres&username=postgres&db=postgres to access adminer
########################
docker network inspect mynet>/dev/null 2>&1 || docker network create -d bridge mynet
docker run --name postgres --network mynet -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres
docker run --name adminer --network mynet -p 5555:8080 -d adminer
```

# Pom.xml
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

# Database Connection
application.properties file contains database connection info. Additional properties are available to disable flyway migration or switch off the location checking.
```properties
spring.datasource.url= jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=validate
```

# Migration Script
The migrations are scripts in the form `V<VERSION>__<NAME>.sql`

V1__init.sql
```sql
CREATE TABLE IF NOT EXISTS joke (
	jokeid  SERIAL,
	content varchar(255) NOT NULL,
	PRIMARY KEY(jokeid)
)
```

# Difference between Liquibase and Flyway
https://www.baeldung.com/liquibase-vs-flyway

* Flyway uses SQL for defining a change. On the other hand, Liquibase provides flexibility to specify a change in different formats including SQL such as XML, YAML, and JSON. 
* Both can undo change
* Although both the tools are strongly Java Oriented, Only Flyway provides Java-based migration. 
* Liquibase allows users to take a snapshot of the current state of the database. 
* Liquibase offers an added feature called pre-conditions. Preconditions allow users to apply changes based on the current state of the database. A changeset will only execute if it passes these preconditions. Flyway on the other hand doesn't support this. 

Reference
* [Execute Flyway Database Migrations on Startup](https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/html/howto-database-initialization.html#howto-execute-flyway-database-migrations-on-startup)
* [Flyway sample](https://github.com/spring-projects/spring-boot/tree/v2.1.0.RELEASE/spring-boot-samples/spring-boot-sample-flyway)