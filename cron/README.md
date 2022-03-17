
# Enable Scheduling
To enable Scheduling annotation, add `@EnableScheduling` to one of your `@Configuration` class.
```java
@Configuration
@EnableScheduling
public class AppConfig {
}
```

# @Scheduled Annotation
## Fix rate
we can execute a task on a fixed period. add `@Scheduled` annotation and set fixedRate attribute.
```java
	@Scheduled(fixedRate = 2000L)
	public void someJob() throws InterruptedException {
		System.out.println("Current Time is " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}
```

## Delay
fixedDelay - Execute the annotated method with a fixed period between the end of the last invocation and the start of the next.
```java
	@Scheduled(initialDelay = 1000L, fixedDelay = 2000L)
	public void someJob() throws InterruptedException {
		System.out.println("Current Time is " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}
```

## Cron Expression
Cron expression used by `@Scheduled` is NOT the same as cron in Linux. There are 6 fields in a cron expression. Each has its own range of valid values. 

For testing cron expressions check [https://crontab.guru/](https://crontab.guru/). Note that second is not in standard Linux Cron.

cron meaning and valid values
```
 ┌───────────── second (0-59)
 │ ┌───────────── minute (0 - 59)
 │ │ ┌───────────── hour (0 - 23)
 │ │ │ ┌───────────── day of the month (1 - 31)
 │ │ │ │ ┌───────────── month (1 - 12) (or JAN-DEC)
 │ │ │ │ │ ┌───────────── day of the week (0 - 7)
 │ │ │ │ │ │          (0 or 7 is Sunday, or MON-SUN)
 │ │ │ │ │ │
 * * * * * *
```
Please see [Cron Expression Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#scheduling-cron-expression) for more details and examples.

To run at 8:00, 8:30, 9:00 9:30 every day
```java
	@Scheduled(cron = "* */30 8-9 * * *", zone = "America/New_York")
	public void someJob() throws InterruptedException {
		System.out.println("Current Time is " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}
```

To run at 11:00PM every day
```java
	@Scheduled(cron = "0 0 23 * * *", zone = "America/New_York")
	public void someJob() throws InterruptedException {
		System.out.println("Current Time is " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}
```

To avoid hard coding the cron value, we can use Spring Expression to externalize the configuration of the task.
```java
	@Scheduled(cron = "${myTask.cron}", zone = "America/New_York")
	public void someJob() throws InterruptedException {
		System.out.println("Current Time is " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}
```

application.properties file
```properties
myTask.cron=*/10 * 0 * * *
```


# Setting Scheduler's pool size
The default size is 1
```
spring.task.scheduling.pool.size=5
```

# ShedLock
[ShedLock](https://github.com/lukas-krecan/ShedLock) makes sure that your scheduled tasks are executed at most once at the same time. If a task is being executed on one node, it acquires a lock which prevents execution of the same task from another node (or thread). Please note, that if one task is already being executed on one node, execution on other nodes does not wait, it is simply skipped.

# Reference
* [Spring Documentation of Scheduling](https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#scheduling-annotation-support)
* [@Scheduled annotation](https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#scheduling-annotation-support-scheduled)
* [Cron Expression](https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#scheduling-cron-expression)
* [Baeldung @Scheduled Annotation in Spring](https://www.baeldung.com/spring-scheduled-tasks)
* [Youtube @Scheduled crash course](https://www.youtube.com/watch?v=92-qLIxv0JA)