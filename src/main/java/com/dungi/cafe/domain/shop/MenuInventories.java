package com.dungi.cafe.domain.shop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.dungi.cafe.domain.shop.product.Items;

public class MenuInventories {

	private final Map<Integer, Items> items = new HashMap<>();

	public Map<Integer, Items> getMenus() {
		return Arrays.stream(Items.values())
			.collect(Collectors.toMap(items1 -> items1.ordinal() + 1, items1 -> items1));
	}
}
