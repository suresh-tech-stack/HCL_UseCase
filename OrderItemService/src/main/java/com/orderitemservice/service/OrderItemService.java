package com.orderitemservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderitemservice.model.OrderItem;
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
		List<OrderItem> orderItem = new ArrayList<>();
		orderItemRepository.findAll();
		return orderItem;
	}

	/**
	 * Save the orderItemdata into Database.
	 * 
	 * @param orderItem
	 */
	public void addOrderItem(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}

	/**
	 * Get the order items based on order item id
	 * 
	 * @param id
	 * @return
	 */
	public Optional<OrderItem> getOrderItemById(long id) {
		return orderItemRepository.findById(id);
	}
}