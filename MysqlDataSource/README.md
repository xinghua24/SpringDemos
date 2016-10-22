add mysql connector and spring-jdbc dependencies
```
dependencies {
	compile group: 'org.springframework', name: 'spring-jdbc', version: project.ext.springVersion
    
	compile group: 'mysql', name: 'mysql-connector-java', version: '6.0.2'

}
```

database.properties
```
jdbc.driverClassName=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/usersdb
jdbc.username=root
jdbc.password=password
```

create dataSource bean. The proeprties of the dataSource bean are set from database.properties file
```
    <context:property-placeholder location="classpath:database.properties"/>

    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="${jdbc.driverClassName}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>
    </bean>
```

