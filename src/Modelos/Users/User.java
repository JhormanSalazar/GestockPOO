package Modelos.Users;

import Modelos.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class User extends BaseEntity {
    private String email;
    private String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(Integer id, String name, String description, Boolean availability, String email, String password) {
        super(id, name, description, availability);
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
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        usuarios.removeIf(user -> user.getUserId().equals(id));
    }
}
