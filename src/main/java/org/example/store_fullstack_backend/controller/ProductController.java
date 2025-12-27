package org.example.store_fullstack_backend.controller;

import org.example.store_fullstack_backend.model.product.Product;
import org.example.store_fullstack_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for all requests related to products, accepts requests from port:5173 and port:8080<br><br>
 * Note that Spring runs on port:8080 so outside requests should be hosting on port:5173
 */
@CrossOrigin("http://localhost:5173")
@RestController
public class ProductController {
    /**
     * Manages the logic related to products. see {@link org.example.store_fullstack_backend.service.ProductService}
     */
    ProductService productService;

    /**
     * Sets the product service handler through Spring autowiring. see {@link org.example.store_fullstack_backend.service.ProductService}
     * @param productService productService handler to add
     */
    @Autowired
    public void setProductService(ProductService productService) {
            this.productService = productService;
    }

    /**
     * Adds a product to the list of managed products. see {@link org.example.store_fullstack_backend.model.product.Product}
     * @param product product to add, serialized automatically by Jackson
     */
    @PostMapping("/products")
    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    /**
     * Returns a list of all the products currently manaaged. see {@link org.example.store_fullstack_backend.model.product.Product}
     * @return {@code List<Product>} list of products, serialized automatically by Jackson
     */
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Returns a list of all products matchin the specified categories. see {@link org.example.store_fullstack_backend.model.product.Product}
     * @param categories {@code List<String>} list of categories(as strings) that matches the enum signature for categories. see {@link org.example.store_fullstack_backend.model.product.Category}
     * @return {@code List<Product>} list of products with matching categories. serialized automatically by Jackson
     */
    @GetMapping("/products/")
    public List<Product> getProductsByCategory(@RequestParam List<String> categories) {
        return productService.getProductsByCategory(categories);
    }
}
