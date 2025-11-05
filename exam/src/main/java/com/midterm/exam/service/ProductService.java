package com.midterm.exam.service;

import com.midterm.exam.dto.ProductDTO;
import com.midterm.exam.model.Product;
import com.midterm.exam.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(int id){
        return repository.findById(id).orElse(null);
    }

    public Product save(ProductDTO productDTO){
        Product newProduct = new Product();
        newProduct.setName(productDTO.name());
        newProduct.setBrand(productDTO.brand());
        newProduct.setPrice(productDTO.price());
        newProduct.setCategory(productDTO.category());
        return repository.save(newProduct);
    }

    public Product updateProduct(Product product, ProductDTO productDTO){
        product.setName(productDTO.name());
        product.setBrand(productDTO.brand());
        product.setPrice(productDTO.price());
        product.setCategory(productDTO.category());
        return repository.save(product);
    }

    public void deleteProduct(int id){
        repository.deleteById(id);
    }
}

