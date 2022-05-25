package com.dungi.cafe.domain.shop;

import java.util.List;

import com.dungi.cafe.domain.exterior.Pay;
import com.dungi.cafe.domain.shop.product.Items;

public class Order {
	private List<Items> items;
	private Pay pay;

	public Order(List<Items> items, Pay pay) {
		this.items = items;
		this.pay = pay;
	}

	public List<Items> getItems() {
		return items;
	}

	public Pay getPay() {
		return pay;
	}
}
