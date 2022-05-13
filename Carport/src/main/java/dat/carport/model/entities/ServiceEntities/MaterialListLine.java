package dat.carport.model.entities.ServiceEntities;

import dat.carport.model.entities.DBEntities.DBMaterials;
import dat.carport.model.entities.DBEntities.DBMaterialsListLines;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.MaterialsMapper;

import java.util.Objects;

public class MaterialListLine {

    private int id;
    private int materialsListId;
    private int materialsId;
    private Materials material;
    private String description;
    private int quantity;


    public MaterialListLine(int id, int materialsListId, int materialsId, Materials material, String description, int quantity) {
        this.id = id;
        this.materialsListId = materialsListId;
        this.materialsId = materialsId;
        this.material = material;
        this.description = description;
        this.quantity = quantity;
    }

    /**
     * overloaded constructor, intention is that you can made a materialListline,
     * with only the material ID, and not a material Object
     * and it will call the mapper to find the proper material by itself.
     * Currently not finished because mapper is not done
     * @param id
     * @param materialsListId
     * @param materialsId
     * @param description
     * @param quantity
     */
    public MaterialListLine(int id, int materialsListId, int materialsId, String description, int quantity) {
        this.id = id;
        this.materialsListId = materialsListId;
        this.materialsId = materialsId;
        this.description = description;
        this.quantity = quantity;
    }

    public MaterialListLine(DBMaterialsListLines dbmll){
        this.id = dbmll.getId();
        this.description = dbmll.getDescription();
        this.materialsId = dbmll.getMaterialsId();
        this.materialsListId = dbmll.getMaterialsListId();
        this.quantity = dbmll.getQuantity();
    }

    public void fetchMaterial(ConnectionPool cp) throws DatabaseException {
        MaterialsMapper mMapper = new MaterialsMapper(cp);
        for(DBMaterials dbm : mMapper.getMaterials()){
            if(dbm.getId() == this.id){
                this.material = new Materials(dbm);
                return;
            }
        }
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

    public Materials getMaterial() {
        return material;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaterialsListId(int materialsListId) {
        this.materialsListId = materialsListId;
    }

    public void setMaterialsId(int materialsId) {
        this.materialsId = materialsId;
    }

    public void setMaterial(Materials material) {
        this.material = material;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialListLine that = (MaterialListLine) o;
        return id == that.id && materialsListId == that.materialsListId && materialsId == that.materialsId && quantity == that.quantity && Objects.equals(material, that.material) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, materialsListId, materialsId, material, description, quantity);
    }

    public String detailedString(){
        return "id=" + id +
                ", materialsListId=" + materialsListId +
                ", materialsId=" + materialsId +
                ", material=" + material +
                ", description='" + description +
                ", quantity=" + quantity + "\n";
    }

    @Override
    public String toString() {
        return  quantity + "x " + material +
                ", " + description + "\n";
    }
}
