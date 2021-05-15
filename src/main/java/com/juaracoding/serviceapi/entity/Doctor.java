package com.juaracoding.serviceapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="doctors")
public class Doctor {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "nomor_str")
		private String nomorStr;
		
		private String alamat;
		
		@Column(name = "tanggal_lahir")
		private String tanggalLahir;

		@Column(name = "jenis_kelamin")
		private String jenisKelamin;

		
}
