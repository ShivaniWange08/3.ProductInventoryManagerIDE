package com.example.serviceimpl;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceimpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return "product saved";
    }

    @Override
    public List<Product> getAllProduct() {
      List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public Product getProductById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Product with id not found" +id));
        return product;
    }

    @Override
    public String deleteProductById(int id) {
            productRepository.deleteById(id);
        return "Product Deleted";
    }

    @Override
    public Product updateProduct(int id, Product newproduct) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Product with id not found in database" +id));
        System.err.println("old product from db " +product);
        System.err.println("product object with value to be updated" +newproduct);
        product.setName(newproduct.getName());
        product.setPrice(newproduct.getPrice());
        product.setQuality(newproduct.getQuality());
        product.setManufacturer(newproduct.getManufacturer());

        Product updatedproduct = productRepository.save(product);
        System.err.println("product with updated value" +updatedproduct);

        return updatedproduct;
    }

    @Override
    public List<Product> savelistOfProduct(List<Product> productList) {
        productRepository.saveAll(productList);
        return productList;
    }
}
