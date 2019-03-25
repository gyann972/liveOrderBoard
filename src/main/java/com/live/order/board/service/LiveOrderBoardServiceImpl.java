/**
 * 
 */
package com.live.order.board.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.live.order.board.dao.OrderDao;
import com.live.order.board.enumeration.OrderType;
import com.live.order.board.model.Order;
import com.live.order.board.util.OrderUtils;

/**
 * @author YaYa
 *
 */
public class LiveOrderBoardServiceImpl implements LiveOrderBoardService {

	private OrderDao orderDao;

	/**
	 * 
	 */
	public LiveOrderBoardServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void register(Order order) {
		orderDao.save(order);
	}

	@Override
	public void cancel(Order order) {
		orderDao.delete(order);
	}

	@Override
	public String orderSummary() {

		List<Order> allOrders = orderDao.getAll();

		// Extraction of orders by type
		Map<OrderType, List<Order>> ordersByType = allOrders.stream().collect(Collectors.groupingBy(Order::getType));

		String summary = "";

		for (List<Order> orders : ordersByType.values()) {
			summary += OrderUtils.generateOrderSummary(orders);
		}

		return summary;
	}

}
