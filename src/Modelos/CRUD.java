package Modelos;

import java.util.List;

public interface CRUD<T> {

  void crear(T entidad);
  List<T> listar();
  T buscarPorId(Integer id);
  void eliminar(Integer id);

}
