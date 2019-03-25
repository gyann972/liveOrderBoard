package com.live.order.board.utils;

import java.util.Arrays;
import java.util.List;

import com.live.order.board.enumeration.OrderType;
import com.live.order.board.model.Order;

public final class OrderUtil {

	private OrderUtil() {
	}

	public static Order createOrder(long id, Double quantity, Double priceByKg, OrderType type) {
		return new Order(id, quantity, priceByKg, type);
	}

	public static List<Order> createListOrderBuyAndSell() {
		
		return Arrays.asList(
				createOrder(1L, 5.5, 200.0, OrderType.BUY),
				createOrder(2L, 10.0, 100.0, OrderType.BUY),
				createOrder(3L, 20.0, 100.0, OrderType.BUY),
				createOrder(4L, 5.5, 200.0, OrderType.SELL),
				createOrder(5L, 20.0, 300.0, OrderType.SELL),
				createOrder(6L, 20.0, 300.0, OrderType.SELL));
	}
}
