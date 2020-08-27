/**
 * 
 */
package com.orderitemservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderitemservice.entity.OrderItem;
import com.orderitemservice.model.OrderItemReq;
import com.orderitemservice.service.OrderItemService;

/**
 * @author Suresh Ameda
 *
 */

@RestController
@RequestMapping("/OrderItemReq")
public class OrderItemController {

	private static final Logger LOGGER = LogManager.getLogger(OrderItemController.class);

	@Autowired
	OrderItemService orderItemService;

	/**
	 * This method will return all the order details .
	 * 
	 * @return
	 */
	@GetMapping("/retriveOrderItem")
	public ResponseEntity<List<OrderItem>> getAllOrderItems() {
		LOGGER.info("Received Request ....");
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		orderItemList = orderItemService.getAllorderItems();
		return new ResponseEntity<>(orderItemList, HttpStatus.OK);
	}

	/**
	 * This method will save the order into Database
	 * 
	 * @param orderItemReq
	 */
	@PostMapping("/placeOrderItem")
	public ResponseEntity<OrderItem> saveOrderItem(@Valid @RequestBody OrderItemReq orderItemReq) {
		LOGGER.info("Received Request ....");
		OrderItem placedOrderItem = orderItemService.addOrderItem(orderItemReq);
		return new ResponseEntity<>(placedOrderItem, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/orderItemById")
	public ResponseEntity<OrderItem> getOrderItemById(@RequestParam("id") long id) {
		System.out.println("Product Controller: FindProductById: " + id);
		OrderItem orderItemReq = orderItemService.getOrderItemById(id);
		return new ResponseEntity<>(orderItemReq, HttpStatus.OK);
	}

}
