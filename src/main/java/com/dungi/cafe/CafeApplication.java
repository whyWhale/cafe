package com.dungi.cafe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dungi.cafe.io.Console;
import com.dungi.cafe.domain.shop.MenuInventories;
import com.dungi.cafe.system.OrderController;

@SpringBootApplication
public class CafeApplication {
	Logger logger = LoggerFactory.getLogger(CafeApplication.class);



	public static void main(String[] args) {
		SpringApplication.run(CafeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			logger.info("cafe system start !");
			OrderController orderController = new OrderController(
				new Console(),
				new MenuInventories());
			orderController.run();
		};
	}
}
