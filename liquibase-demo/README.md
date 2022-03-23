Spring Tips: Reliable Database Migrations with Liquibase and Spring Boot
https://youtu.be/YhicwD489xQ

Repo: https://github.com/spring-tips/liquibase

Initialize the database
```sql
-- Adminer 4.8.1 PostgreSQL 14.2 (Debian 14.2-1.pgdg110+1) dump

DROP TABLE IF EXISTS "articles";
DROP SEQUENCE IF EXISTS "Article_id_seq";
CREATE SEQUENCE "Article_id_seq" INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."articles" (
    "id" bigint DEFAULT nextval('"Article_id_seq"') NOT NULL,
    "title" character varying NOT NULL,
    "authored" timestamp NOT NULL,
    CONSTRAINT "Article_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "articles" ("id", "title", "authored") VALUES
(1,	'Liquibase is awesome',	'2022-03-20 22:49:10.988446'),
(2,	'I love Spring',	'2022-03-20 22:53:27.667624');

DROP TABLE IF EXISTS "comments";
DROP SEQUENCE IF EXISTS comment_id_seq;
CREATE SEQUENCE comment_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."comments" (
    "id" bigint DEFAULT nextval('comment_id_seq') NOT NULL,
    "comment" character varying NOT NULL,
    "article_id" bigint NOT NULL,
    CONSTRAINT "comment_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "comments" ("id", "comment", "article_id") VALUES
(1,	'First Comment!',	1),
(2,	'Second!',	1);

ALTER TABLE ONLY "public"."comments" ADD CONSTRAINT "comment_article_id_fkey" FOREIGN KEY (article_id) REFERENCES articles(id) NOT DEFERRABLE;

-- 2022-03-22 04:02:54.11112+00
```


update database using changelog.sql file
```
mvn liquibase:update
```

generate changelog from database
```
mvn liquibase:generateChangeLog -Dliquibase.outputChangeLogFile=src/main/resources/db/changelog/generatedchangelog.sql
```

rollback 1 changeset
```
mvn liquibase:rollback -Dliquibase.rollbackCount=1
```


diff command
```
mvn liquibase:diff \
-Dliquibase.diffChangeLogFile=diff.sql \
-Dliquibase.referenceUrl=jdbc:postgresql://XingMBP.local:5500/user \
-Dliquibase.referenceUsername=user \
-Dliquibase.referencePassword=pw \
-Dliquibase.referenceDriver=org.postgresql.Driver
```

spring native
```
mvn -DskipTests=true -Pnative clean package
```
