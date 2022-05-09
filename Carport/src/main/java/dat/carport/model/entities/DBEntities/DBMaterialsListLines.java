package dat.carport.model.entities.DBEntities;

import java.util.Objects;

public class DBMaterialsListLines {
    private int id;
    private int materialsListId;
    private int materialsId;
    private String description;
    private int quantity;


    public DBMaterialsListLines(int id, int materialsListId, int materialsId, String description, int quantity) {
        this.id = id;
        this.materialsListId = materialsListId;
        this.materialsId = materialsId;
        this.description = description;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getMaterialsListId() {
        return materialsListId;
    }

    public int getMaterialsId() {
        return materialsId;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBMaterialsListLines that = (DBMaterialsListLines) o;
        return id == that.id && materialsListId == that.materialsListId && materialsId == that.materialsId && quantity == that.quantity && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, materialsListId, materialsId, description, quantity);
    }

    @Override
    public String toString() {
        return "DBMaterialsListLines{" +
                "id=" + id +
                ", materialsListId=" + materialsListId +
                ", materialsId=" + materialsId +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
