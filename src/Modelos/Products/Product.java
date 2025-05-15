package Modelos.Products;

import Modelos.BaseEntity;
import Modelos.Categories.Category;

import java.util.ArrayList;
import java.util.List;

public class Product extends BaseEntity<Product>{

    private String productImage;
    private Double price;
    private Integer productStock;
    private Category category;

    public Product() {
    }

    public Product(Integer id, String name, String description, String productImage, Double price, Integer productStock, Category category) {
        super(id, name, description);
        this.productImage = productImage;
        this.price = price;
        this.productStock = productStock;
        this.category = category;
    }

    private static List<Product> productos = new ArrayList<>();

    @Override
    public void crear(Product product) {
        productos.add(product);
    }

    @Override
    public List<Product> listar() {
        return productos;
    }

    @Override
    public Product buscarPorId(Integer id) {
        for (Product product : productos) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void eliminar(Integer id) {
        productos.removeIf(product -> product.getId().equals(id));
    }

    // Getters y Setters
    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
