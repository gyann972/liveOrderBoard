/**
 * 
 */
package com.live.order.board.service;

import com.live.order.board.model.Order;

/**
 * @author YaYa
 *
 */
public interface LiveOrderBoardService {
	public void register(Order order);
	public void cancel(Order order);
	public String orderSummary();
}
