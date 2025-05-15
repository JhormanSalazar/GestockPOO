package Modelos;

import java.util.List;

public abstract class BaseEntity implements CRUD<BaseEntity>{
    private Integer id;
    private String name;
    private String description;
    private Boolean availability;

    public BaseEntity() {

    }

    public BaseEntity(Integer id, String name, String description, Boolean availability) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.availability = true;
    }

    public abstract void crear(BaseEntity baseEntity);

    public abstract List<BaseEntity> listar();

    public abstract BaseEntity buscarPorId(Integer id);

    public abstract void eliminar(Integer id);
}
