package Modelos.Users;

import Modelos.CRUD;

import java.util.ArrayList;
import java.util.List;

public class UserServices implements CRUD<User> {

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
