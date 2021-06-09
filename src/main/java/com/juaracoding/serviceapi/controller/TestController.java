package com.juaracoding.serviceapi.controller;

import java.util.ArrayList;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.serviceapi.services.ModelCategory;
import com.juaracoding.serviceapi.services.ModelProducts;
import com.juaracoding.serviceapi.services.ModelProductsGalery;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	ModelProducts modelProducts;
	
	@Autowired
	ModelProductsGalery modelProductGalery;
	
	@Autowired
	ModelCategory modelCategory;
	
	@GetMapping("/all")
	public String allAccess(Model model) {
		model.addAttribute("listProducts", modelProducts.getAllProducts());
//		JSONParser jparse = new JSONParser("listProducts");
		return (String) model.getAttribute("listProducts");
//		return jparse.toString();
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

//	@GetMapping("/admin")
//	@PreAuthorize("hasRole('ADMIN')")
//	public RedirectView adminAccess(Model model) {
//		
//		return new RedirectView("/dashboard");
//	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		
		return "Admin Content";
	}
}