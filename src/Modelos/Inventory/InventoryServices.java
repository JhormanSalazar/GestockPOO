package Modelos.Inventory;

import Modelos.CRUD;

import java.util.ArrayList;
import java.util.List;

public class InventoryServices implements CRUD<Inventory> {

  private static List<Inventory> inventarios = new ArrayList<>();

  @Override
  public void crear(Inventory inventory) {
    inventarios.add(inventory);
  }

  @Override
  public List<Inventory> listar() {
    return inventarios;
  }

  @Override
  public Inventory buscarPorId(Integer id) {
    for (Inventory inventory : inventarios) {
      if (inventory.getInventoryId().equals(id)) {
        return inventory;
      }
    }
    return null;
  }

  public void eliminar(Integer id) {
    inventarios.removeIf(inventory -> inventory.getInventoryId().equals(id));
  }
}
