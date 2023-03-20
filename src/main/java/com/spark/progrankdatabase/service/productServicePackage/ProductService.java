package com.spark.progrankdatabase.service.productServicePackage;

import com.spark.progrankdatabase.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> findAll();
    public Optional<Product> findProductById(int id);
    public String addProduct(Product product);

    public String deleteProduct(int id);

    public String updateProduct(Product product);


}
