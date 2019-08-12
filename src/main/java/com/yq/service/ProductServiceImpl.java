package com.yq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yq.entity.Product;
import com.yq.mapper.IProductDaoMapper;
@Service("productService")
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductDaoMapper productMapper;
	public List<Product> findAll(int page,int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return productMapper.findAll();
	}
	public int save(Product product) {
		// TODO Auto-generated method stub
		return productMapper.save(product);
	}
	public void del(String[] ids) {
		// TODO Auto-generated method stub
		productMapper.delProductById(ids);
	}

}
