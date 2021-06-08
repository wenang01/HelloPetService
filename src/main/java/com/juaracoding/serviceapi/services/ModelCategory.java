package com.juaracoding.serviceapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juaracoding.serviceapi.entity.Categories;
import com.juaracoding.serviceapi.entity.Products;
import com.juaracoding.serviceapi.repository.CategoriesRepository;

@Service
public class ModelCategory implements ModelCategiresInterface{

	@Autowired
	CategoriesRepository categoriesRepository;
	
	@Override
	public List<Categories> getAllCategories() {
	
		return (List<Categories>) this.categoriesRepository.findAll();
	}

	@Override
	public Categories addCategory(Categories category) {
		
		return this.categoriesRepository.save(category);
	}

	@Override
	public void deleteCategory(String id) {
		this.categoriesRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Categories cariCategory(String id) {
		
		return this.categoriesRepository.findById(Long.parseLong(id)).get();
	}

	
}
