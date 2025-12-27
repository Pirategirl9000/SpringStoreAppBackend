package org.example.store_fullstack_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Driver class for the Spring App
 */
@SpringBootApplication
public class StoreFullstackBackendApplication {
	/**
	 * Initializes the IoC container and begins the Spring application
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(StoreFullstackBackendApplication.class, args);
	}
}
