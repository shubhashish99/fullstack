package com.stg.service;

import java.util.List;
import java.util.UUID;

import com.stg.entity.Customers;

public interface CustomerService {

	public abstract Customers checkCustomer(UUID customerId, String customerName); // validation

	public abstract List<Customers> fetchCustomerList(); // read

	public abstract Customers addCustomer(Customers customer); // add

	public abstract List<Customers> searchByIdAndCustName(UUID customerId, String customerName); // search

	public abstract Customers updateCustomer(Customers customer); // update

	public abstract void deleteByCustId(UUID customerId); // delete

}
