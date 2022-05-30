package com.stg.service;

import java.util.List;
import java.util.UUID;

import com.stg.entity.Restaurant;

public interface RestaurantService {

	public abstract Restaurant checkRestaurant(UUID restaurantId);

	public abstract List<Restaurant> fetchRestaurantList();

	public abstract List<Restaurant> searchByRestaurantType(String restaurantType);

	public abstract Restaurant addRestaurant(Restaurant restaurant);

	public abstract Restaurant updateRestaurant(Restaurant restaurant);

	public abstract void deleteByRestaurtantId(UUID restaurantId);
}
