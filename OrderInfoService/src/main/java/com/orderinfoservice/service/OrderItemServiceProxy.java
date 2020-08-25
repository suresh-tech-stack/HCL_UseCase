package com.orderinfoservice.service;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orderinfoservice.model.OrderData;

/**
 * 
 * @author Suresh Ameda
 *
 *         This class is inter service communication between orderitemservice
 */
@FeignClient(url = "http://orderitemservice/OrderItem/", name = "orderitemservice")
public interface OrderItemServiceProxy {

	@RequestMapping("/getOrderItems")
	public Collection<OrderData> getOrdersItems();

	@PutMapping("/saveOrderItem")
	public void saveOrderItem();
}