package Modelos.Products;

import Modelos.CRUD;

import java.util.ArrayList;
import java.util.List;

public class ProductServices implements CRUD<Product> {

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
      if (product.getProductId().equals(id)) {
        return product;
      }
    }
    return null;
  }

  public void eliminar(Integer id) {
    productos.removeIf(product -> product.getProductId().equals(id));
  }

}
