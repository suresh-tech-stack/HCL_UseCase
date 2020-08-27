/**
 * 
 */
package com.orderinfoservice.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	@Getter
	@Setter
	private long productCode;

	@NotNull
	@Getter
	@Setter
	private String productName;

	@NotNull
	@Getter
	@Setter
	private int productQuantity;

}
