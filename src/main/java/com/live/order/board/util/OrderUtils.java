/**
 * 
 */
package com.live.order.board.util;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.live.order.board.constant.Constants;
import com.live.order.board.enumeration.OrderType;
import com.live.order.board.model.Order;

/**
 * @author YaYa
 *
 */
public class OrderUtils {

	public OrderUtils() {
		super();
	}

	public static String generateOrderSummary(List<Order> orders) {
		String summary = "";

		if (!orders.isEmpty()) {
			OrderType orderType = orders.get(0).getType();
			Map<Double, Double> qtyOrdersGroupByPrice = orders.stream()
					.collect(Collectors.groupingBy(Order::getPriceByKg, Collectors.summingDouble(Order::getQuantity)));

			List<Double> pricesByKgSorted;

			// Sort the list first then we apply another group by
			if (orderType.equals(OrderType.BUY)) {
				summary = Constants.BUY + Constants.COLON + Constants.NEW_LINE;
				pricesByKgSorted = qtyOrdersGroupByPrice.keySet().stream().sorted().collect(Collectors.toList());
			} else {
				summary = Constants.SELL + Constants.COLON + Constants.NEW_LINE;
				pricesByKgSorted = qtyOrdersGroupByPrice.keySet().stream().sorted(Comparator.reverseOrder())
						.collect(Collectors.toList());
			}

			for (Double priceByKg : pricesByKgSorted) {
				summary += qtyOrdersGroupByPrice.get(priceByKg) + " " + Constants.KG + " " + Constants.FOR + " "
						+ Constants.POUND_CURRENCY + priceByKg + Constants.NEW_LINE;
			}

		}

		return summary;

	}
}
