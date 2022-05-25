package com.dungi.cafe.domain.shop;

import java.util.List;

import com.dungi.cafe.domain.shop.product.Coffee;

public class ReceiptAndCoffees {
	private Receipt receipt;
	private List<Coffee> coffees;

	public ReceiptAndCoffees(Receipt receipt, List<Coffee> coffees) {
		this.receipt = receipt;
		this.coffees = coffees;
	}

	@Override
	public String toString() {
		return "ReceiptAndCoffees{" +
			"receipt=" + receipt.toString() +
			", coffees=" + coffees.toString() +
			'}';
	}
}
