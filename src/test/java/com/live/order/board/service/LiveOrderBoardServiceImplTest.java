/**
 * 
 */
package com.live.order.board.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.live.order.board.dao.OrderDao;
import com.live.order.board.enumeration.OrderType;
import com.live.order.board.model.Order;
import com.live.order.board.utils.OrderUtil;

/**
 * @author YaYa
 *
 */
public class LiveOrderBoardServiceImplTest {

	private LiveOrderBoardServiceImpl liveOrderBoard;
	private OrderDao orderDao;
	private Order orderTest = OrderUtil.createOrder(1L, 7.8, 50.0, OrderType.BUY);
	
	public LiveOrderBoardServiceImplTest() {
		super();
		orderDao = mock(OrderDao.class);
		liveOrderBoard = new LiveOrderBoardServiceImpl(orderDao);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRegister() {

		Mockito.doAnswer((i) -> {
			Order argument = (Order)i.getArgument(0);
			assertTrue(orderTest.equals(argument));
			return null;
		}).when(orderDao).save(Mockito.any(Order.class));
		
		liveOrderBoard.register(orderTest);
				
		verify(orderDao).save(Mockito.any(Order.class));
		
	}
	
	@Test
	public void testCancel() {

		Mockito.doAnswer((i) -> {
			Order argument = (Order)i.getArgument(0);
			assertTrue(orderTest.equals(argument));
			return null;
		}).when(orderDao).delete(Mockito.any(Order.class));
		
		liveOrderBoard.cancel(orderTest);
				
		verify(orderDao).delete(Mockito.any(Order.class));
		
	}
	
	@Test
	public void testOrderSummaryBuyAndSell() {
		when(orderDao.getAll()).thenReturn(OrderUtil.createListOrderBuyAndSell());
		
		String summary = liveOrderBoard.orderSummary();
		String expectedBuyOrdersSummary = "BUY:\n"
				+ "30.0 kg for £100.0\n"
				+ "5.5 kg for £200.0\n";
		String expectedSellOrdersSummary = "SELL:\n"
		+ "40.0 kg for £300.0\n"
		+ "5.5 kg for £200.0\n";
				
		assertTrue(summary.contains(expectedBuyOrdersSummary));
		assertTrue(summary.contains(expectedSellOrdersSummary));
		
		verify(orderDao).getAll();
	}
	
	@Test
	public void testOrderSummaryWhenNoOrders() {
		when(orderDao.getAll()).thenReturn(Collections.emptyList());
		
		String summary = liveOrderBoard.orderSummary();
				
		assertTrue(summary.equals(""));
		
		verify(orderDao).getAll();
	}

}
