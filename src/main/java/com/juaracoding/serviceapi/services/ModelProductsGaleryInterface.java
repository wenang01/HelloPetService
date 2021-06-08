package com.juaracoding.serviceapi.services;

import java.util.List;

import com.juaracoding.serviceapi.entity.ProductGaleries;
import com.juaracoding.serviceapi.entity.Products;

public interface ModelProductsGaleryInterface {

	List<ProductGaleries> getAllProductImages();
	
	public ProductGaleries addProductImages(ProductGaleries productImages);
	
	public List<ProductGaleries> addProductImagesList(List<ProductGaleries> productImages);
	
	public void deleteProductImage(String id);
	
	public ProductGaleries cariProductImage(String id);
	
}
