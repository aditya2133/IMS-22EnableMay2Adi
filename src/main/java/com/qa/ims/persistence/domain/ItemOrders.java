package com.qa.ims.persistence.domain;

import java.util.Objects;

public class ItemOrders {

	private Long orderItemId;
	private Long orderId;
	private Long itemId;
	private Long itemQuantity;
	private Long itemTotal;
	
	
	public ItemOrders() {
		super();
	}


	public ItemOrders(Long orderId, Long itemId, Long itemQuantity) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
	}


	public ItemOrders(Long orderItemId, Long orderId, Long itemId, Long itemQuantity, Long itemTotal) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
		this.itemTotal=itemTotal;
	}

	public ItemOrders(Long orderItemId, Long orderId, Long itemId, Long itemQuantity) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
		
	}


	public ItemOrders(Long orderItemId, Long itemQuantity) {
		this.orderItemId = orderItemId;
		this.itemQuantity = itemQuantity;
	
	}
	public ItemOrders(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
	
	}

	/**
	 * @return the itemTotal
	 */
	public Long getItemTotal() {
		return itemTotal;
	}


	/**
	 * @param itemTotal the itemTotal to set
	 */
	public void setItemTotal(Long itemTotal) {
		this.itemTotal = itemTotal;
	}

	/**
	 * @return the orderItemId
	 */
	public Long getOrderItemId() {
		return orderItemId;
	}


	/**
	 * @param orderItemId the orderItemId to set
	 */
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
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
	 * @return the itemId
	 */
	public Long getItemId() {
		return itemId;
	}


	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}


	/**
	 * @return the itemQuantity
	 */
	public Long getItemQuantity() {
		return itemQuantity;
	}


	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	@Override
	public String toString() {
		return "ItemOrders [orderItemId=" + orderItemId + ", orderId=" + orderId + ", itemId=" + itemId
				+ ", itemQuantity=" + itemQuantity + ", itemTotal=" + itemTotal + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemQuantity, itemTotal, orderId, orderItemId);
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
		ItemOrders other = (ItemOrders) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(itemQuantity, other.itemQuantity)
				&& Objects.equals(itemTotal, other.itemTotal) && Objects.equals(orderId, other.orderId)
				&& Objects.equals(orderItemId, other.orderItemId);
	}
	
	
	
	
	
}
