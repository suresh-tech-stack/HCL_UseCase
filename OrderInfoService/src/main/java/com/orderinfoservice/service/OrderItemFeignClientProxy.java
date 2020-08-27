package com.orderinfoservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.orderinfoservice.model.OrderItem;
import com.orderinfoservice.model.OrderReq;

/**
 * 
 * @author Suresh Ameda
 *
 *         This class is inter service communication between orderitemservice
 */
@FeignClient(name = "http://orderitemservice/OrderItemReq/")
public interface OrderItemFeignClientProxy {

	@GetMapping("/retriveOrderItem")
	public List<OrderReq> getAllOrderItems();

	@PostMapping("/placeOrderItem")
	public OrderItem saveOrderItem( @RequestBody OrderItem orderItem);

	@GetMapping("/orderItemById")
	public OrderItem getOrderItemById(@RequestParam("id")long id);
}