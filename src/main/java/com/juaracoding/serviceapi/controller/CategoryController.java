package com.juaracoding.serviceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.serviceapi.entity.Categories;
import com.juaracoding.serviceapi.payload.response.MessageResponse;
import com.juaracoding.serviceapi.repository.CategoriesRepository;
import com.juaracoding.serviceapi.services.ModelCategory;

@Controller
@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	ModelCategory modelCategory;
	
	@Autowired
	CategoriesRepository categoriesRepository;
	
	@GetMapping("/")
	public String indexCategories(Model model) {
		
		model.addAttribute("lstCategories", modelCategory.getAllCategories());
		return "Categories List";
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addCategory(@RequestBody Categories postCategory){
		
		Categories categories = new Categories(postCategory.getCatName(), postCategory.getDesciption());
		
		categoriesRepository.save(categories);
		
		return ResponseEntity.ok(new MessageResponse("Category added successfully!"));
	}
	
	@PutMapping("/update/{id}")
	public String updateCategory(@PathVariable String id, @RequestBody Categories updateCategory, Model model) {
		
		Categories categories = modelCategory.cariCategory(id);
		updateCategory.setId(Long.parseLong(id));
		Categories category = new Categories(updateCategory.getCatName(), updateCategory.getDesciption());
		
		category.setId(Long.parseLong(id));
		this.categoriesRepository.save(category);
		
		return "Product {id} "+ categories +" Berhasil diupdate dengan "+category;

	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable String id, Model model) {
		this.modelCategory.deleteCategory(id);
		return "Product {id} Berhasil dihapus";
	}
	
	
}
