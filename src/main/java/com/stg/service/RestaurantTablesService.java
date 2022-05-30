package com.stg.service;

import java.util.List;
import com.stg.entity.RestaurantTables;

public interface RestaurantTablesService {
	public abstract boolean checkRestaurantTable(int tableNo); // validation

	public abstract List<RestaurantTables> fetchTableList(); // read

	public abstract RestaurantTables addTable(RestaurantTables restaurantTables); // add

	public abstract RestaurantTables updateRestaurantTables(RestaurantTables restaurantTables); // update

}
