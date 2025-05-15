package Modelos.Categories;

import Modelos.CRUD;
import java.util.ArrayList;
import java.util.List;

public class CategoryServices implements CRUD<Category> {

    private static List<Category> categories = new ArrayList<>();

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
            if (category.getCategoryId().equals(id)) {
                return category;
            }
        }
        return null;
    }

    public void eliminar(Integer id) {
        categories.removeIf(category -> category.getCategoryId().equals(id));
    }
}
