/**
 * 
 */
package com.orderinfoservice.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		Set<Long> orderItemId = new HashSet<>();
		OrderItem savedOrderItem = null;
		OrderItem availableOrderItem = null;
		OrderData orderData = new OrderData();
		if (!orderReq.getOrderItem().isEmpty()) {
			for (OrderItem orderItem : orderReq.getOrderItem()) {
				try {
					availableOrderItem = orderItemFeignClientProxy.getOrderItemById(orderItem.getProductCode());
				} catch (Exception e) {
					if (availableOrderItem == null) {
						savedOrderItem = orderItemFeignClientProxy.saveOrderItem(orderItem);
						orderItemId.add(savedOrderItem.getProductCode());
					}
				}
			}
		}
		BeanUtils.copyProperties(orderReq, orderData);
		orderData.setOrderItemId(orderItemId);
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
		return orderInfoServiceRepository.findAll();
	}

	public OrderData getOrderById(long id) {
		return orderInfoServiceRepository.findById(id).orElseThrow(() -> new OrderNotFoundException());
	}

}
