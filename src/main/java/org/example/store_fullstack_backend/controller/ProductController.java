package org.example.store_fullstack_backend.controller;

import org.example.store_fullstack_backend.model.product.Product;
import org.example.store_fullstack_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
public class ProductController {
    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
            this.productService = productService;
    }

    @PostMapping("/products")
    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/")
    public List<Product> getProductsByCategory(@RequestParam List<String> categories) {
        return productService.getProductsByCategory(categories);
    }
}
