package com.stg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.stg.entity.Orders;
import com.stg.exception.OrdersException;
import com.stg.repository.OrdersRepository;

public class OrderServiceImpl implements OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public Orders checkOrders(int orderCustomerId) {

		Orders orders = (Orders) ordersRepository.findByOrderCustomerId(orderCustomerId);
		if (orders == null) {

			throw new OrdersException("Order not found!");
		} else {
			return orders;
		}
	}

	@Override
	public List<Orders> fetchOrdersList() {

		return ordersRepository.findAll();
	}

	@Override
	public Orders addOders(Orders orders) {

		return ordersRepository.save(orders);
	}

	@Override
	public List<Orders> searchByOrderCustomerId(int orderCustomerId) {

		return ordersRepository.findByOrderCustomerId(orderCustomerId);
	}

	@Override
	public Orders updateOrders(Orders orders) {

		return ordersRepository.save(orders);
	}

	@Override
	public void deleteByOrderId(int orderCustomerId) {
		ordersRepository.deleteByCustId(orderCustomerId);

	}

}
