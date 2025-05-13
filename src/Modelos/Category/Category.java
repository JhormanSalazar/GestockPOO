package Modelos.Category;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Integer categoryId;
    private String name;
    private String description;
    private Boolean isActive;

    // Lista estática para guardar las categorías
    private static List<Category> categorias = new ArrayList<>();

    // Constructor vacío
    public Category() {}

    // Constructor con parámetros
    public Category(Integer categoryId, String name, String description, Boolean isActive) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
    }

    // Getters y Setters
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    // Métodos CRUD estáticos

    public static void crearCategoria(Category category) {
        categorias.add(category);
    }

    public static List<Category> listarCategorias() {
        return categorias;
    }

    public static Category buscarCategoriaPorId(Integer id) {
        for (Category category : categorias) {
            if (category.getCategoryId().equals(id)) {
                return category;
            }
        }
        return null;
    }

    public static void eliminarCategoria(Integer id) {
        categorias.removeIf(category -> category.getCategoryId().equals(id));
    }

    public static class CategoryServices {
    }
}
