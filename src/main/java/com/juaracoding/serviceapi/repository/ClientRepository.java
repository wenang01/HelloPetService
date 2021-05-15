package com.juaracoding.serviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juaracoding.serviceapi.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
