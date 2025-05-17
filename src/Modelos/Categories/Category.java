package Modelos.Categories;

import Modelos.BaseEntity;
import Modelos.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category extends BaseEntity<Category> {

    private List<Product> products;

    public Category() {
    }

    public Category(Integer id, String name, String desc) {
        super(id, name, desc);
        this.products = new ArrayList<>();
    }

    private static List<Category> categories = new ArrayList<>();

    // TODO alacenar producto en categoria

    @Override
    public void crear(Category category) {
        categories.add(category);
    }

    @Override
    public List<Category> listar() {
        return categories;
    }

    @Override
    public Category buscarPorId(Integer id) {
        for (Category category : categories) {
            if (category.getId().equals(id)) {
                return category;
            }
        }
        return null;
    }

    public void eliminar(Integer id) {
        categories.removeIf(category -> category.getId().equals(id));
    }

    public List<Product> listarProductos () {
        return products;
    }

    //Getters and Setters
    public List<Product> getProducts() {
        return products;
    }

    public void addProudctToCategory(Integer id, Product product) {
        for (Category c : categories){
            if(c.getId().equals(id)){
                c.products.add(product);
            }
        }
    }

    public static List<Category> getCategories() {
        return categories;
    }

    public static void setCategories(List<Category> categories) {
        Category.categories = categories;
    }
}
