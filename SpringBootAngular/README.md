Setup Spring Boot application as backend and Angular as frontend in a single repository

First generate Spring Boot application. 

Then generate frontend application inside Spring Boot application. In this sample repo, I use 'ui' as project name.

Modify ui project to build to ui/dist destination

Use maven-resources-plugin to move UI output to src/main/resources/static folder. Spring Boot serves this project by default.
```xml
<plugin>
    <artifactId>maven-resources-plugin</artifactId>
    <executions>
        <execution>
            <id>copy-resources</id>
            <phase>validate</phase>
            <goals>
                <goal>copy-resources</goal>
            </goals>
            <configuration>
                <outputDirectory>${basedir}/src/main/resources/static/</outputDirectory>
                <resources>
                    <resource>
                        <directory>ui/dist/</directory>
                        <filtering>true</filtering>
                    </resource>
                </resources>
            </configuration>
        </execution>
    </executions>
</plugin>
```

# Development
For development, you can run both projects independently.

# Production Build
For production build, go to ui project first, run `npm run build` to generate ui output to ui/dest folder. 
Then run `mvn package` command to generate jar output. The output jar file will have ui project in it because 
mvn-resources-plugin copy ui resources to project resources folder