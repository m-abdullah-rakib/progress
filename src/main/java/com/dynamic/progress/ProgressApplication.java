package com.dynamic.progress;

import com.dynamic.progress.entity.Customer;
import com.dynamic.progress.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgressApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProgressApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.save(new Customer(1, "First", "first@sb.com", 1));
		customerRepository.save(new Customer(2, "Second", "second@sb.com", 2));
		customerRepository.save(new Customer(3, "Third", "third@sb.com", 3));
	}
}
