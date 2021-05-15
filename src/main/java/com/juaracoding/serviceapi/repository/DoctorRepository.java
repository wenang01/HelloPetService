package com.juaracoding.serviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juaracoding.serviceapi.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
