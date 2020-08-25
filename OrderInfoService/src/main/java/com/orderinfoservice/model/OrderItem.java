/**
 * 
 */
package com.orderinfoservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Suresh Ameda
 *
 */
@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 
	private long productCode;
	
	private String productName;
	
	private int productQuantity;

	/**
	 * @return the productCode
	 */
	public long getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productQuantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}

	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderItem [productCode=");
		builder.append(productCode);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", productQuantity=");
		builder.append(productQuantity);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
