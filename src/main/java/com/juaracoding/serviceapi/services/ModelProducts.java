package com.juaracoding.serviceapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juaracoding.serviceapi.entity.Products;
import com.juaracoding.serviceapi.repository.ProductsRepository;

@Service
public class ModelProducts implements ModelProductsInterface{

	@Autowired
	ProductsRepository productsRepository;
	
	@Override
	public List<Products> getAllProducts(){
		return (List<Products>) this.productsRepository.findAll();
	}

	@Override
	public Products addProducts(Products products) {
		
		return this.productsRepository.save(products);
	}

	@Override
	public void deleteProducts(String id) {
		
		this.productsRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Products cariProducts(String id) {
		
		return this.productsRepository.findById(Long.parseLong(id)).get();
	}

}
