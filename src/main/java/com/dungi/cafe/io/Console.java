package com.dungi.cafe.io;

import java.util.Scanner;

public class Console {

	static final Scanner READER = new Scanner(System.in);

	public String input(String message) {
		System.out.println(message);
		return READER.nextLine();
	}

	public void output(String message) {
		System.out.println(message);
	}
}
