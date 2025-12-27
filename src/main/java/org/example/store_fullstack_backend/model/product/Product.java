package org.example.store_fullstack_backend.model.product;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private String prodName;
    private String prodDesc;
    private double prodPrice;
    private List<Category> categories;

    /**
     * Creates a new product
     * @param id productID
     * @param prodName Name of the product
     * @param prodDesc Description for the product
     * @param prodPrice Price of the product
     * @param categories List of categories that the product falls under
     */
    public Product(int id, String prodName, String prodDesc, double prodPrice, List<Category> categories) {
        this.id = id;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
        this.categories = new ArrayList<>(categories);  // Just in case we decide we want to change the categories
    }

    /**
     * Returns the id of the product
     * @return integer id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the product name
     * @return String product name
     */
    public String getProdName() {
        return prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public boolean hasCategories(List<String> category) {
        for (Category c : categories) {
            if (!(this.categories.contains(c))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", prodName='" + prodName + '\'' +
                ", prodDesc='" + prodDesc + '\'' +
                ", prodPrice=" + prodPrice +
                ", categories=" + categories +
                '}';
    }
}
