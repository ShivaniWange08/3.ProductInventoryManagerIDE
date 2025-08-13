package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        System.err.println(product);
        productService.saveProduct(product);
        return new ResponseEntity<>("Product Data Add Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getAllData(){
        List<Product> productList = productService.getAllProduct();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable ("id") int id){
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable ("id") int id){
        String delete = productService.deleteProductById(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product){
        Product updateProduct = productService.updateProduct(id, product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @PostMapping("/ListOfProduct")
    public ResponseEntity<List<Product>> sanelistOfEmployee(@RequestBody List<Product> productList){
        productService.savelistOfProduct(productList);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}


