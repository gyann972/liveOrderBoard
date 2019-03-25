/**
 * 
 */
package com.live.order.board.model;

import com.live.order.board.enumeration.OrderType;

/**
 * @author YaYa
 *
 */
public class Order {

	private long userId;

	private Double quantity;

	private Double priceByKg;

	private OrderType type;

	/**
	 * 
	 */
	public Order() {
		super();
	}

	public Order(long userId, Double quantity, Double priceByKg, OrderType type) {
		super();
		this.userId = userId;
		this.quantity = quantity;
		this.priceByKg = priceByKg;
		this.type = type;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getPriceByKg() {
		return priceByKg;
	}

	public void setPriceByKg(Double priceByKg) {
		this.priceByKg = priceByKg;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + ((priceByKg == null) ? 0 : priceByKg.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (userId != other.userId)
			return false;
		if (priceByKg == null) {
			if (other.priceByKg != null)
				return false;
		} else if (!priceByKg.equals(other.priceByKg))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
