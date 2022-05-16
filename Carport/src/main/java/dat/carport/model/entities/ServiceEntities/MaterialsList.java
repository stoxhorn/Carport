package dat.carport.model.entities.ServiceEntities;

import dat.carport.model.entities.DBEntities.DBMaterialsList;
import dat.carport.model.entities.DBEntities.DBMaterialsListLines;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.MaterialListLinesMapper;

import java.util.ArrayList;
import java.util.Objects;

public class MaterialsList {
    private int id;
    private int customerRequestId;
    private ArrayList<MaterialListLine> lines;


    public MaterialsList(int id, int customerRequestId, ArrayList<MaterialListLine> lines) {
        this.id = id;
        this.customerRequestId = customerRequestId;
        this.lines = lines;
    }

    public MaterialsList(int id, int customerRequestId){
        this.id = id;
        this.customerRequestId = customerRequestId;
        this.lines = new ArrayList<>();
    }

    public MaterialsList(DBMaterialsList dbml){
        this.id = dbml.getId();
        this.customerRequestId = dbml.getCustomerRequestId();
        this.lines = new ArrayList<>();

    }

    public void fetchMaterialsListLines(ConnectionPool cp) throws DatabaseException {
        MaterialListLinesMapper mllMapper = new MaterialListLinesMapper(cp);

        for(DBMaterialsListLines dbMll : mllMapper.getMaterialListLines()){
            // check if the materialslistline belongs to this materialslist
            if(dbMll.getMaterialsListId() == this.id){
                // create the service Entity
                MaterialListLine mll = new MaterialListLine(dbMll);
                // fetch the Material object from database
                mll.fetchMaterial(cp);
                // add this to listlines array
                this.lines.add(mll);
            }
        }
    }

    public void addListLine(MaterialListLine ll){
        this.lines.add(ll);
    }

    public void removeListLineById(int id){
        for(MaterialListLine mll : lines){
            if(mll.getId() == id){
                this.lines.remove(mll);
                return;
            }
        }
    }

    public void removeListLineByObject(MaterialListLine mll){
        this.lines.remove(mll);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerRequestId() {
        return customerRequestId;
    }

    public void setCustomerRequestId(int customerRequestId) {
        this.customerRequestId = customerRequestId;
    }

    public ArrayList<MaterialListLine> getLines() {
        return lines;
    }

    public void setLines(ArrayList<MaterialListLine> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialsList that = (MaterialsList) o;
        return id == that.id && customerRequestId == that.customerRequestId && Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerRequestId, lines);
    }

    @Override
    public String toString() {
        String tmp = "";

        for(MaterialListLine mll : this.lines){
            tmp += mll + "\n";
        }

        return "MaterialList " +
                "id: " + id +
                ", customerRequestId: " + customerRequestId +
                "\nlines:\n" + tmp;
    }

}
