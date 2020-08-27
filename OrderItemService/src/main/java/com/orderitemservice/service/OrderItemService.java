package com.orderitemservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderitemservice.controller.OrderItemController;
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

	private static final Logger LOGGER = LogManager.getLogger(OrderItemService.class);

	@Autowired
	private OrderItemRepo orderItemRepository;

	/**
	 * Get all the order item details
	 * 
	 * @return
	 */
	public List<OrderItem> getAllorderItems() {
		LOGGER.info("Inside OrderItemService :: getAllorderItems Method {} ");
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
		LOGGER.info("Inside OrderItemService :: addOrderItem Method {} ");
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
		LOGGER.info("Inside OrderItemService :: getOrderItemById Method {} ");
		return orderItemRepository.findById(id).orElseThrow(() -> new OrderItemNotFoundException());
	}

	/**
	 * Get the orderItems based on orderItemIds
	 * 
	 * @param ids
	 * @return
	 */
	public Set<OrderItem> getOrderItemByIds(Set<Long> ids) {
		LOGGER.info("Inside OrderItemService :: getOrderItemByIds Method {} ");
		List<OrderItem> items = orderItemRepository.findAllByProductCodeIn(ids);
		return items.stream().collect(Collectors.toSet());

	}
}