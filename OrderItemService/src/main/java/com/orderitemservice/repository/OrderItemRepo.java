/**
 * 
 */
package com.orderitemservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orderitemservice.model.OrderItem;

/**
 * @author Suresh Ameda
 *
 */

@Repository
public interface OrderItemRepo extends CrudRepository<OrderItem, Long> {

}
