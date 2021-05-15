package com.juaracoding.serviceapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="users")
public class User {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String username;
		private String email;
		private String password;
		private String name;
		private String roles;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "id_users_doctor", referencedColumnName = "id")
		private Doctor doctor;

		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "id_users_client", referencedColumnName = "id")
		private Client client;

}
