package dat.carport.model.entities.DBEntities;

import java.util.Objects;

public class DBMaterials {

    int id;
    String description;


    public DBMaterials(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBMaterials that = (DBMaterials) o;
        return id == that.id && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "DBMaterials{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
