package com.juaracoding.serviceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.serviceapi.entity.Client;
import com.juaracoding.serviceapi.repository.ClientRepository;

@RestController
@RequestMapping("/Client")
public class ClientController {
	
	@Autowired
	ClientRepository ClientRepo;
	
	@GetMapping("/")
	public List<Client> getAll(){
		return (List<Client>) ClientRepo.findAll();
	}
	
	@PostMapping("/add")
	public String addClient(@RequestBody Client client) {
		ClientRepo.save(client);
		return "Insert Berhasil";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteClient(@PathVariable String id) {
		ClientRepo.deleteById(Long.parseLong(id));
		return "Delete Berhasil";
	}
	
	@PutMapping("/update/{id}")
	public String updateClient(@PathVariable String id, @RequestBody Client client) {
		client.setId(Long.parseLong(id));
		ClientRepo.save(client);
		return "Update Berhasil";
	}

}