package com.dungi.cafe.domain.shop.employee.Casher;

public class PurchaseHistory {

	private final int rest;
	private final int totalPrice;

	public PurchaseHistory(int rest, int totalPrice) {
		this.rest = rest;
		this.totalPrice = totalPrice;
	}

	public int getRest() {
		return rest;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
}
