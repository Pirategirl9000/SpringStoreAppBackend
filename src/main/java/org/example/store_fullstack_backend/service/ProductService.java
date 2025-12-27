package org.example.store_fullstack_backend.service;

import org.example.store_fullstack_backend.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    /**
     * {@code List<Product>} list of products handled by the service. see {@link org.example.store_fullstack_backend.model.product.Product}
     */
    private List<Product> products = new ArrayList<>();

    /**
     * Returns all products regardless of category. see {@link org.example.store_fullstack_backend.model.product.Product}
     * @return {@code List<Product>} list of all the products
     */
    public List<Product> getAllProducts() {
        return products;
    }

    /**
     * Returns all products that contain the list of categories. see {@link org.example.store_fullstack_backend.model.product.Product}
     * @param categories list of categories to check for. see {@link org.example.store_fullstack_backend.model.product.Category}
     * @return {@code List<Product>} list of all products matching the specified categories
     */
    public List<Product> getProductsByCategory(List<String> categories) {
        return products.stream()
                .filter(prod -> prod.hasCategories(categories))
                .toList();
    }

    /**
     * Adds a product to the list of managed products. see {@link org.example.store_fullstack_backend.model.product.Product}
     * @param product product to add
     */
    public void addProduct(Product product) {
        products.add(product);
    }
}
