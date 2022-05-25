package com.dungi.cafe.domain.shop.product;

public enum Items {
	AMERICANO("아메리카노", 4300),
	CAFELATTE("아메리카노", 4300),
	SMOOTHIE("아메리카노", 5500);

	private final String name;
	private final int price;

	Items(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Items{" +
			"name='" + name + '\'' +
			", price=" + price +
			'}';
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}
