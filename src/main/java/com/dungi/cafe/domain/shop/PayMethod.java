package com.dungi.cafe.domain.shop;

import java.util.Arrays;

public enum PayMethod {
	CARD(1),
	CASH(2);

	private final int number;

	PayMethod(int number) {
		this.number = number;
	}

	public static PayMethod of(int number) {
		return Arrays.stream(PayMethod.values())
			.filter(payMethod -> payMethod.number == number)
			.findAny().orElseThrow(() -> new IllegalArgumentException("잘못된 결제 방식입니다."));
	}

}
