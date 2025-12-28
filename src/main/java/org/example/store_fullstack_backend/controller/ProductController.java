package org.example.store_fullstack_backend.controller;

import org.example.store_fullstack_backend.model.product.Product;
import org.example.store_fullstack_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


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
     * Returns a list of all unique categories within the product table
     * @return {@code List<String>} all distinct categories which there are products using
     */
    @GetMapping("/products/categories")
    public List<String> getDistinctCategories() {
        return productService.getDistinctCategories();
    }

    /**
     * Returns a list of all products matching the specified categories, if none are specified returns all products. see {@link org.example.store_fullstack_backend.model.product.Product}
     * @param categories {@code List<String>} list of categories(as strings) that matches the enum signature for categories.
     * @return {@code List<Product>} list of products with matching categories. serialized automatically by Jackson
     */
    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(value="cat", required=false) List<String> categories) {
        return productService.getProducts(categories);
    }

    /**
     * Adds a product to the list of managed products. see {@link org.example.store_fullstack_backend.model.product.Product}<br><br>
     * Functionally the same as {@code updateProduct(Product product)}
     * @param product product to add, serialized automatically by Jackson
     */
    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    /**
     * Updates an existing product with a matching id. see {@link org.example.store_fullstack_backend.model.product.Product}<br><br>
     * Functionally the same as {@code addProduct(Product product)}
     * @param product product to replace the product with a matching id, serialized automatically by Jackson
     */
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    /**
     * Delete a product based on it's id
     * @param productId {@code int} id of product you want to delete
     */
    @DeleteMapping("/products")
    public void deleteProduct(@RequestParam(value="id") int productId) {
        productService.deleteProduct(productId);
    }
}
