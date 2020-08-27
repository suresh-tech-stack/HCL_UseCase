package com.orderinfoservice;

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
public class OrderInfoServiceApplication {

    private static final Logger LOGGER = LogManager.getLogger(OrderInfoServiceApplication.class);
	public static void main(String[] args) {
		 LOGGER.info(" :::::  Started OrderInfoServiceApplication :::::: ");
		SpringApplication.run(OrderInfoServiceApplication.class, args);
	}

}
