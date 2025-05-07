package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Integer inventoryId;
    private String name;
    private String description;
    private String inventoryImage;
    private Boolean isActive;
    private User user; // Asociación con User

    // Lista estática para guardar los inventarios
    private static List<Inventory> inventarios = new ArrayList<>();

    // Constructor vacío
    public Inventory() {}

    // Constructor con parámetros
    public Inventory(Integer inventoryId, String name, String description, String inventoryImage, Boolean isActive, User user) {
        this.inventoryId = inventoryId;
        this.name = name;
        this.description = description;
        this.inventoryImage = inventoryImage;
        this.isActive = isActive;
        this.user = user;
    }

    // Getters y Setters
    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
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

    public String getInventoryImage() {
        return inventoryImage;
    }

    public void setInventoryImage(String inventoryImage) {
        this.inventoryImage = inventoryImage;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Métodos CRUD estáticos

    public static void crearInventario(Inventory inventory) {
        inventarios.add(inventory);
    }

    public static List<Inventory> listarInventarios() {
        return inventarios;
    }

    public static Inventory buscarInventarioPorId(Integer id) {
        for (Inventory inventory : inventarios) {
            if (inventory.getInventoryId().equals(id)) {
                return inventory;
            }
        }
        return null;
    }

    public static void eliminarInventario(Integer id) {
        inventarios.removeIf(inventory -> inventory.getInventoryId().equals(id));
    }
}
