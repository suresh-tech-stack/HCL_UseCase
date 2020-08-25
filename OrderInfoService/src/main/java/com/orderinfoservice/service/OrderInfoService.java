/**
 * 
 */
package com.orderinfoservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.orderinfoservice.model.OrderData;
import com.orderinfoservice.repository.OrderInfoServiceRepository;

/**
 * @author Suresh Ameda
 *
 */
@Service
public class OrderInfoService {

	@Autowired
	OrderInfoServiceRepository orderInfoServiceRepository;

	/**
	 * Save order into Database
	 * 
	 * @param orders
	 * @return
	 */
	public OrderData createOrder(@RequestBody OrderData orders) {
		return orderInfoServiceRepository.save(orders);
	}

	/**
	 * get the all order details .
	 * 
	 * @return
	 */
	public List<OrderData> getAllOrders() {
		return orderInfoServiceRepository.findAll();
	}

	/**
	 * get the order details by orderId
	 * 
	 * @param id
	 * @return
	 */
	public Optional<OrderData> getOrderById(long id) {
		return orderInfoServiceRepository.findById(id);
	}
}
