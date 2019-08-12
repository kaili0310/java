package com.yq.service;

import java.util.List;
import com.yq.entity.Product;

public interface IProductService {
	public List<Product> findAll(int page,int size);
	public int save(Product product);//添加product的业务
	public void del(String []ids);
}
