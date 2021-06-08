package com.juaracoding.serviceapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juaracoding.serviceapi.entity.ProductGaleries;
import com.juaracoding.serviceapi.repository.ProductsGaleryRepository;

@Service
public class ModelProductsGalery implements ModelProductsGaleryInterface{

	@Autowired
	ProductsGaleryRepository productGaleryRepository;
	
	@Override
	public List<ProductGaleries> getAllProductImages() {
		// TODO Auto-generated method stub
		return (List<ProductGaleries>) this.productGaleryRepository.findAll();
	}

	@Override
	public ProductGaleries addProductImages(ProductGaleries productImages) {
		// TODO Auto-generated method stub
		return this.productGaleryRepository.save(productImages);
	}

	@Override
	public void deleteProductImage(String id) {
		// TODO Auto-generated method stub
		this.productGaleryRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public ProductGaleries cariProductImage(String id) {
		// TODO Auto-generated method stub
		return this.productGaleryRepository.findById(Long.parseLong(id)).get();
	}

	@Override
	public List<ProductGaleries> addProductImagesList(List<ProductGaleries> productImagesList) {
		// TODO Auto-generated method stub
		return (List<ProductGaleries>) this.productGaleryRepository.saveAll(productImagesList);
	}


}
