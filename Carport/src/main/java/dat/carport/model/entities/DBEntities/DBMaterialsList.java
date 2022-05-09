package dat.carport.model.entities.DBEntities;

import java.util.Objects;

public class DBMaterialsList {

    private int id;
    private int customerRequestId;


    public DBMaterialsList(int id, int customerRequestId) {
        this.id = id;
        this.customerRequestId = customerRequestId;
    }

    public int getId() {
        return id;
    }

    public int getCustomerRequestId() {
        return customerRequestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBMaterialsList that = (DBMaterialsList) o;
        return id == that.id && customerRequestId == that.customerRequestId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerRequestId);
    }

    @Override
    public String toString() {
        return "DBMaterialsList{" +
                "id=" + id +
                ", customerRequestId=" + customerRequestId +
                '}';
    }
}
