package com.dungi.cafe.domain.shop.employee.Casher;

import com.dungi.cafe.domain.exterior.Card;
import com.dungi.cafe.domain.exterior.Pay;
import com.dungi.cafe.domain.shop.Order;
import com.dungi.cafe.domain.shop.product.Items;

public class Machine {
	public PurchaseHistory calculate(Order order) {
		Integer totalPrice = order.getItems().stream()
			.map(Items::getPrice)
			.reduce(0, Integer::sum);

		Pay pay = order.getPay();

		int rest=pay.deduct(totalPrice);

		return new PurchaseHistory(rest,totalPrice);
	}
}
