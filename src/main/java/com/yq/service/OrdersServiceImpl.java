package com.yq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yq.entity.Orders;
import com.yq.mapper.IOrdersDaoMapper;
@Service("ordersSerivce")
public class OrdersServiceImpl implements IOrdersService {
	@Autowired
	private IOrdersDaoMapper ordersMapper;
	public List<Orders> findAll(int page,int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return ordersMapper.findAll();
	}
	public Orders findById(String id) {
		// TODO Auto-generated method stub
		return ordersMapper.findById(id);
	}

}
