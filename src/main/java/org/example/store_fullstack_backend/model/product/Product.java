package org.example.store_fullstack_backend.model.product;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Data carrier class for Product objects containing relevant information for them
 */
@Entity
public class Product {
    /**
     * ID of the product
     */
    @Id
    private int id;

    /**
     * Name of the product
     */
    private String prodName;

    /**
     * Short description for the product
     */
    private String prodDesc;

    /**
     * Price of the product
     */
    private double prodPrice;

    /**
     * Categories this product falls under. see {@link org.example.store_fullstack_backend.model.product.Category}
     */
    @ElementCollection(targetClass = Category.class)  // Tell it this is a collection of Categories
    @Enumerated(EnumType.STRING)  // Tell it to store each enum as a String
    private List<Category> categories;

    public Product() {}

    /**
     * Creates a new product
     * @param id productID
     * @param prodName Name of the product
     * @param prodDesc Description for the product
     * @param prodPrice Price of the product
     * @param categories {@code List<Category>} that the product falls under
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
     * @return {@code integer} id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the product name
     * @return {@code String} product name
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * Returns a short description for the product
     * @return {@code String} description
     */
    public String getProdDesc() {
        return prodDesc;
    }

    /**
     * Returns the product's price
     * @return {@code double} product price
     */
    public double getProdPrice() {
        return prodPrice;
    }

    /**
     * Returns an immutable list of the categories belonging to the product
     * @return <code>List&lt;Category&gt;</code>
     */
    public List<Category> getCategories() {
        return categories;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * Returns whether the product has(at least) all the listed categories
     * @param passedCategories {@code List<String>} of categories. see {@link org.example.store_fullstack_backend.model.product.Category}
     * @return {@code true} if all categories exist, else {@code false}
     */
    public boolean hasCategories(List<String> passedCategories) {
        for (String c : passedCategories) {
            Category cat;

            try {
                cat = Category.valueOf(c.toUpperCase());
            } catch (IllegalArgumentException e) {
                return false;
            }

            if (!(this.categories.contains(cat))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns a stringified version of this class based on it's attributes
     * @return {@code String} version of the object
     */
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
