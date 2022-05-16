package dat.carport.model.entities.ServiceEntities;

import dat.carport.model.entities.DBEntities.DBCustomerRequest;
import dat.carport.model.entities.DBEntities.DBMaterialsList;
import dat.carport.model.exceptions.DatabaseException;
import dat.carport.model.persistence.ConnectionPool;
import dat.carport.model.persistence.MaterialListMapper;

public class CustomerRequest {
    private int id;
    private String customerUserEmail;
    private CustomerRequestData requestData;
    private MaterialsList materialList;

    public CustomerRequest(int id, String customerUserEmail, String carportWidth, String carportLength, String roofType, String roofMaterial, String roofSlope, String shedWidth, String shedLength) {
        this.id = id;
        this.customerUserEmail = customerUserEmail;
        this.requestData = new CustomerRequestData(carportWidth, carportLength, roofType, roofMaterial, roofSlope, shedWidth, shedLength);
    }

    public CustomerRequest(int id, String customerUserEmail, CustomerRequestData requestData){
        this.id = id;
        this.customerUserEmail = customerUserEmail;
        this.requestData = requestData;
    }

    public CustomerRequest(DBCustomerRequest dbcr){
        this.id = dbcr.getId();
        this.customerUserEmail = dbcr.getCustomerUserEmail();
        this.requestData = new CustomerRequestData(
                                            dbcr.getCarportWidth(),
                                            dbcr.getCarportLength(),
                                            dbcr.getRoofType(),
                                            dbcr.getRoofMaterial(),
                                            dbcr.getRoofSlope(),
                                            dbcr.getShedWidth(),
                                            dbcr.getShedLength()
                );
    }

    public void fetchMaterialList(ConnectionPool cp) throws DatabaseException {
        MaterialListMapper mlMapper = new MaterialListMapper(cp);
        // go through all materialslists in the database
        for(DBMaterialsList dbMl : mlMapper.getMaterialList()){
            // check if it's customerrequest ID corresponds to this' ID
            if(dbMl.getCustomerRequestId() == this.id){
                // create the service entity
                MaterialsList ml = new MaterialsList(dbMl);
                // fetch the listlines
                ml.fetchMaterialsListLines(cp);
                // save it
                this.materialList = ml;
                return;
            }
        }
    }

    public void setMaterialList(MaterialsList mList){
        this.materialList = mList;
    }

    public CustomerRequestData getRequestData(){
        return this.requestData;
    }

    public MaterialsList getMaterialList(){
        return this.materialList;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "id=" + id +
                ", customerUserEmail='" + customerUserEmail + '\'' +
                ", requestData=" + requestData +
                ", materialList=" + materialList +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getCustomerUserEmail() {
        return customerUserEmail;
    }
}
