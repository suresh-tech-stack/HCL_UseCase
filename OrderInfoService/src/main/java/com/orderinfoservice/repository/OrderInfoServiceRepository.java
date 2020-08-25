/**
 * 
 */
package com.orderinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderinfoservice.model.OrderData;

/**
 * @author Suresh Ameda
 *
 */
@Repository
public interface OrderInfoServiceRepository extends JpaRepository<OrderData, Long> {

}
