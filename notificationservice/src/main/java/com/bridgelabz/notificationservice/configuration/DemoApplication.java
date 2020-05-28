package com.bridgelabz.notificationservice.configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class DemoApplication 
{
  @Bean
   public RestTemplate getRestTemplate() {
     return new RestTemplate();
   }
}
