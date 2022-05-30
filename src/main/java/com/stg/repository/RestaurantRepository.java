package com.stg.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stg.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	public Restaurant findByRestaurantId(UUID restaurantId);

	public List<Restaurant> findByRestaurantType(String restaurantType);

	public void deleteByRestaurtantId(UUID restaurantId);

}
