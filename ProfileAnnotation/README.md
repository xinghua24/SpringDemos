Most projects have different environments like Dev, Test, Production. These profiles have different database connections, endpoint urls. 

Starting from Spring 4.0, @Profile can be apply at the class level or method level.

One way to activate a profile is to provide a JVM argument.

```
-Dspring.profiles.active=dev
```

@ActivateProfiles can be used to activate a profile when creating JUnit test.

Reference:
- [http://javapapers.com/spring/profile-annotation-improvements-in-spring-4/](http://javapapers.com/spring/profile-annotation-improvements-in-spring-4/)