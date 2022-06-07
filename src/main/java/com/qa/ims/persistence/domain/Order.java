package com.qa.ims.persistence.domain;

import java.util.Objects;

//import Customer;

public class Order {
	
	private Long orderId;
	private Long customerId;
	
	
	public Order() {
		super();
	}

	
	public Order(Long customerId) {
		super();
		this.customerId = customerId;
	}



	public Order(Long orderId, Long customerId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
	}


	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}


	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}


	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(customerId, orderId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Order other = (Order) obj;
		if (getOrderId() == null) {
			if (other.getOrderId() != null)
	  			return false;
		} else if (!getOrderId().equals(other.getOrderId()))
			return false;
		
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}
	
	
	
	
	
}
