/**
 * 
 */
package com.orderitemservice.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderitemservice.entity.OrderItem;

/**
 * @author Suresh Ameda
 *
 */

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

	List<OrderItem> findAllByProductCodeIn(Set<Long> productCode);

}
