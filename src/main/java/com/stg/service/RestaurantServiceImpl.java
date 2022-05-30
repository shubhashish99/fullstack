package com.stg.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import com.stg.entity.Restaurant;
import com.stg.exception.RestaurantException;
import com.stg.repository.RestaurantRepository;

public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Restaurant checkRestaurant(UUID restaurantId) {
		Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);

		if (restaurant == null) {
			throw new RestaurantException("Restaurant not found!");
		} else {
			return restaurant;
		}
	}

	@Override
	public List<Restaurant> fetchRestaurantList() {

		return restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> searchByRestaurantType(String restaurantType) {

		return restaurantRepository.findByRestaurantType(restaurantType);
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {

		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {

		return restaurantRepository.save(restaurant);
	}

	@Override
	public void deleteByRestaurtantId(UUID restaurantId) {
		restaurantRepository.deleteByRestaurtantId(restaurantId);

	}

}
