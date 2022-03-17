package com.xinghua24.cron;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class CronApplication {
	private static final Logger LOG = LoggerFactory.getLogger(CronApplication.class);

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(CronApplication.class, args);
	}

	@Scheduled(fixedRate = 2000L)
	public void someJob() throws InterruptedException {
		LOG.info("Current Time is " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}

	@Scheduled(fixedRate = 2000L)
	public void otherJob() throws InterruptedException {
		LOG.info("Current Time is " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}
}
