package com.spark.progrankdatabase.service.productServicePackage;

import com.spark.progrankdatabase.entity.Product;
import com.spark.progrankdatabase.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(int id) {
        return  this.productRepository.findById(id);
    }

    @Override
    public String addProduct(Product product) {
        this.productRepository.save(product);
        return "product added successfully";
    }

    @Override
    public String deleteProduct(int id) {
         this.productRepository.deleteById(id);
         return "product delete successfully";
    }

    @Override
    public String updateProduct(Product product) {
        return null;

    }
}
