package com.dungi.cafe.domain.shop;

import java.util.List;

import com.dungi.cafe.domain.shop.product.Items;

public class Receipt {
	private List<Items> items;
	private int rest;
	private int totalPrice;

	public Receipt(List<Items> items, int totalPrice, int rest) {
		this.items = items;
		this.rest = rest;
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Receipt{" +
			"items=" + items.toString() +
			", rest=" + rest +
			", totalPrice=" + totalPrice +
			'}';
	}
}
