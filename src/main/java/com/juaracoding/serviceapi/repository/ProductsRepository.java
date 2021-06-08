package com.juaracoding.serviceapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.juaracoding.serviceapi.entity.Products;

public interface ProductsRepository extends CrudRepository<Products, Long>{

	
}
