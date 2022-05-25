package com.dungi.cafe.domain.shop.employee;

import com.dungi.cafe.domain.shop.product.Coffee;
import com.dungi.cafe.domain.shop.product.Items;

public class Baristar {
	public Coffee createCoffee(Items items) {
		return new Coffee(items.getName());
	}
}
