package com.rbc.assignment.itemsonsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main Application class for the application.
 */
@SpringBootApplication
public class ItemsOnSaleApplication {

	private static final Logger LOGGER = LogManager.getLogger(ItemsOnSaleApplication.class);

	/**
	 * Entry point for the application.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.info("Main method : ItemsOnSaleApplication");
		SpringApplication.run(ItemsOnSaleApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}