package dat.carport.model.entities.DBEntities;

import dat.carport.model.entities.ServiceEntities.Customer;
import dat.carport.model.entities.ServiceEntities.CustomerRequest;
import dat.carport.model.entities.ServiceEntities.CustomerRequestData;

import java.util.Objects;

public class DBCustomerRequest {
    private int id;
    private String customerUserEmail;
    private String carportWidth;
    private String carportLength;
    private String roofType;
    private String roofMaterial;
    private String roofSlope;
    private String shedWidth;
    private String shedLength;


    public DBCustomerRequest(int id, String customerUserEmail, String carportWidth, String carportLength, String roofType, String roofMaterial, String roofSlope, String shedWidth, String shedLength) {
        this.id = id;
        this.customerUserEmail = customerUserEmail;
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.roofType = roofType;
        this.roofMaterial = roofMaterial;
        this.roofSlope = roofSlope;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
    }

    public DBCustomerRequest(CustomerRequest cr){
        this.id = cr.getId();
        this.customerUserEmail = cr.getCustomerUserEmail();
        CustomerRequestData data = cr.getRequestData();
        this.carportWidth = data.getCarportWidth();
        this.carportLength = data.getCarportLength();
        this.roofType = data.getRoofType();
        this.roofMaterial = data.getRoofMaterial();
        this.roofSlope = data.getRoofSlope();
        this.shedWidth = data.getShedWidth();
        this.shedLength = data.getShedLength();
    }

    public int getId() {
        return id;
    }

    public String getCustomerUserEmail() {
        return customerUserEmail;
    }

    public String getCarportWidth() {
        return carportWidth;
    }

    public String getCarportLength() {
        return carportLength;
    }

    public String getRoofType() {
        return roofType;
    }

    public String getRoofMaterial() {
        return roofMaterial;
    }

    public String getRoofSlope() {
        return roofSlope;
    }

    public String getShedWidth() {
        return shedWidth;
    }

    public String getShedLength() {
        return shedLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBCustomerRequest that = (DBCustomerRequest) o;
        return id == that.id && Objects.equals(customerUserEmail, that.customerUserEmail) && Objects.equals(carportWidth, that.carportWidth) && Objects.equals(carportLength, that.carportLength) && Objects.equals(roofType, that.roofType) && Objects.equals(roofMaterial, that.roofMaterial) && Objects.equals(roofSlope, that.roofSlope) && Objects.equals(shedWidth, that.shedWidth) && Objects.equals(shedLength, that.shedLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerUserEmail, carportWidth, carportLength, roofType, roofMaterial, roofSlope, shedWidth, shedLength);
    }

    @Override
    public String toString() {
        return "DBCustomerRequest{" +
                "id=" + id +
                ", customerUserEmail='" + customerUserEmail + '\'' +
                ", carportWidth='" + carportWidth + '\'' +
                ", carportLength='" + carportLength + '\'' +
                ", roofType='" + roofType + '\'' +
                ", roofMaterial='" + roofMaterial + '\'' +
                ", roofSlope='" + roofSlope + '\'' +
                ", shedWidth='" + shedWidth + '\'' +
                ", shedLength='" + shedLength + '\'' +
                '}';
    }
}
