package com.spark.progrankdatabase.controller;


import com.spark.progrankdatabase.entity.Product;
import com.spark.progrankdatabase.service.productServicePackage.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@EnableMethodSecurity
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/find")
    @PreAuthorize("hasAnyRole('ROLE_SELLER','ROLE_USER')")
    public List<Product> findProduct()
    {
        return this.productService.findAll();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_SELLER','ROLE_USER')")
    public Optional<Product> findProductById(@PathVariable int id)
    {
        return this.productService.findProductById(id);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_SELLER')")
    public String addProduct(@RequestBody Product product)
    {
        System.out.println(product);
        return this.productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteProduct(@PathVariable int id)
    {
        return this.productService.deleteProduct(id);
    }
}
