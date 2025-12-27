package org.example.store_fullstack_backend.service;

import org.example.store_fullstack_backend.model.product.Product;
import org.example.store_fullstack_backend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service handler for products
 */
@Service
public class ProductService {
    ProductRepo repo;

    /**
     * Gets products with matching categories, returns all if no categories are provided
     * @param categories {@code List<String>} list of categories to filter the products based on see {@link org.example.store_fullstack_backend.model.product.Category}
     * @return {@code List<Product>} list of products with matching categories. see {@link org.example.store_fullstack_backend.model.product.Product}
     */
    public List<Product> getProducts(List<String> categories) {
        if (categories == null || categories.isEmpty()) {
            return repo.findAll();
        } else {
            return repo.findAll().stream()
                    .filter(prod -> prod.hasCategories(categories))
                    .toList();
        }
    }

    @Autowired
    public void setRepo(ProductRepo repo) {
        this.repo = repo;
    }

    /**
     * Adds a product to the list of managed products. see {@link org.example.store_fullstack_backend.model.product.Product}
     * @param product product to add
     */
    public void saveProduct(Product product) {
        repo.save(product);
    }
}
