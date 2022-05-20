package dat.carport.model.entities.ServiceEntities;

import dat.carport.model.entities.DBEntities.DBCustomerRequest;

import java.util.ArrayList;

public class MaterialList {

    String raftersAmount = "";
    double hulbåndFinalLength;

    public boolean shedCheck (CustomerRequestData customerRequest) {
        boolean shed = true;
        String shedLength = customerRequest.getShedLength();
        String shedWidth = customerRequest.getShedWidth();
        if(shedLength == null || shedWidth == null) {
            shed = false;
        }
        return shed;
    }

    public String getStolper (CustomerRequestData customerRequest) {
        boolean shed = shedCheck(customerRequest);
        int carportLength = Integer.parseInt(customerRequest.getCarportLength().replaceAll("[^0-9]", ""));
        int carportWidth = Integer.parseInt(customerRequest.getCarportWidth().replaceAll("[^0-9]", ""));
        int amountInt;
        if(carportWidth * carportLength / 40000 < 8) {
            amountInt = 4;
        } else {
            amountInt = 6;
        }
        if(shed) {
            int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
            int shedWidth = Integer.parseInt(customerRequest.getShedWidth().replaceAll("[^0-9]", ""));
            amountInt = amountInt + 4;
            if (shedWidth > 310) {
                amountInt = amountInt + 2;
            }
            if (shedLength > 310) {
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

        Spær s = new Spær(raftersAmount, length);

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

        TrapezPladerSkruer trapezPladerSkruer = new TrapezPladerSkruer(amount);

        return trapezPladerSkruer.toString();
    }

    public String getVandBræt(CustomerRequestData customerRequest) {
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

        VandBræt vandBræt = new VandBræt(frontBackAmount, sideLength, frontBackLength);

        return vandBræt.toString();
    }

    public String getVandBrætSkruer() {
        VandBrætSkruer vandBrætSkruer = new VandBrætSkruer();

        return vandBrætSkruer.toString();
    }

    public String getDørLægte() {
        DørLægte dørLægte = new DørLægte();

        return dørLægte.toString();
    }

    public String getLøsholter(CustomerRequestData customerRequest) {
        int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
        int shedWidth = Integer.parseInt(customerRequest.getShedWidth().replaceAll("[^0-9]", ""));
        int gavlAmountInt = 6;
        if(shedLength > 270 && shedLength < 540) {
            gavlAmountInt = 12;
        } else if (shedLength >= 540) {
            gavlAmountInt = 24;
        }
        int sideAmountInt = 4;
        if(shedWidth > 240 && shedWidth < 480) {
            sideAmountInt = 8;
        } else if (shedWidth > 480) {
            sideAmountInt = 12;
        }
        String sideAmount = String.valueOf(sideAmountInt);
        String gavlAmount = String.valueOf(gavlAmountInt);


        Løsholter løsholter = new Løsholter(sideAmount, gavlAmount);

        return løsholter.toString();
    }

    public String getSkurBeklædning(CustomerRequestData customerRequest) {
        int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
        int shedWidth = Integer.parseInt(customerRequest.getShedWidth().replaceAll("[^0-9]", ""));

        int amountInt = (shedLength * 2 + shedWidth * 2) / 80;
        String amount = String.valueOf(amountInt);

        SkurBeklædning skurBeklædning = new SkurBeklædning(amount);

        return skurBeklædning.toString();
    }

    public String getBræddeBolte(CustomerRequestData customerRequest) {
        int carportLength = Integer.parseInt(customerRequest.getCarportLength().replaceAll("[^0-9]", ""));
        int carportWidth = Integer.parseInt(customerRequest.getCarportWidth().replaceAll("[^0-9]", ""));
        int amountInt;
        if(carportWidth * carportLength / 40000 < 8) {
            amountInt = 12;
        } else {
            amountInt = 18;
        }
        String amount = String.valueOf(amountInt);

        BræddeBolte bræddeBolte = new BræddeBolte(amount);

        return bræddeBolte.toString();
    }

    public String getFirkantSkiver(CustomerRequestData customerRequest) {
        int carportLength = Integer.parseInt(customerRequest.getCarportLength().replaceAll("[^0-9]", ""));
        int carportWidth = Integer.parseInt(customerRequest.getCarportWidth().replaceAll("[^0-9]", ""));
        int amountInt;
        if(carportWidth * carportLength / 40000 < 8) {
            amountInt = 8;
        } else {
            amountInt = 12;
        }
        String amount = String.valueOf(amountInt);

        Firkantskiver firkantskiver = new Firkantskiver(amount);

        return firkantskiver.toString();
    }

    public String getBeklædningSkruerYderst(CustomerRequestData customerRequest) {
        int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
        int shedWidth = Integer.parseInt(customerRequest.getShedWidth().replaceAll("[^0-9]", ""));

        int amountInt = (shedLength * 2 + shedWidth * 2) / 80;
        amountInt = amountInt * 4;

        int roundedAmount = ((amountInt + 399) / 400) * 400;
        String amount = String.valueOf(roundedAmount);

        BeklædningSkruerYderst beklædningSkruerYderst = new BeklædningSkruerYderst(amount);

        return beklædningSkruerYderst.toString();
    }

    public String getBeklædningSkruerInderst(CustomerRequestData customerRequest) {
        int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
        int shedWidth = Integer.parseInt(customerRequest.getShedWidth().replaceAll("[^0-9]", ""));

        int amountInt = (shedLength * 2 + shedWidth * 2) / 80;
        amountInt = amountInt * 3;

        int roundedAmount = ((amountInt + 299) / 300) * 300;
        String amount = String.valueOf(roundedAmount);

        BeklædningSkruerInderst beklædningSkruerInderst = new BeklædningSkruerInderst(amount);

        return beklædningSkruerInderst.toString();
    }

    public String getStalddørsgreb() {
        Stalddørsgreb stalddørsgreb = new Stalddørsgreb();

        return stalddørsgreb.toString();
    }

    public String getTHængsel() {
        THængsel tHængsel = new THængsel();

        return tHængsel.toString();
    }

    public String getVinkelBeslag(CustomerRequestData customerRequest) {
        int shedLength = Integer.parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
        int shedWidth = Integer.parseInt(customerRequest.getShedWidth().replaceAll("[^0-9]", ""));
        int gavlAmountInt = 12;
        if(shedLength > 270 && shedLength < 540) {
            gavlAmountInt = 24;
        } else if (shedLength >= 540) {
            gavlAmountInt = 48;
        }
        int sideAmountInt = 8;
        if(shedWidth > 240 && shedWidth < 480) {
            sideAmountInt = 16;
        } else if (shedWidth > 480) {
            sideAmountInt = 24;
        }
        int totalAmount = gavlAmountInt + sideAmountInt;
        String amount = String.valueOf(totalAmount);

        VinkelBeslag vinkelBeslag = new VinkelBeslag(amount);

        return vinkelBeslag.toString();
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
        materialList.add(getVandBræt(customerRequest));
        materialList.add(getVandBrætSkruer());
        materialList.add(getBræddeBolte(customerRequest));
        materialList.add(getFirkantSkiver(customerRequest));
        if(shed) {
            materialList.add(getShedRem(customerRequest));
            materialList.add(getDørLægte());
            materialList.add(getLøsholter(customerRequest));
            materialList.add(getSkurBeklædning(customerRequest));
            materialList.add(getBeklædningSkruerYderst(customerRequest));
            materialList.add(getBeklædningSkruerInderst(customerRequest));
            materialList.add(getStalddørsgreb());
            materialList.add(getTHængsel());
            materialList.add(getVinkelBeslag(customerRequest));
        }

        return materialList;
    }
}
