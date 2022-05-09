package dat.carport.model.entities.ServiceEntities;

import java.util.Objects;

/**
 * Simply created to decouple data from request.
 * Thought it could be useful for handling potential calculations,
 * or asking for roof info separately from shed info or something,
 * which could simplify things down the line.
 */
public class CustomerRequestData {

    String carportWidth;
    String carportLength;
    String roofType;
    String roofMaterial;
    String roofSlope;
    String shedWidth;
    String shedLength;

    public CustomerRequestData(String carportWidth, String carportLength, String roofType, String roofMaterial, String roofSlope, String shedWidth, String shedLength) {
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.roofType = roofType;
        this.roofMaterial = roofMaterial;
        this.roofSlope = roofSlope;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
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
        CustomerRequestData that = (CustomerRequestData) o;
        return Objects.equals(carportWidth, that.carportWidth) && Objects.equals(carportLength, that.carportLength) && Objects.equals(roofType, that.roofType) && Objects.equals(roofMaterial, that.roofMaterial) && Objects.equals(roofSlope, that.roofSlope) && Objects.equals(shedWidth, that.shedWidth) && Objects.equals(shedLength, that.shedLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carportWidth, carportLength, roofType, roofMaterial, roofSlope, shedWidth, shedLength);
    }

    @Override
    public String toString() {
        return "CustomerRequestData{" +
                "carportWidth='" + carportWidth + '\'' +
                ", carportLength='" + carportLength + '\'' +
                ", roofType='" + roofType + '\'' +
                ", roofMaterial='" + roofMaterial + '\'' +
                ", roofSlope='" + roofSlope + '\'' +
                ", shedWidth='" + shedWidth + '\'' +
                ", shedLength='" + shedLength + '\'' +
                '}';
    }
}
