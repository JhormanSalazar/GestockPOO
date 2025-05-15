package Modelos;

import java.util.List;

public abstract class BaseEntity<T> implements CRUD<T>{
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
