package com.yq.controller;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.yq.entity.Product;
import com.yq.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	@RequestMapping("/findAll.do")
	public String findAll(int page,int size,ModelMap model){
		List list=productService.findAll(page,size);
		PageInfo pageInfo=new PageInfo(list);
		model.put("pageInfo", pageInfo);
		return "product-list";
	}
	@RequestMapping("/save.do")
	public String save(Product product){
		product.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		if(productService.save(product)>0) 
			return "redirect:findAll.do?page=1&size=4";
		return "error";
	}
	
	@RequestMapping("/del.do")
	public String del(String[] ids){
		productService.del(ids);
		return "redirect:findAll.do?page=1&size=4";
	}
}
