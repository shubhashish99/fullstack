package com.stg.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

	public List<Customers> findByCustName(String customerName);

	public Customers findByCustIdAndCustName(UUID customerId, String customerName);

	public void deleteByCustId(UUID customerId);

}
