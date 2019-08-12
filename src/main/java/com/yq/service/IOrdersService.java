package com.yq.service;

import java.util.List;

import com.yq.entity.Orders;

public interface IOrdersService {
	public List<Orders> findAll(int page,int size);
	public Orders findById(String id);
}
