package com.orderitemservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderitemservice.entity.OrderItem;
import com.orderitemservice.exception.OrderItemNotFoundException;
import com.orderitemservice.model.OrderItemReq;
import com.orderitemservice.repository.OrderItemRepo;

/**
 * 
 * @author Suresh Ameda
 *
 */

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepo orderItemRepository;

	/**
	 * Get all the order item details
	 * 
	 * @return
	 */
	public List<OrderItem> getAllorderItems() {
		List<OrderItem> orderItemReq = new ArrayList<>();
		orderItemReq = orderItemRepository.findAll();
		return orderItemReq;
	}

	/**
	 * Save the orderItemdata into Database.
	 * 
	 * @param orderItemReq
	 */
	public OrderItem addOrderItem(OrderItemReq orderItemReq) {
		OrderItem orderItem = new OrderItem();
		BeanUtils.copyProperties(orderItemReq, orderItem);
		OrderItem placedOrderItem = orderItemRepository.save(orderItem);
		return placedOrderItem;
	}

	/**
	 * get the order item details by orderId
	 * 
	 * @param id
	 * @return
	 */
	public OrderItem getOrderItemById(long id) {

		return orderItemRepository.findById(id).orElseThrow(() -> new OrderItemNotFoundException());
	}
}