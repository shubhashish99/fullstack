package com.stg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.stg.entity.RestaurantTables;
import com.stg.exception.RestaurantTablesException;
import com.stg.repository.RestaurantTablesRepository;

public class RestaurantTablesImpl implements RestaurantTablesService {

	@Autowired
	private RestaurantTablesRepository restaurantTablesRepository;

	@Override
	public boolean checkRestaurantTable(int tableNo) {

		boolean isAvailable = restaurantTablesRepository.existsById(tableNo);
		if (isAvailable == false) {

			throw new RestaurantTablesException("");
		}

		return true;

	}

	@Override
	public List<RestaurantTables> fetchTableList() {

		return restaurantTablesRepository.findAll();
	}

	@Override
	public RestaurantTables addTable(RestaurantTables restaurantTables) {

		return restaurantTablesRepository.save(restaurantTables);
	}

	@Override
	public RestaurantTables updateRestaurantTables(RestaurantTables restaurantTables) {

		return restaurantTablesRepository.save(restaurantTables);
	}

}
