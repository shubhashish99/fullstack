package com.stg.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Customers;
import com.stg.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/checkcustomers", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customers> checkCustomer(@RequestParam UUID customerId, @RequestParam String customerName) {

		Customers customers = customerService.checkCustomer(customerId, customerName);

		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchcustomers", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customers> fetchCustomerList() {
		List<Customers> customers = customerService.fetchCustomerList();

		return new ResponseEntity<Customers>((Customers) customers, HttpStatus.OK);
	}

	@PostMapping(value = "/addcustomers", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customers> addCustomer(@RequestParam Customers customer) {

		Customers customers = customerService.addCustomer(customer);

		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchcustomers", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customers> searchByIdAndCustName(@RequestParam UUID customerId,
			@RequestParam String customerName) {
		List<Customers> customers = customerService.searchByIdAndCustName(customerId, customerName);

		return new ResponseEntity<Customers>((Customers) customers, HttpStatus.OK);
	}

	@PutMapping(value = "/updatecustomers", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customers> updateCustomer(@RequestParam Customers customer) {

		Customers customers = customerService.updateCustomer(customer);

		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deletecustomers", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customers> deleteByCustId(UUID customerId) {

		customerService.deleteByCustId(customerId);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
