package com.juaracoding.serviceapi.services;

import java.util.List;

import com.juaracoding.serviceapi.entity.Products;

public interface ModelProductsInterface {

	List<Products> getAllProducts();
	
	public Products addProducts(Products products);
	
	public void deleteProducts(String id);
	
	public Products cariProducts(String id);

}
