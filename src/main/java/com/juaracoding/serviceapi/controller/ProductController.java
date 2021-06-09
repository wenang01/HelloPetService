package com.juaracoding.serviceapi.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.juaracoding.serviceapi.entity.Categories;
import com.juaracoding.serviceapi.entity.Products;
import com.juaracoding.serviceapi.payload.response.MessageResponse;
import com.juaracoding.serviceapi.repository.ProductsRepository;
import com.juaracoding.serviceapi.services.ModelProducts;
import com.juaracoding.serviceapi.utility.FileUtility;

@Controller
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ModelProducts modelProducts;
	
	@Autowired
	ProductsRepository productRepository;

    private final String UPLOAD_DIR = "./src/main/resources/static/uploads/";
    
    @GetMapping("/")
    public String indexProducts(Model model) {
//    	Model productslist = model.addAttribute("listProducts",modelProducts.getAllProducts());
//    	return productslist.toString();
    	
    	model.addAttribute("lstProducts",modelProducts.getAllProducts());
    	return "Product List";
    }
    
//    @GetMapping("/add")
//    public String addProduct(Model model) {
//    	model.addAttribute("lstProducts", new Products());
//    	return "Product Berhasil Ditambahkan";
//    }
    
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestParam(value="file")MultipartFile file, @RequestBody Products postProduct) throws IOException {
    	
    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    	
    	String uploadDir = "product-photos/";
    	
    	FileUtility.saveFile(uploadDir, fileName, file);
    	
    	postProduct.setProdImage("/"+uploadDir+fileName);
    	this.modelProducts.addProducts(postProduct);
//    	model.addAttribute("listProducts", modelProducts.getAllProducts());
    	
    	Products product = new Products(postProduct.getProductName(), postProduct.getPrice(), 
    									postProduct.getStok(), postProduct.getProdImage(),
    									postProduct.getDesciption());
//    	Set<Categories> strCategory = postProduct.getCategory();
    	
    	
    	Set<Categories> category = new HashSet<>();
    	
    	product.setCategory(category);;
		productRepository.save(product);

		return ResponseEntity.ok(new MessageResponse("Product added successfully!"));
    }
    
//    @PostMapping("/add")
//    public String addImageProduct(@RequestParam(value="file")MultipartFile file, @ModelAttribute Products product, Model model) throws IOException {{
//    
//    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//    	
//    	String uploadDir = "product-photos/";
//    	
//    	FileUtility.saveFile(uploadDir, fileName, file);
//    	
//    	product.setProdImage("/"+uploadDir+fileName);
//    	this.modelProducts.addProducts(product);
//    	model.addAttribute("listProducts", modelProducts.getAllProducts());
//    	
//    	return "Product Berhasil Ditambahkan";
//    	
//    	
//    }}

    
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable String id, @RequestBody Products updateProduct, Model model) {
    	
    	Products products = modelProducts.cariProducts(id);
    	updateProduct.setId(Long.parseLong(id));
    	Products product = new Products(updateProduct.getProductName(), updateProduct.getPrice(), 
    			updateProduct.getStok(), updateProduct.getProdImage(),
    			updateProduct.getDesciption());
//    	model.addAttribute("products", products); 
    	product.setId(Long.parseLong(id));
    	this.productRepository.save(product);
		return "Product {id} "+ products +" Berhasil diupdate dengan "+product;
    	
    }
    
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id, Model model) {
    	
    	this.modelProducts.deleteProducts(id);
    	
		return "Product {id} Berhasil dihapus";
    	
    }
    
}
