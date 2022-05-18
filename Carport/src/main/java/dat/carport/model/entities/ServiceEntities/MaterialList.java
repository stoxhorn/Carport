package dat.carport.model.entities.ServiceEntities;

import dat.carport.model.entities.DBEntities.DBCustomerRequest;

import java.util.ArrayList;

public class MaterialList {

    String raftersAmount = "";
    double hulbåndFinalLength;

    public boolean shedCheck (CustomerRequestData customerRequest) {
        boolean shed = false;
        int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
        int shedWidth = Integer.parseInt(customerRequest.getShedWidth().replaceAll("[^0-9]", ""));
        if(shedLength > 0 && shedWidth > 0) {
            shed = true;
        }
        return shed;
    }

    public String getStolper (CustomerRequestData customerRequest) {

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
         Stolpe s = new Stolpe(String.valueOf(amountInt));
        return s.toString();
    }

    public String getRem (CustomerRequestData customerRequest) {
        String length = "";

        boolean shed = shedCheck(customerRequest);
        int carportLength = Integer.parseInt(customerRequest.getCarportLength().replaceAll("[^0-9]", ""));
        if(shed) {
            int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
            length = String.valueOf(carportLength - shedLength);
        } else {
            length = String.valueOf(carportLength);
        }

        Rem r = new Rem(length);

        return r.toString();
    }

    public String getShedRem (CustomerRequestData customerRequest) {
        String length = "";

        int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
        length = String.valueOf(shedLength * 2);

        RemSkur remSkur = new RemSkur(length);

        return remSkur.toString();
    }

    public String getSpær (CustomerRequestData customerRequest) {

        int carportLength = Integer.parseInt(customerRequest.getCarportLength().replaceAll("[^0-9]", ""));
        String length = customerRequest.getCarportWidth();
        int amountInt = (int) (carportLength / (0.55 + 0.045) + 2);
        raftersAmount = String.valueOf(amountInt);

        Spær s = new Spær(customerRequest.getCarportWidth(), raftersAmount, length);

        return s.toString();
    }

    public String getSpærBeslag() {
        SpærBeslag spærBeslag = new SpærBeslag(raftersAmount);

        return spærBeslag.toString();
    }

    public String getHulbånd(CustomerRequestData customerRequest) {
        int carportLength = Integer.parseInt(customerRequest.getCarportLength().replaceAll("[^0-9]", ""));
        int carportWidth = Integer.parseInt(customerRequest.getCarportWidth().replaceAll("[^0-9]", ""));
        int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
        double widthDouble = carportWidth;
        double lengthDouble = carportLength - 0.595 - shedLength;
        double hulbåndLength = Math.pow(widthDouble,2) + Math.pow(lengthDouble,2);
        hulbåndFinalLength = Math.sqrt(hulbåndLength);
        int amountInt = (int) Math.ceil(hulbåndFinalLength);
        String amount = String.valueOf(amountInt);
        String length = String.valueOf(hulbåndFinalLength);

        Hulbånd hulbånd = new Hulbånd(amount, length);

        return hulbånd.toString();
    }

    public String getBeslagskruer() {
        int raftersAmountInt = Integer.parseInt(raftersAmount);
        int firstAmountInt = raftersAmountInt * 2 * 9;
        int secondAmountInt = (int) ((hulbåndFinalLength / 0.595 + 2) * 2);
        int amountInt = firstAmountInt + secondAmountInt;
        //Antallet rundes op da skruerne kommer i pakker af 250
        int roundedAmount = ((amountInt + 249) / 250) * 250;
        String amount = String.valueOf(roundedAmount);

        Beslagskruer beslagskruer = new Beslagskruer(amount);

        return beslagskruer.toString();
    }

    public String getUnderStern(CustomerRequestData customerRequest) {
        String frontBackLength = customerRequest.getCarportWidth();
        String sideLength = customerRequest.getCarportLength();

        UnderStern underStern = new UnderStern(sideLength, frontBackLength);

        return underStern.toString();
    }

    public String getOverStern(CustomerRequestData customerRequest) {
        boolean shed = shedCheck(customerRequest);
        String frontBackLength = customerRequest.getCarportWidth();
        String sideLength = customerRequest.getCarportLength();
        String frontBackAmount;
        int amountNoShedInt = 4;
        frontBackAmount = String.valueOf(amountNoShedInt);
        if(shed) {
            int amountShedInt = 2;
            frontBackAmount = String.valueOf(amountShedInt);
        }

        OverStern overStern = new OverStern(frontBackAmount, sideLength, frontBackLength);

        return overStern.toString();

    }

    public String getTrapezPlader(CustomerRequestData customerRequest) {
        int carportLength = Integer.parseInt(customerRequest.getCarportLength().replaceAll("[^0-9]", ""));
        int carportWidth = Integer.parseInt(customerRequest.getCarportWidth().replaceAll("[^0-9]", ""));
        int amountInt = carportWidth;
        int lengthInt = 6;
        double lengthDouble = 3.6;
        if(carportLength > 6) {
            amountInt = amountInt * 2;
        }
        String amount = String.valueOf(amountInt);
        String length = String.valueOf(lengthInt);
        String secondLength = String.valueOf(lengthDouble);
        if(carportLength > 6) {
            //Hvis taget er over 6 meter bruges ekstra plader som er 3,6 meter lange og overlappes så det passer
            String finalLength = length + secondLength;
            TrapezPlader trapezPlader = new TrapezPlader(finalLength, amount);
            return trapezPlader.toString();
        } else {
            TrapezPlader trapezPlader = new TrapezPlader(length, amount);
            return trapezPlader.toString();
        }
    }

    public String getTrapezPladerSkruer(CustomerRequestData customerRequest) {
        int carportLength = Integer.parseInt(customerRequest.getCarportLength().replaceAll("[^0-9]", ""));
        int carportWidth = Integer.parseInt(customerRequest.getCarportWidth().replaceAll("[^0-9]", ""));
        int carportArea = carportLength * carportWidth;
        int amountInt = 12 * carportArea;
        //Rundes op da de kommer i pakker af 200
        int roundedAmount = ((amountInt + 199) / 200) * 200;
        String amount = String.valueOf(roundedAmount);

        return "";
    }


    public ArrayList<String> getMaterialList (CustomerRequestData customerRequest) {

        boolean shed = shedCheck(customerRequest);

        ArrayList<String> materialList = new ArrayList<>();

        materialList.add(getStolper(customerRequest));
        materialList.add(getRem(customerRequest));
        materialList.add(getSpær(customerRequest));
        materialList.add(getSpærBeslag());
        materialList.add(getHulbånd(customerRequest));
        materialList.add(getBeslagskruer());
        materialList.add(getUnderStern(customerRequest));
        materialList.add(getOverStern(customerRequest));
        materialList.add(getTrapezPlader(customerRequest));
        materialList.add(getTrapezPladerSkruer(customerRequest));
        if(shed) {
            materialList.add(getShedRem(customerRequest));
        }

        return materialList;
    }
}
