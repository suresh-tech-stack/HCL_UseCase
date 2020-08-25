package com.orderinfoservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderinfoservice.model.OrderData;
import com.orderinfoservice.service.OrderInfoService;
import com.orderinfoservice.service.OrderItemServiceProxy;

/**
 * 
 * @author Suresh Ameda
 *
 */
@RestController
@RequestMapping("/Order")
public class OrderInfoController {

	@Autowired
	OrderInfoService orderInfoService;

	@Autowired
	OrderItemServiceProxy orderItemServiceProxy;

	@GetMapping("/getOrders")
	public ResponseEntity<List<OrderData>> getAllOrders() {
		System.out.println("In ProductService:-> Controller ");
		List<OrderData> orderDataList = new ArrayList<OrderData>();

		orderDataList = orderInfoService.getAllOrders();

		return new ResponseEntity<List<OrderData>>(orderDataList, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/createOrder")
	public ResponseEntity<OrderData> saveOrder(@RequestBody OrderData orders) {
		orderInfoService.createOrder(orders);
		System.out.println("Enter Product Controller....>");
		return new ResponseEntity<OrderData>(orders, new HttpHeaders(), HttpStatus.OK);
	}

}
