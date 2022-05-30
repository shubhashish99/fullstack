package com.stg.controller;

import java.util.List;
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

import com.stg.entity.Orders;
import com.stg.service.OrdersService;

@RestController
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@GetMapping(value = "/checkorders", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> checkOrders(@RequestParam int orderCustomerId) {

		Orders orders = ordersService.checkOrders(orderCustomerId);

		return new ResponseEntity<Orders>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchorders", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> fetchOrdersList() {

		List<Orders> orders = ordersService.fetchOrdersList();

		return new ResponseEntity<Orders>((Orders) orders, HttpStatus.OK);
	}

	@PostMapping(value = "/addorders", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> addOders(@RequestParam Orders orders) {

		Orders orders1 = ordersService.addOders(orders);

		return new ResponseEntity<Orders>(orders1, HttpStatus.OK);
	}

	@GetMapping(value = "/searchorders", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> searchByOrderCustomerId(@RequestParam int orderCustomerId) {

		List<Orders> orders = ordersService.searchByOrderCustomerId(orderCustomerId);

		return new ResponseEntity<Orders>((Orders) orders, HttpStatus.OK);
	}

	@PutMapping(value = "/updateorders", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> updateOrders(@RequestParam Orders orders) {

		Orders orders1 = ordersService.updateOrders(orders);

		return new ResponseEntity<Orders>(orders1, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteorders", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> deleteByOrderId(@RequestParam int orderCustomerId) {

		ordersService.deleteByOrderId(orderCustomerId);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
