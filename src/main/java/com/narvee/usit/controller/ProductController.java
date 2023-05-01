package com.narvee.usit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.narvee.usit.entity.Product;
import com.narvee.usit.service.ProductService;

 @RestController
 public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product)
	{
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());
		
		return service.saveProduct(product);
		
	}
	@PostMapping("/addproducts")
	public List<Product> addProducts(@RequestBody List<Product> products)
	{
		return service.saveProducts(products);
	}
	
	@GetMapping("/products")
	public List<Product> findallProducts()
	{
		return service.getProducts();
	}
	@GetMapping("/productByid/{id}")
	public Product findProductById(@PathVariable int id)
	{
		return service.getProductById(id);
	}
	@GetMapping("/product/{name}")
	public Product findProductByName(@PathVariable String name)
	{
		return service.getProductByName(name);
	}

    @PutMapping("/update")
	public String productupdated(@RequestBody Product product)
	{
    	service.updateProduct(product);
	    return "updated product";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		 service.deleteProduct(id);
		 return "deleted:"+id;
	}
	
 }
