package com.stg.service;

import java.util.List;

import com.stg.entity.Orders;

public interface OrdersService {

	public abstract Orders checkOrders(int orderCustomerId);

	public abstract List<Orders> fetchOrdersList();

	public abstract Orders addOders(Orders orders);

	public abstract List<Orders> searchByOrderCustomerId(int orderCustomerId);

	public abstract Orders updateOrders(Orders orders);

	public abstract void deleteByOrderId(int orderCustomerId);

}
