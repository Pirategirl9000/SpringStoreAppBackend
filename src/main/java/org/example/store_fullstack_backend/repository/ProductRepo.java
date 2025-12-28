package org.example.store_fullstack_backend.repository;

import org.example.store_fullstack_backend.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT DISTINCT p.categories FROM Product p")
    List<String> getDistinctCategories();
}
