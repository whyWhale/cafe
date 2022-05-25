package com.dungi.cafe.domain.shop.employee.Casher;

import java.util.List;

import com.dungi.cafe.domain.shop.MenuInventories;
import com.dungi.cafe.domain.shop.Order;
import com.dungi.cafe.domain.shop.Receipt;
import com.dungi.cafe.domain.shop.ReceiptAndCoffees;
import com.dungi.cafe.domain.shop.employee.Baristar;
import com.dungi.cafe.domain.shop.product.Coffee;

public class Casher {
	private final Baristar baristar;
	private final MenuInventories menuInventories;
	private final Machine machine;

	public Casher(Baristar baristar, MenuInventories menuInventories, Machine machine) {
		this.baristar = baristar;
		this.menuInventories = menuInventories;
		this.machine = machine;
	}

	public ReceiptAndCoffees takeOrder(Order order) {
		PurchaseHistory purchaseHistory = machine.calculate(order);

		Receipt receipt = new Receipt(order.getItems(), purchaseHistory.getTotalPrice(),purchaseHistory.getRest());

		List<Coffee> coffees = order.getItems().stream()
			.map(baristar::createCoffee)
			.toList();

		return new ReceiptAndCoffees(receipt, coffees);
	}
}
