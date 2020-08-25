package com.orderinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * @author Suresh Ameda
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderInfoServiceApplication.class, args);
	}

}
