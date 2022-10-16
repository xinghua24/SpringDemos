package com.xinghua24.CollectionInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean
  public Item myNewMac() {
    return new Item("New Macbook Pro", "My super new MBP");
  }

  @Bean
  public Item myNewPhone() {
    return new Item("New IPhone", "My New IPhone");
  }
}
