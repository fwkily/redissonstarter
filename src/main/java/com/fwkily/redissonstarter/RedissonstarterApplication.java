package com.fwkily.redissonstarter;

import org.redisson.api.RedissonClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class RedissonstarterApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RedissonstarterApplication.class, args);
		RedissonClient bean = context.getBean(RedissonClient.class);
		System.out.println(bean.toString());
	}

}
