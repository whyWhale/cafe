package com.dungi.cafe.domain.exterior;

public class Cash implements Pay {
	private int money;

	public Cash(int money) {
		this.money = money;
	}

	@Override
	public int deduct(Integer totalPrice) {
		if (money - totalPrice < 0) {
			throw new IllegalStateException("부족한 금액입니다.");
		}

		return money-totalPrice;
	}
}
