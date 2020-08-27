/**
 * 
 */
package com.orderinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderinfoservice.entity.OrderData;

/**
 * @author Suresh Ameda
 *
 */
public interface OrderInfoServiceRepository extends JpaRepository<OrderData, Long> {

}
