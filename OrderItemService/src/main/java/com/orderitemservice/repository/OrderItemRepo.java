/**
 * 
 */
package com.orderitemservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderitemservice.entity.OrderItem;

/**
 * @author Suresh Ameda
 *
 */

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

}
