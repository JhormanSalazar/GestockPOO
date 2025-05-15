package Modelos.Users;

import Modelos.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class User extends BaseEntity<User> {
    private String email;
    private String password;
    private Boolean isActive = true;

    public User() {
    }

    public User(String email, String password, Boolean isActive) {
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    public User(Integer id, String name, String email, String password) {
        super(id, name, null, null);
        this.email = email;
        this.password = password;
    }

    private static List<User> usuarios = new ArrayList<>();

    @Override
    public void crear(User user) {
        usuarios.add(user);
    }

    @Override
    public List<User> listar() {
        return usuarios;
    }

    @Override
    public User buscarPorId(Integer id) {
        for (User user : usuarios) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        usuarios.removeIf(user -> user.getId().equals(id));
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

    public static List<User> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(List<User> usuarios) {
        User.usuarios = usuarios;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
