package com.saberion.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.saberion.app.model.Product;
import com.saberion.app.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

   
    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


    public List<Product> searchProducts(String code, String name) {
        return productRepository.findByCodeContainingOrNameContaining(code, name);
    }

    
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    
    public void deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setDeletedAt(java.time.LocalDateTime.now());
        productRepository.save(product);
    }
}
