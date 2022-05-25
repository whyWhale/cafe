package com.dungi.cafe.system;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.dungi.cafe.domain.exterior.Card;
import com.dungi.cafe.domain.exterior.Cash;
import com.dungi.cafe.domain.exterior.Pay;
import com.dungi.cafe.domain.shop.Order;
import com.dungi.cafe.domain.shop.ReceiptAndCoffees;
import com.dungi.cafe.domain.shop.product.Items;
import com.dungi.cafe.io.Console;
import com.dungi.cafe.domain.shop.employee.Baristar;
import com.dungi.cafe.domain.shop.employee.Casher.Casher;
import com.dungi.cafe.domain.shop.employee.Casher.Machine;
import com.dungi.cafe.domain.shop.MenuInventories;

public class OrderController {
	private final String EMPTY_VALUE = "";

	private final Console console;
	private final MenuInventories menuInventories;

	public OrderController(Console console, MenuInventories menuInventories) {
		this.console = console;
		this.menuInventories = menuInventories;
	}

	public void run() {
		console.output("EXIT을 입력하면 프로그램을 종료합니다.");
		String input = EMPTY_VALUE;
		do {

			Map<Integer, Items> menus = menuInventories.getMenus();

			console.output(viewMenus(menus));

			input = console.input("주문할 메뉴 번호를 선택 해주세요. 여러개이면 ','를 사용해 구분해주세요.");
			List<Items> items = Arrays.stream(input.split(","))
				.map(menus::get)
				.toList();

			int method = 0;

			try {
				String number = console.input("결제 방식을 선택해주세요.\n1.카드, 2현금");
				method = Integer.parseInt(number);
			} catch (NumberFormatException e) {
				console.output(e.getMessage());
			}

			Pay pay = null;

			switch (method) {
				case 1 -> pay = createCard();
				case 2 -> pay = createCash();
				default -> console.output("잘못 입력했습니다.");
			}

			Casher casher = new Casher(new Baristar(), menuInventories, new Machine());
			Order order = new Order(items, pay);
			ReceiptAndCoffees receiptAndCoffees = casher.takeOrder(order);

			console.output(receiptAndCoffees.toString());
		} while (!input.equals("EXIT"));
	}

	private Pay createCash() {
		String cash = console.input("현금을 입력해주세요");
		try {
			int money = Integer.parseInt(cash);
			return new Cash(money);
		} catch (NumberFormatException e) {
			console.output(e.getMessage());
		}

		throw new RuntimeException("bug!");
	}

	private Pay createCard() {
		String cardNumber = console.input("카드 번호를 입력해주세요");
		String limit = "0";
		try {
			limit = console.input("한도를 입력해주세요");
			return new Card(cardNumber, Integer.parseInt(limit));
		} catch (NumberFormatException e) {
			console.output(e.getMessage());
		}

		throw new RuntimeException("bug!");
	}

	private String viewMenus(Map<Integer, Items> items) {
		return items.entrySet().stream()
			.map(entry -> String.format("번호:%d, 정보:%s", entry.getKey(), entry.getValue().toString()))
			.collect(Collectors.joining("\n"));
	}
}
