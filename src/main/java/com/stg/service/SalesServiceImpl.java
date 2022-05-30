package com.stg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import com.stg.entity.Sales;
import com.stg.exception.SalesException;
import com.stg.repository.SalesRepository;

public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesRepository salesRepository;

	@Override
	public Sales checkSales(UUID saleId) {
		Sales sales = salesRepository.findBySaleId(saleId);
		if (sales == null) {
			throw new SalesException("No sale found!");
		} else {
			return sales;
		}

	}

	@Override
	public long countSalesFromDateUntilNow(LocalDate orderDate) {

		orderDate.until(orderDate).getDays();
		long sales = salesRepository.count();

		return sales;
	}

	@Override
	public List<Sales> searchBySaleType(String saleType) {

		return (List<Sales>) salesRepository.findBySaleType(saleType);
	}

	@Override
	public Sales addSales(Sales sales) {

		return salesRepository.save(sales);
	}

	@Override
	public Sales updateSales(Sales sales) {

		return salesRepository.save(sales);
	}

	@Override
	public void deleteBySaleId(UUID saleId) {
		salesRepository.deleteById(saleId);

	}

}
