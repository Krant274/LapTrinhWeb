package vn.thct.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vn.thct.models.Customer;

@RestController
@EnableMethodSecurity
public class CustomerController {

	private final List<Customer> customers = List.of(
			new Customer("001", "Nguyễn Hữu Trung", "0123456789", "trungnhspkt@gmail.com"),
			new Customer("002", "Hữu Trung", "0987654321", "trunghuu@gmail.com"));

	@GetMapping("/hello")
	public ResponseEntity<String> hello(Authentication authentication) {
		String roles = authentication.getAuthorities().toString();
		return ResponseEntity.ok("Hello, Guest. Roles: " + roles);
	}

	@GetMapping("/customer/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<Customer>> getCustomerList() {
		List<Customer> list = this.customers;
		return ResponseEntity.ok(list);
	}

	@GetMapping("/customer/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<Customer> getCustomerList(@PathVariable("id") String id) {
		List<Customer> customers = this.customers.stream().filter(customer -> customer.getId().equals(id)).toList();
		return ResponseEntity.ok(customers.get(0));
	}

}