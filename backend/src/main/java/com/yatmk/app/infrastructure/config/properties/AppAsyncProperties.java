package com.yatmk.app.infrastructure.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Configuration
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app.async")
public class AppAsyncProperties {

  private Integer corePoolSize;

  private Integer maximumPoolSize;

  private Integer queueCapacity;

  private Integer keepAliveTime;

}
