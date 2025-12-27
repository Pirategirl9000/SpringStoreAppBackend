package org.example.store_fullstack_backend.service;

import org.example.store_fullstack_backend.model.product.Category;
import org.example.store_fullstack_backend.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> getProductsByCategory(List<String> categories) {
        return products.stream()
                .filter(prod -> prod.hasCategories(categories))
                .toList();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
