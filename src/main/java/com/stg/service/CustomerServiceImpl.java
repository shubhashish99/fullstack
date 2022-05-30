package com.stg.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import com.stg.entity.Customers;
import com.stg.exception.CustomerException;
import com.stg.repository.CustomersRepository;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomersRepository customersRepository;

	@Override
	public Customers checkCustomer(UUID customerId, String customerName) {

		Customers customers = customersRepository.findByCustIdAndCustName(customerId, customerName);

		if (customers == null) {

			throw new CustomerException("Customer Not Found !");

		} else {

			return customers;
		}
	}

	@Override
	public List<Customers> fetchCustomerList() {

		return customersRepository.findAll();

	}

	@Override
	public Customers addCustomer(Customers customers) {
		return customersRepository.save(customers);
	}

	@Override
	public List<Customers> searchByIdAndCustName(UUID customerId, String customerName) {

		return (List<Customers>) customersRepository.findByCustIdAndCustName(customerId, customerName);
	}

	@Override
	public Customers updateCustomer(Customers customers) {

		return customersRepository.save(customers);
	}

	@Override
	public void deleteByCustId(UUID customerId) {

		customersRepository.deleteByCustId(customerId);

	}

}
