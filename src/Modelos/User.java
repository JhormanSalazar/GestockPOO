package Modelos;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer userId;
    private String name;
    private String email;
    private String password;
    private List<Inventory> inventories;

    // Lista estática para guardar los usuarios
    private static List<User> usuarios = new ArrayList<>();

    // Constructor vacío
    public User() {}

    // Constructor con parámetros
    public User(Integer userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters y Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Métodos CRUD estáticos

    public static void crearUsuario(User user) {
        usuarios.add(user);
    }

    public static List<User> listarUsuarios() {
        return usuarios;
    }

    public static User buscarUsuarioPorId(Integer id) {
        for (User user : usuarios) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public static void eliminarUsuario(Integer id) {
        usuarios.removeIf(user -> user.getUserId().equals(id));
    }
}
