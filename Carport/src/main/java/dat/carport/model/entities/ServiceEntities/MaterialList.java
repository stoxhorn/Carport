package dat.carport.model.entities.ServiceEntities;

import dat.carport.model.entities.DBEntities.DBCustomerRequest;

import java.util.ArrayList;

public class MaterialList {

    String raftersAmount = "";

    public boolean shedCheck (CustomerRequestData customerRequest) {
        boolean shed = false;
        int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
        int shedWidth = Integer.parseInt(customerRequest.getShedWidth().replaceAll("[^0-9]", ""));
        if(shedLength > 0 && shedWidth > 0) {
            shed = true;
        }
        return shed;
    }

    public String getPosts (CustomerRequestData customerRequest) {
        String name = "Trykimp. stolpe ";
        String amount = "";
        String height = " 97mm";
        String width = " 97mm";
        String length = " 300cm";
        String unit = " Enhed: stk.";
        String description = " stolper nedgraves 90 cm. i jord";
        boolean shed = shedCheck(customerRequest);
        int carportLength = Integer.parseInt(customerRequest.getCarportLength().replaceAll("[^0-9]", ""));
        int carportWidth = Integer.parseInt(customerRequest.getCarportWidth().replaceAll("[^0-9]", ""));
        int amountInt;
        if(carportWidth * carportLength / 4 < 8) {
            amountInt = 4;
        } else {
            amountInt = 6;
        }
        if(shed) {
            int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
            int shedWidth = Integer.parseInt(customerRequest.getShedWidth().replaceAll("[^0-9]", ""));
            amountInt = amountInt + 4;
            if (shedWidth > 3.1) {
                amountInt = amountInt + 2;
            }
            if (shedLength > 3.1) {
                amountInt = amountInt + 2;
            }
        }
        amount = String.valueOf(amountInt);
        return name + amount + height + width + length + unit + description;
    }

    public String getBase (CustomerRequestData customerRequest) {
        String name = "Spærtræ ubh. ";
        String amount = " 2";
        String height = " 195mm";
        String width = " 45mm";
        String length = "";
        String unit = " Enhed: stk.";
        String description = " Remme i sider, sadles ned i stolper";
        boolean shed = shedCheck(customerRequest);
        int carportLength = Integer.parseInt(customerRequest.getCarportLength().replaceAll("[^0-9]", ""));
        if(shed) {
            int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
            length = String.valueOf(carportLength - shedLength);
        } else {
            length = String.valueOf(carportLength);
        }
        return name + amount + height + width + length + "cm" + unit + description;
    }

    public String getShedBase (CustomerRequestData customerRequest) {
        String name = "Spærtræ ubh. ";
        String amount = " 1";
        String height = " 195mm";
        String width = " 45mm";
        String length = "";
        String unit = " Enhed: stk.";
        String description = " Remme i sider, sadles ned i stolper";
        int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
        length = String.valueOf(shedLength * 2);
        return name + amount + height + width + length + "cm" + unit + description;
    }

    public String getRafters (CustomerRequestData customerRequest) {
        String name = "Spærtræ ubh. ";
        raftersAmount = "";
        String height = " 195mm";
        String width = " 45mm";
        String length = "";
        String unit = " Enhed: stk.";
        String description = " Spær, monteres på rem";
        String carportWidth = customerRequest.getCarportWidth();
        int carportLength = Integer.parseInt(customerRequest.getCarportLength().replaceAll("[^0-9]", ""));
        length = carportWidth;
        int amountInt = (int) (carportLength / (0.55 + 0.045) + 2);
        raftersAmount = String.valueOf(amountInt);
        return name + raftersAmount + height + width + length + "cm" + unit + description;
    }

    public String getRafterFittings() {
        String name = "Universal 190 mm højre og venstre ";
        String unit = " Enhed: stk.";
        String description = " montering af spær på rem";
        return name + raftersAmount + unit + description;
    }

    public String getPerforatedtape() {
        String name = "Hulbånd 1x20 mm ";
        String amount = "";
        String height = " 1mm";
        String width = " 20mm";
        String length = "";
        String unit = " Enhed: Rulle";
        String description = " Til vindkryds på spær";


        return "";
    }

    public ArrayList<String> getMaterialList (CustomerRequestData customerRequest) {

        boolean shed = shedCheck(customerRequest);

        ArrayList<String> materialList = new ArrayList<>();

        materialList.add(getPosts(customerRequest));
        materialList.add(getBase(customerRequest));
        materialList.add(getRafters(customerRequest));
        materialList.add(getRafterFittings());
        if(shed) {
            materialList.add(getShedBase(customerRequest));
        }

        return materialList;
    }
}
