/**
 * 
 */
package com.orderitemservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Suresh Ameda
 *
 */
@Entity
@Table(name = "ORDER_ITEMS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;

	private long productCode;

	private String productName;

	private int productQuantity;

}
