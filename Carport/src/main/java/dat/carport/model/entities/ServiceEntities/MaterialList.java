package dat.carport.model.entities.ServiceEntities;

import dat.carport.model.entities.DBEntities.DBCustomer;
import dat.carport.model.entities.DBEntities.DBCustomerRequest;

public class MaterialList {

    public String posts (DBCustomerRequest customerRequest) {
        String name = "Trykimp. stolpe";
        String amount = "";
        String height = "97cm";
        String width = "97cm";
        String length = "300cm";
        String unit = "Enhed: stk.";
        String description = "stolper nedgraves 90 cm. i jord";
        int carportLength = Integer.parseInt(customerRequest.getCarportLength());
        int carportWidth = Integer.parseInt(customerRequest.getCarportWidth());
        if(carportWidth * carportLength / 4 < 8) {
            amount = "antal: 4";
        } else {
            amount = "antal: 6";
        }
        return name + amount + height + width + length + unit + description;
    }

    public String base (DBCustomerRequest customerRequest) {
        String name = "Spærtræ ubh";
        String amount = "2";
        String height = "195cm";
        String width = "45cm";
        String length = "";
        String unit = "Enhed: stk.";
        String description = "Remme i sider, sadles ned i stolper";
        String carportLength = customerRequest.getCarportLength();
        length = carportLength;
        return name + amount + height + width + length + unit + description;
    }

    public String rafters (DBCustomerRequest customerRequest) {
        return "";
    }
}
