package dat.carport.model.entities.ServiceEntities;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class MaterialList {

    public ArrayList<String> materialList;
    private String raftersAmount = "";
    private double hulbåndFinalLength;

    public MaterialList(CustomerRequestData customerRequestData)
    {
        this.materialList = getMaterialList(customerRequestData);
    }

    public int getCarportLength(CustomerRequestData customerRequest) {
        return parseInt(customerRequest.getCarportLength().replaceAll("[^0-9]", ""));
    }

    public int getCarportWidth(CustomerRequestData customerRequest) {
        return parseInt(customerRequest.getCarportWidth().replaceAll("[^0-9]", ""));
    }

    public int getShedLength(CustomerRequestData customerRequest) {
        return parseInt(customerRequest.getShedLength().replaceAll("[^0-9]", ""));
    }

    public int getShedWidth(CustomerRequestData customerRequest) {
        return parseInt(customerRequest.getShedWidth().replaceAll("[^0-9]", ""));
    }

    public boolean shedCheck (CustomerRequestData customerRequest) {
        boolean shed = true;
        String shedLength = customerRequest.getShedLength();
        String shedWidth = customerRequest.getShedWidth();
        if(shedLength == null || shedWidth == null) {
            shed = false;
        }
        return shed;
    }

    private String getStolper (CustomerRequestData customerRequest) {
        boolean shed = shedCheck(customerRequest);
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
        int amountInt;
        if(carportWidth * carportLength / 40000 < 8) {
            amountInt = 4;
        } else {
            amountInt = 6;
        }
        if(shed) {
            int shedLength = getShedLength(customerRequest);
            int shedWidth = getShedWidth(customerRequest);
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

    private String getRem (CustomerRequestData customerRequest) {
        String length = "";

        boolean shed = shedCheck(customerRequest);
        int carportLength = getCarportLength(customerRequest);
        if(shed) {
            int shedLength = getShedLength(customerRequest);
            if(shedLength > carportLength) {
                length = String.valueOf(shedLength);
            } else {
                length = String.valueOf(carportLength - shedLength);
            }
        } else {
            length = String.valueOf(carportLength);
        }

        Rem r = new Rem(length);

        return r.toString();
    }

    private String getShedRem (CustomerRequestData customerRequest) {
        String length = "";

        int shedWidth = getShedWidth(customerRequest);
        length = String.valueOf(shedWidth * 2);

        RemSkur remSkur = new RemSkur(length);

        return remSkur.toString();
    }

    private String getSpær (CustomerRequestData customerRequest) {

        int carportLength = getCarportLength(customerRequest);
        String length = customerRequest.getCarportWidth();
        int amountInt = (int) (carportLength / (55 + 4.5) + 2);
        raftersAmount = String.valueOf(amountInt);

        Spær s = new Spær(raftersAmount, length);

        return s.toString();
    }

    private String getSpærBeslag() {
        SpærBeslag spærBeslag = new SpærBeslag(raftersAmount);

        return spærBeslag.toString();
    }

    private String getHulbånd(CustomerRequestData customerRequest) {
        boolean shed = shedCheck(customerRequest);
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
        int shedLength = shed ? getShedLength(customerRequest) : 0;
        double widthDouble = carportWidth;
        widthDouble = widthDouble / 100;        
        double lengthDouble = (carportLength - (55 + 4.5) - shedLength);
        lengthDouble = lengthDouble / 100;
        double hulbåndLength = Math.pow(widthDouble,2) + Math.pow(lengthDouble,2);
        hulbåndFinalLength = Math.sqrt(hulbåndLength);
        int lengthInt = (int) Math.ceil(hulbåndFinalLength);
        int amountInt = (int) Math.ceil(hulbåndFinalLength/10);
        String amount = String.valueOf(amountInt);
        String length = String.valueOf(lengthInt);

        Hulbånd hulbånd = new Hulbånd(amount, length);

        return hulbånd.toString();
    }

    private String getBeslagskruer() {
        int raftersAmountInt = parseInt(raftersAmount);
        int firstAmountInt = raftersAmountInt * 2 * 9;
        int secondAmountInt = (int) ((hulbåndFinalLength / 0.595 + 2) * 2);
        int amountInt = firstAmountInt + secondAmountInt;
        //Antallet rundes op da skruerne kommer i pakker af 250
        int roundedAmount = ((amountInt + 249) / 250);
        String amount = String.valueOf(roundedAmount);

        Beslagskruer beslagskruer = new Beslagskruer(amount);

        return beslagskruer.toString();
    }

    private String getUnderStern(CustomerRequestData customerRequest) {
        String frontBackLength = customerRequest.getCarportWidth();
        String sideLength = customerRequest.getCarportLength();

        UnderStern underStern = new UnderStern(sideLength, frontBackLength);

        return underStern.toString();
    }

    private String getOverStern(CustomerRequestData customerRequest) {
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

    private String getTrapezPlader(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
        double amountDouble = carportWidth;
        amountDouble = amountDouble/100;
        int amountInt = (int) Math.ceil(amountDouble);
        int lengthInt = 600;
        double lengthDouble = 360;
        if(carportLength > 600) {
            amountInt = amountInt * 2;
        }
        String amount = String.valueOf(amountInt);
        String length = String.valueOf(lengthInt);
        String secondLength = String.valueOf(lengthDouble);
        if(carportLength > 600) {
            //Hvis taget er over 6 meter bruges ekstra plader som er 3,6 meter lange og overlappes så det passer
            String finalLength = length + secondLength;
            TrapezPlader trapezPlader = new TrapezPlader(amount, finalLength);
            return trapezPlader.toString();
        } else {
            TrapezPlader trapezPlader = new TrapezPlader(amount, length);
            return trapezPlader.toString();
        }
    }

    private String getTrapezPladerSkruer(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        double lengthDouble = carportLength;
        lengthDouble = lengthDouble/100;
        int carportWidth = getCarportWidth(customerRequest);
        double widthDouble = carportWidth;
        widthDouble = widthDouble/100;
        int carportArea = (int) Math.ceil(lengthDouble * widthDouble);
        int amountInt = 12 * carportArea;
        //Rundes op da de kommer i pakker af 200
        int roundedAmount = ((amountInt + 199) / 200);
        String amount = String.valueOf(roundedAmount);

        TrapezPladerSkruer trapezPladerSkruer = new TrapezPladerSkruer(amount);

        return trapezPladerSkruer.toString();
    }

    private String getVandBræt(CustomerRequestData customerRequest) {
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

    private String getVandBrætSkruer() {
        VandBrætSkruer vandBrætSkruer = new VandBrætSkruer();

        return vandBrætSkruer.toString();
    }

    private String getDørLægte() {
        DørLægte dørLægte = new DørLægte();

        return dørLægte.toString();
    }

    private String getLøsholter(CustomerRequestData customerRequest) {
        int shedLength = getShedLength(customerRequest);
        int shedWidth = getShedWidth(customerRequest);
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

    private String getSkurBeklædning(CustomerRequestData customerRequest) {
        int shedLength = getShedLength(customerRequest);
        int shedWidth = getShedWidth(customerRequest);

        int amountInt = (shedLength * 2 + shedWidth * 2) / 80;
        String amount = String.valueOf(amountInt);

        SkurBeklædning skurBeklædning = new SkurBeklædning(amount);

        return skurBeklædning.toString();
    }

    private String getBræddeBolte(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
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

    private String getFirkantSkiver(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
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

    private String getBeklædningSkruerYderst(CustomerRequestData customerRequest) {
        int shedLength = getShedLength(customerRequest);
        int shedWidth = getShedWidth(customerRequest);

        int amountInt = (shedLength * 2 + shedWidth * 2) / 80;
        amountInt = amountInt * 4;

        int roundedAmount = ((amountInt + 399) / 400);
        String amount = String.valueOf(roundedAmount);

        BeklædningSkruerYderst beklædningSkruerYderst = new BeklædningSkruerYderst(amount);

        return beklædningSkruerYderst.toString();
    }

    private String getBeklædningSkruerInderst(CustomerRequestData customerRequest) {
        int shedLength = getShedLength(customerRequest);
        int shedWidth = getShedWidth(customerRequest);

        int amountInt = (shedLength * 2 + shedWidth * 2) / 80;
        amountInt = amountInt * 3;

        int roundedAmount = ((amountInt + 299) / 300);
        String amount = String.valueOf(roundedAmount);

        BeklædningSkruerInderst beklædningSkruerInderst = new BeklædningSkruerInderst(amount);

        return beklædningSkruerInderst.toString();
    }

    private String getStalddørsgreb() {
        Stalddørsgreb stalddørsgreb = new Stalddørsgreb();

        return stalddørsgreb.toString();
    }

    private String getTHængsel() {
        THængsel tHængsel = new THængsel();

        return tHængsel.toString();
    }

    private String getVinkelBeslag(CustomerRequestData customerRequest) {
        int shedLength = getShedLength(customerRequest);
        int shedWidth = getShedWidth(customerRequest);
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


    public ArrayList<String> getMaterialList (CustomerRequestData customerRequestData) {

        boolean shed = shedCheck(customerRequestData);

        ArrayList<String> materialList = new ArrayList<>();

        materialList.add(getStolper(customerRequestData));
        materialList.add(getRem(customerRequestData));
        materialList.add(getSpær(customerRequestData));
        materialList.add(getSpærBeslag());
        materialList.add(getHulbånd(customerRequestData));
        materialList.add(getBeslagskruer());
        materialList.add(getUnderStern(customerRequestData));
        materialList.add(getOverStern(customerRequestData));
        materialList.add(getTrapezPlader(customerRequestData));
        materialList.add(getTrapezPladerSkruer(customerRequestData));
        materialList.add(getVandBræt(customerRequestData));
        materialList.add(getVandBrætSkruer());
        materialList.add(getBræddeBolte(customerRequestData));
        materialList.add(getFirkantSkiver(customerRequestData));
        if(shed) {
            materialList.add(getShedRem(customerRequestData));
            materialList.add(getDørLægte());
            materialList.add(getLøsholter(customerRequestData));
            materialList.add(getSkurBeklædning(customerRequestData));
            materialList.add(getBeklædningSkruerYderst(customerRequestData));
            materialList.add(getBeklædningSkruerInderst(customerRequestData));
            materialList.add(getStalddørsgreb());
            materialList.add(getTHængsel());
            materialList.add(getVinkelBeslag(customerRequestData));
        }

        return materialList;
    }
}
