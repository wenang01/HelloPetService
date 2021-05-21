package com.juaracoding.serviceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.serviceapi.entity.Role;
import com.juaracoding.serviceapi.repository.RoleRepository;

@Controller
@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	RoleRepository roleRepo;
	
	@GetMapping("/")
	public List<Role> getAll(){
		return (List<Role>) roleRepo.findAll();
	}
		
	@PostMapping("/add")
	public String addRole(@RequestBody Role role) {
		roleRepo.save(role);
		return "Insert Berhasil";
	}

}
