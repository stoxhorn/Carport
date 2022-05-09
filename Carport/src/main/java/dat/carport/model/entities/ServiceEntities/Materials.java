package dat.carport.model.entities.ServiceEntities;

import java.util.Objects;

public class Materials {
    private int id;
    private String description;

    public Materials(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materials materials = (Materials) o;
        return id == materials.id && description.equals(materials.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
