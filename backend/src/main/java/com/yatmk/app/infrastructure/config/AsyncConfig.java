package com.yatmk.app.infrastructure.config;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.yatmk.app.infrastructure.config.properties.AppAsyncProperties;

import lombok.RequiredArgsConstructor;

@EnableAsync
@Configuration
@RequiredArgsConstructor
public class AsyncConfig {

  private final AppAsyncProperties appAsyncProperties;

  @Bean(name = "taskExecutor")
  public TaskExecutor getTaskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setQueueCapacity(appAsyncProperties.getQueueCapacity());
    executor.setCorePoolSize(appAsyncProperties.getCorePoolSize());
    executor.setMaxPoolSize(appAsyncProperties.getMaximumPoolSize());
    executor.setThreadNamePrefix("abbAgiosThread-");
    executor.initialize();
    return executor;
  }

  @Bean(name = "periodicAutomaticSemaphore")
  public Semaphore getPeriodicAutomaticSemaphore() {

    return new Semaphore(1);
  }

  @Bean(name = "periodicManuelSemaphore")
  public Semaphore getPeriodicManuelSemaphore() {

    return new Semaphore(1);
  }

  @Bean(name = "onDemandeSemaphore")
  public Semaphore getOnDemandeSemaphore() {

    return new Semaphore(1);
  }

  @Bean(name = "semaphoreStore")
  public Map<Semaphore, Boolean> getSemaphoreStore(Semaphore periodicAutomaticSemaphore,
      Semaphore periodicManuelSemaphore, Semaphore onDemandeSemaphore) {
    Map<Semaphore, Boolean> map = new HashMap<>();
    map.put(onDemandeSemaphore, Boolean.FALSE);
    map.put(periodicAutomaticSemaphore, Boolean.FALSE);
    map.put(periodicManuelSemaphore, Boolean.FALSE);
    return map;

  }

}