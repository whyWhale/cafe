package com.dungi.cafe.domain.shop.product;

public class Coffee {
	private final String name;

	public Coffee(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Coffee{" +
			"name='" + name + '\'' +
			'}';
	}
}
