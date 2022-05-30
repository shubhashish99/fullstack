package com.stg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.stg.entity.Sales;

public interface SalesService {

	public abstract Sales checkSales(UUID saleId);

	public abstract long countSalesFromDateUntilNow(LocalDate orderDate);

	public abstract List<Sales> searchBySaleType(String saleType);

	public abstract Sales addSales(Sales sales);

	public abstract Sales updateSales(Sales sales);

	public abstract void deleteBySaleId(UUID saleId);

}
