package com.niit.service;

import java.util.List;

import com.niit.model.Product;

public interface ProductService {
	public void addProducts(Product product);
	public void updateProducts(Product product);
	public void deleteProducts(int id);
	public Product selectProducts(int id);
	public List<Product> getAllProducts();

}
