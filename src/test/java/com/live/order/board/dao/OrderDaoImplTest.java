/**
 * 
 */
package com.live.order.board.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.live.order.board.enumeration.OrderType;
import com.live.order.board.model.Order;
import com.live.order.board.utils.OrderUtil;

/**
 * @author YaYa
 *
 */
public class OrderDaoImplTest {

	private OrderDaoImpl orderDaoImpl;
	private Order testOrder = OrderUtil.createOrder(1L, 5.4, 2000.0, OrderType.BUY);

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		orderDaoImpl = new OrderDaoImpl();
	}

	@Test
	public void saveNullOrder() {
		orderDaoImpl.save(null);
		assertTrue(orderDaoImpl.getAll().isEmpty());
	}
	
	@Test
	public void saveAnOrderAlreadyPresent() {
		orderDaoImpl.save(testOrder);
		orderDaoImpl.save(testOrder);
		assertTrue(orderDaoImpl.getAll().size() == 2);
	}
	
	@Test
	public void getOrderNominalCase() {
		orderDaoImpl.save(testOrder);
		assertEquals(testOrder, orderDaoImpl.get(testOrder.getUserId()));
	}

	@Test
	public void getNonExistedOrder() {
		assertNull(orderDaoImpl.get(testOrder.getUserId()));
	}

	@Test
	public void getAllOrdersEmptyDB() {
		assertTrue(orderDaoImpl.getAll().isEmpty());
	}

	@Test
	public void getAllOrders() {
		orderDaoImpl.save(testOrder);
		assertFalse(orderDaoImpl.getAll().isEmpty());
	}

	@Test
	public void deleteAnOrder() {
		orderDaoImpl.save(testOrder);
		orderDaoImpl.delete(testOrder);
		
		assertTrue(orderDaoImpl.getAll().isEmpty());
	}
	
	@Test
	public void deleteNonExistedOrder() {
		orderDaoImpl.delete(testOrder);
		
		assertTrue(orderDaoImpl.getAll().isEmpty());
	}

	
}
