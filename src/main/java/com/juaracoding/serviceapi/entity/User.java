package com.juaracoding.serviceapi.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 20)	
	private String username;

	@NotBlank
	@Email
	@Size(max = 50)
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

    private String name;
	private String address_one;
	private String address_two;
	private int provinces_id;
	private int regencies_id;
	private int zip_code;
	private String country;
	private String phone_number;
	private String birthday;
	private String gender;
	
	public User(String name, String username, String email, String password, 
			String address_one, String address_two, int provinces_id, int regencies_id, int zip_code,
			String country, String phone_number, String birthday, String gender) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address_one = address_one;
		this.address_two = address_two;
		this.provinces_id = provinces_id;
		this.regencies_id = regencies_id;
		this.zip_code = zip_code;
		this.country = country;
		this.phone_number = phone_number;
		this.birthday = birthday;
		this.gender = gender;
	}

		public User(String name, String email, String password) {
			this.name = name;
			this.email = email;
			this.password = password;
		}
		
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(	name = "user_roles", 
					joinColumns = @JoinColumn(name = "user_id"), 
					inverseJoinColumns = @JoinColumn(name = "role_id"))
		private Set<Role> role = new HashSet<>();

		@OneToOne(mappedBy = "user")
	    private Doctors doctor;
		
		@OneToMany(mappedBy = "user")
	    private List<Transactions> transaction;
}
