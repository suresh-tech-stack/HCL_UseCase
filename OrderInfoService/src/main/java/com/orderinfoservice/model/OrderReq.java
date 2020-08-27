package com.orderinfoservice.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Suresh Ameda
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderReq {

	@NotNull
	@Size(min = 2, message = "Name should be atlease 2 characters ")
	private String customerName;

	@NotNull
	private String shippingAddress;

	@NotNull
	public List<OrderItem> orderItem;

	@NotNull
	private double totalPrice;

}
