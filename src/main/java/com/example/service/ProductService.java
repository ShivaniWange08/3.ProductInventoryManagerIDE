package com.example.service;

import com.example.entity.Product;

import java.util.List;

public interface ProductService {

    String saveProduct(Product product);

    List<Product> getAllProduct();

    Product getProductById(int id);

    String deleteProductById(int id);

    Product updateProduct(int id, Product newproduct);

    List<Product> savelistOfProduct(List<Product> productList);
}
