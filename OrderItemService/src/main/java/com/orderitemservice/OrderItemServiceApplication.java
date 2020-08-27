package com.orderitemservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * @author Suresh Ameda
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class OrderItemServiceApplication {

	private static final Logger LOGGER = LogManager.getLogger(OrderItemServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info(".... OrderItemServiceApplication Started  ....");
		SpringApplication.run(OrderItemServiceApplication.class, args);
	}

}
