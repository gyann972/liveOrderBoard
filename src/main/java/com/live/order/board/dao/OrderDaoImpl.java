/**
 * 
 */
package com.live.order.board.dao;

import java.util.ArrayList;
import java.util.List;

import com.live.order.board.model.Order;

/**
 * @author YaYa
 *
 */
public class OrderDaoImpl implements OrderDao {
	
	private List<Order> database;
	
	/**
	 * 
	 */
	public OrderDaoImpl() {
		database = new ArrayList<>();
	}

	@Override
	public void save(Order order) {
		if (order != null) {
				database.add(order);
		}
	}

	@Override
	public List<Order> getAll() {
		return database;
	}

	@Override
	public void delete(Order order) {
		database.remove(order);
	}

	@Override
	public Order get(long id) {
		return database.stream().filter(o -> o.getUserId() == id).findFirst().orElse(null);
	}

}
