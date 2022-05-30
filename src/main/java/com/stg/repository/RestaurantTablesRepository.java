package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.RestaurantTables;

@Repository
public interface RestaurantTablesRepository extends JpaRepository<RestaurantTables, Integer> {
	
	
	

}
