/**
 * 
 */
package com.orderinfoservice.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.orderinfoservice.entity.OrderData;
import com.orderinfoservice.exception.OrderNotFoundException;
import com.orderinfoservice.model.OrderItem;
import com.orderinfoservice.model.OrderReq;
import com.orderinfoservice.repository.OrderInfoServiceRepository;

/**
 * @author Suresh Ameda
 *
 */
@Service
public class OrderInfoService {

	private static final Logger LOGGER = LogManager.getLogger(OrderInfoService.class);

	@Autowired
	OrderInfoServiceRepository orderInfoServiceRepository;

	@Autowired
	OrderItemFeignClientProxy orderItemFeignClientProxy;

	/**
	 * Save order into Database
	 * 
	 * @param orders
	 * @return
	 */
	@Transactional
	public OrderData createOrder(@RequestBody OrderReq orderReq) {
		LOGGER.info("Enter into OrderInfoService :: createOrder {} ");
		Set<Long> orderItemIds = new HashSet<>();
		OrderData orderData = new OrderData();

		if (!orderReq.getOrderItemIds().isEmpty()) {

			orderItemIds = orderReq.getOrderItemIds();
			// Calling the another orderItemService MS to check weather the given orderItem
			// is present or not
			Set<OrderItem> orderItems = orderItemFeignClientProxy.getOrderItemByIds(orderItemIds);
			if (orderItems.size() != orderItemIds.size()) {
				throw new OrderNotFoundException();
			}

		}
		BeanUtils.copyProperties(orderReq, orderData);
		orderData.setOrderItemIds(orderItemIds);
		orderData.setOrderDate(new Date());
		LOGGER.info("Exited from OrderInfoService :: createOrder {} ");
		return orderInfoServiceRepository.save(orderData);
	}

	/**
	 * Get the all order details .
	 * 
	 * @return
	 */
	public List<OrderData> getAllOrders() {
		LOGGER.info("Fetching all the Order Details from DB ");
		return orderInfoServiceRepository.findAll();
	}

	/**
	 * getting the order details by orderId
	 * 
	 * @param id
	 * @return
	 */
	public OrderData getOrderById(long id) {
		LOGGER.info("Fetching the orderData for given orderId");
		return orderInfoServiceRepository.findById(id).orElseThrow(() -> new OrderNotFoundException());
	}

}
