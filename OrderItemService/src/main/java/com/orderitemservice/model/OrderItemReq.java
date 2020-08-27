/**
 * 
 */
package com.orderitemservice.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
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
public class OrderItemReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private long productCode;

	@NotNull
	private String productName;

	@NotNull
	private int productQuantity;

}
