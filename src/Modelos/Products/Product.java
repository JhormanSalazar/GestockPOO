package Modelos.Products;

import Modelos.Category;

public class Product {
    private Integer productId;
    private String name;
    private String description;
    private String productImage;
    private Integer price;
    private Category category; // Asociación con Category

    // Constructor vacío
    public Product() {}

    // Constructor con parámetros
    public Product(Integer productId, String name, String description, String productImage, Integer price, Category category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.productImage = productImage;
        this.price = price;
        this.category = category;
    }

    // Getters y Setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
