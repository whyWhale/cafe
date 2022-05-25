package com.dungi.cafe.domain.exterior;

public interface Pay {

	int deduct(Integer totalPrice); // throw new IllegalStateException("잔고가 부족합니다.");
}
