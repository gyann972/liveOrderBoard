/**
 * 
 */
package com.live.order.board.dao;

import java.util.List;

import com.live.order.board.model.Order;

/**
 * @author YaYa
 *
 */
public interface OrderDao {
	
	public void save(Order order);
	
	public List<Order> getAll();
	
	public void delete(Order order);
	
	public Order get(long id);
}
