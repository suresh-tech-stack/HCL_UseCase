package com.orderinfoservice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.ElementCollection;
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
@Table(name = "ORDER_DATA")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;

	private String customerName;

	private Date orderDate;

	private String shippingAddress;

	@ElementCollection(targetClass = Long.class)
	public Set<Long> orderItemIds;

	private double totalPrice;

}
