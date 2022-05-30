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
import com.stg.entity.Restaurant;
import com.stg.service.RestaurantService;

@RestController
public class RestaurantContoller {

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping(value = "/checkrestaurant", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> checkRestaurant(@RequestParam UUID restaurantId) {

		Restaurant restaurant = restaurantService.checkRestaurant(restaurantId);

		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchrestaurant", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> fetchRestaurantList() {

		List<Restaurant> restaurant = restaurantService.fetchRestaurantList();

		return new ResponseEntity<Restaurant>((Restaurant) restaurant, HttpStatus.OK);
	}

	@GetMapping(value = "/searchbyrestauranttype", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> searchByRestaurantType(@RequestParam String restaurantType) {

		List<Restaurant> restaurant = restaurantService.searchByRestaurantType(restaurantType);

		return new ResponseEntity<Restaurant>((Restaurant) restaurant, HttpStatus.OK);
	}

	@PostMapping(value = "/addrestaurant", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> addRestaurant(@RequestParam Restaurant restaurant) {

		Restaurant restaurant1 = restaurantService.addRestaurant(restaurant);

		return new ResponseEntity<Restaurant>(restaurant1, HttpStatus.OK);
	}

	@PutMapping(value = "/updaterestaurant", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> updateRestaurant(@RequestParam Restaurant restaurant) {

		Restaurant restaurant1 = restaurantService.updateRestaurant(restaurant);

		return new ResponseEntity<Restaurant>(restaurant1, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleterestaurant", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> deleteByRestaurtantId(@RequestParam UUID restaurantId) {

		restaurantService.deleteByRestaurtantId(restaurantId);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
