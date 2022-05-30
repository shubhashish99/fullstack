package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.RestaurantTables;
import com.stg.service.RestaurantTablesService;

@RestController
public class RestaurantTableController {

	@Autowired
	private RestaurantTablesService restaurantTablesService;

	@GetMapping(value = "/checktable", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> checkRestaurantTable(int tableNo) {

		boolean check = restaurantTablesService.checkRestaurantTable(tableNo);

		return new ResponseEntity<Boolean>(check, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchtablelist", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestaurantTables> fetchTableList() {

		List<RestaurantTables> restaurantTables = restaurantTablesService.fetchTableList();

		return new ResponseEntity<RestaurantTables>((RestaurantTables) restaurantTables, HttpStatus.OK);
	}

	@PostMapping(value = "/addtable", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestaurantTables> addTable(RestaurantTables restaurantTables) {

		RestaurantTables resTables = restaurantTablesService.addTable(restaurantTables);

		return new ResponseEntity<RestaurantTables>(resTables, HttpStatus.OK);
	}

	@PutMapping(value = "/updatetable", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestaurantTables> updateRestaurantTables(RestaurantTables restaurantTables) {

		RestaurantTables resTables = restaurantTablesService.updateRestaurantTables(restaurantTables);

		return new ResponseEntity<RestaurantTables>(resTables, HttpStatus.OK);
	}

}
