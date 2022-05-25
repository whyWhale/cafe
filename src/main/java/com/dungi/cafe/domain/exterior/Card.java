package com.dungi.cafe.domain.exterior;

public class Card implements Pay {
	private String serial;
	private int limit;
	private int useage;

	public Card(String serial, int limit) {
		this.serial = serial;
		this.limit = limit;
	}

	@Override
	public int deduct(Integer totalPrice) {
		if (this.limit < this.useage + totalPrice) {
			throw new IllegalStateException("잔고가 부족합니다...");
		}

		this.limit += totalPrice;

		return 0;
	}
}
