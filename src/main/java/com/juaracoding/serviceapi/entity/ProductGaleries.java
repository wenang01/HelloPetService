package com.juaracoding.serviceapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(	name = "product_galery")
public class ProductGaleries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public String image;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="products_id", nullable=false)
    private Products products;

}
