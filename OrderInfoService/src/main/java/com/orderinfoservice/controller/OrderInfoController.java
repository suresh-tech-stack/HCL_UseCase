package com.orderinfoservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderinfoservice.entity.OrderData;
import com.orderinfoservice.model.OrderReq;
import com.orderinfoservice.service.OrderInfoService;

/**
 * 
 * @author Suresh Ameda
 *
 */
/**
 * In this class have the all the methods related to OrderService
 */
@RestController
@RequestMapping("/Order")
public class OrderInfoController {

	private static final Logger LOGGER = LogManager.getLogger(OrderInfoController.class);

	@Autowired
	OrderInfoService orderInfoService;

	/**
	 * It will return the all orders Data
	 * 
	 * @return OrderData
	 */
	@GetMapping("")
	public ResponseEntity<List<OrderData>> getAllOrders() {
		LOGGER.info("Enter into  OrderInfoController : getAllOrders method {} ");
		List<OrderData> orderDataList = new ArrayList<OrderData>();
		orderDataList = orderInfoService.getAllOrders();
		return new ResponseEntity<>(orderDataList, HttpStatus.OK);
	}

	/**
	 * Save the OrderData into Database with given order request
	 * 
	 * @param orderReq
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<OrderData> saveOrder(@Valid @RequestBody OrderReq orderReq) {
		LOGGER.info("Enter into  OrderInfoController : saveOrder method {} ");

		OrderData placedOrder = orderInfoService.createOrder(orderReq);
		return new ResponseEntity<>(placedOrder, HttpStatus.OK);
	}

	/**
	 * getting the order details by orderId
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderData> getOrderItemById(@PathVariable("id") long id) {
		LOGGER.info("Enter into  OrderInfoController : getOrderItemById method {} ");
		OrderData orderData = orderInfoService.getOrderById(id);
		return new ResponseEntity<>(orderData, HttpStatus.OK);
	}

}
