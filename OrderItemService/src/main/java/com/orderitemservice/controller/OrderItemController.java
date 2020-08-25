/**
 * 
 */
package com.orderitemservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderitemservice.model.OrderItem;
import com.orderitemservice.service.OrderItemService;

/**
 * @author Suresh Ameda
 *
 */

@RestController
@RequestMapping("/OrderItem")
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;
	/**
	 * This method will return all the order details .
	 * @return
	 */
	@GetMapping("/getOrderItems")
	public List getAllOrderItems() {
		System.out.println("Received Request ....");
		return orderItemService.getAllorderItems();
	}
	/**
	 * This method will save the order into Database 
	 * @param orderItem
	 */
	@PostMapping("/saveOrderItem")
	public void saveOrderItem(@RequestBody OrderItem orderItem) {
		System.out.println("Received Request ....");
		orderItemService.addOrderItem(orderItem);
	}

}
