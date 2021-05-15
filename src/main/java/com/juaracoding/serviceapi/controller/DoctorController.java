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

import com.juaracoding.serviceapi.entity.Doctor;
import com.juaracoding.serviceapi.repository.DoctorRepository;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorRepository DoctorRepo;
	
	@GetMapping("/")
	public List<Doctor> getAll(){
		return (List<Doctor>) DoctorRepo.findAll();
	}
	
	@PostMapping("/add")
	public String addDoctor(@RequestBody Doctor doctor) {
		DoctorRepo.save(doctor);
		return "Insert Berhasil";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDoctor(@PathVariable String id) {
		DoctorRepo.deleteById(Long.parseLong(id));
		return "Delete Berhasil";
	}
	
	@PutMapping("/update/{id}")
	public String updateDoctor(@PathVariable String id, @RequestBody Doctor doctor) {
		doctor.setId(Long.parseLong(id));
		DoctorRepo.save(doctor);
		return "Update Berhasil";
	}

}