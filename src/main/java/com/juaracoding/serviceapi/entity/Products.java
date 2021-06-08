package com.juaracoding.serviceapi.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(	name = "product")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String productName;
	private double price;
	private int stok;
	private String prodImage;
	private String desciption;
	
//	@OneToMany(cascade = CascadeType.ALL)
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="id_category", referencedColumnName = "id")
	private Set<Categories> category = new HashSet<>();
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="id_product", referencedColumnName = "id")
//	private List<ProductGaleries> productGalery = new ArrayList<ProductGaleries>();
	
	@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="id_product", referencedColumnName="id")
	private List<ProductGaleries> productGalery;
	
	public Products(String productName, double price, int stok, String prodImage, String desciption) {
		this.productName = productName;
		this.price = price;
		this.stok = stok;
		this.prodImage = prodImage;
		this.desciption = desciption;
	}
	
}
