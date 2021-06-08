package com.juaracoding.serviceapi.services;

import java.util.List;

import com.juaracoding.serviceapi.entity.Categories;
import com.juaracoding.serviceapi.entity.Products;

public interface ModelCategoriesInterface {

	List<Categories> getAllCategories();
	
	public Categories addCategory(Categories category);
	
	public void deleteCategory(String id);
	
	public Categories cariCategory(String id);
}
