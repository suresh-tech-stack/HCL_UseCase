/**
 * 
 */
package com.orderinfoservice.model;

import javax.validation.constraints.NotNull;

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
public class OrderItem {

	@NotNull
	private long productCode;

	@NotNull
	private String productName;

	@NotNull
	private int productQuantity;

}
