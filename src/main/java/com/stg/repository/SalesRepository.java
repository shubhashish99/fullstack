package com.stg.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stg.entity.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {

	public Sales findBySaleId(UUID saleId);

	public List<Sales> findBySaleType(String saleType);

	public void deleteById(UUID saleId);

}
