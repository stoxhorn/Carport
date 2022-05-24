package dat.carport.model.entities.ServiceEntities;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class MaterialList {

    String raftersAmount = "";
    double hulbåndFinalLength;
    String slopeSpærLength;

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

    public int getRoofSlope(CustomerRequestData customerRequest) {
        return parseInt(customerRequest.getRoofSlope().replaceAll("[^0-9]", ""));
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

    public boolean slopeCheck (CustomerRequestData customerRequest) {
        boolean slope = true;
        String slopeCheck = customerRequest.getRoofSlope();
        if(slopeCheck == null) {
            slope = false;
        }
        return slope;
    }

    public boolean roofTypeCheck (CustomerRequestData customerRequest) {
        boolean eternitRoof = true;
        String roofType = customerRequest.getRoofType();
        String roofTypeLowerCase = roofType.toLowerCase();
        if(roofTypeLowerCase.contains("beton")) {
            eternitRoof = false;
        }
        return eternitRoof;
    }

    public String getStolper (CustomerRequestData customerRequest) {
        boolean shed = shedCheck(customerRequest);
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
        int amountInt;
        double price = 227.85;
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
        price = price * amountInt;
        Stolpe s = new Stolpe(String.valueOf(amountInt), price);
        return s.toString();
    }

    public String getRem (CustomerRequestData customerRequest) {
        String length = "";
        double price = 94.95;
        int shedLength = 0;

        boolean shed = shedCheck(customerRequest);
        int carportLength = getCarportLength(customerRequest);
        if(shed) {
            shedLength = getShedLength(customerRequest);
            length = String.valueOf(carportLength - shedLength);
        } else {
            length = String.valueOf(carportLength);
        }

        Rem rem = new Rem();
        price = price * shedLength * rem.getAmount();

        Rem r = new Rem(length, price);

        return r.toString();
    }

    public String getRemSkur (CustomerRequestData customerRequest) {
        String length = "";
        double price = 94.95;

        int shedLength = getShedLength(customerRequest);
        length = String.valueOf(shedLength * 2);

        price = price * shedLength;

        RemSkur remSkur = new RemSkur(length, price);

        return remSkur.toString();
    }

    public String getSpær (CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        String length = customerRequest.getCarportWidth();
        double price = 94.95;
        int amountInt = (int) (Math.round(carportLength / (0.55) + 0.045 * 2));
        raftersAmount = String.valueOf(amountInt);

        price = price * amountInt * carportLength;

        Spær s = new Spær(raftersAmount, length, price);

        return s.toString();
    }

    public String getSpærBeslag() {
        double price = 16.25;
        int amountInt = Integer.parseInt(raftersAmount.replaceAll("[^0-9]", ""));

        price = price * amountInt;

        SpærBeslag spærBeslag = new SpærBeslag(raftersAmount , price);

        return spærBeslag.toString();
    }

    public String getHulbånd(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
        int shedLength = getShedLength(customerRequest);
        double widthDouble = carportWidth;
        double lengthDouble = carportLength - 0.595 - shedLength;
        double hulbåndLength = Math.pow(widthDouble,2) + Math.pow(lengthDouble,2);
        hulbåndFinalLength = Math.sqrt(hulbåndLength);
        int amountInt = (int) Math.ceil(hulbåndFinalLength) / 10;
        String amount = String.valueOf(amountInt);
        String length = String.valueOf(hulbåndFinalLength);
        double price = 289 * amountInt;


        Hulbånd hulbånd = new Hulbånd(amount, length, price);

        return hulbånd.toString();
    }

    public String getBeslagskruer() {
        int raftersAmountInt = parseInt(raftersAmount);
        int firstAmountInt = raftersAmountInt * 2 * 9;
        int secondAmountInt = (int) ((hulbåndFinalLength / 0.595 + 2) * 2);
        int amountInt = firstAmountInt + secondAmountInt;
        //Antallet rundes op da skruerne kommer i pakker af 250
        int roundedAmount = ((amountInt + 249) / 250);
        String amount = String.valueOf(roundedAmount);

        double price = 109 * roundedAmount;

        Beslagskruer beslagskruer = new Beslagskruer(amount, price);

        return beslagskruer.toString();
    }

    public String getUnderStern(CustomerRequestData customerRequest) {
        String frontBackLength = customerRequest.getCarportWidth();
        String sideLength = customerRequest.getCarportLength();
        double price = 76.95;

        UnderStern us = new UnderStern();
        double priceSide = price * us.getSideLength() * us.getSideAmount();
        double priceFrontBack = priceSide * us.getFrontBackLength() * us.getFrontBackAmount();
        price = priceSide + priceFrontBack;

        UnderStern underStern = new UnderStern(sideLength, frontBackLength, price);

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

        double price = 39.95;

        OverStern os = new OverStern();
        double priceSide = price * os.getSideLength() * os.getSideAmount();
        double priceFrontBack = priceSide * os.getFrontBackLength() * os.getFrontBackAmount();
        price = priceSide + priceFrontBack;

        OverStern overStern = new OverStern(frontBackAmount, sideLength, frontBackLength, price);

        return overStern.toString();
    }

    public String getTrapezPlader(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
        int amountInt = carportWidth;
        int lengthInt = 6;
        double lengthDouble = 3.6;
        double price600cm = 315;
        double price360cm = 185;
        double price = price600cm * amountInt;
        if(carportLength > 6) {
            amountInt = amountInt * 2;
        }
        String amount = String.valueOf(amountInt);
        String length = String.valueOf(lengthInt);
        String secondLength = String.valueOf(lengthDouble);

        if(carportLength > 6) {
            //Hvis taget er over 6 meter bruges ekstra plader som er 3,6 meter lange og overlappes så det passer
            String finalLength = length + secondLength;
            price360cm = price360cm * amountInt;
            price = price360cm + price600cm;
            TrapezPlader trapezPlader = new TrapezPlader(finalLength, amount, price);
            return trapezPlader.toString();
        } else {
            TrapezPlader trapezPlader = new TrapezPlader(length, amount, price);
            return trapezPlader.toString();
        }
    }

    public String getTrapezPladerSkruer(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
        int carportArea = carportLength * carportWidth;
        int amountInt = 12 * carportArea;
        //Rundes op da de kommer i pakker af 200
        int roundedAmount = ((amountInt + 199) / 200);
        String amount = String.valueOf(roundedAmount);
        double price = 394.95 * roundedAmount;

        TrapezPladerSkruer trapezPladerSkruer = new TrapezPladerSkruer(amount, price);

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

        VandBræt vb = new VandBræt();

        double price = 10.95;
        double priceSide = price * vb.getSideLength() * vb.getSideAmount();
        double priceFrontBack = price * vb.getFrontBackLength() * vb.getFrontBackAmount();
        price = priceSide + priceFrontBack;

        VandBræt vandBræt = new VandBræt(frontBackAmount, sideLength, frontBackLength, price);

        return vandBræt.toString();
    }

    public String getVandBrætSkruer() {
        VandBrætSkruer vbs = new VandBrætSkruer();
        double price = 49.95 * vbs.getAmount();

        VandBrætSkruer vandBrætSkruer = new VandBrætSkruer(price);

        return vandBrætSkruer.toString();
    }

    public String getDørLægte() {
        DørLægte dl = new DørLægte();

        double price = 49.95 * dl.getLength() * dl.getAmount();

        DørLægte dørLægte = new DørLægte(price);

        return dørLægte.toString();
    }

    public String getLøsholter(CustomerRequestData customerRequest) {
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

        Løsholter lh = new Løsholter();
        double price = 99.95;
        double priceSide = price * lh.getSideLength() * lh.getSideAmount();
        double priceGavl = price * lh.getGavlLength() * lh.getGavlAmount();
        price = priceGavl + priceSide;

        Løsholter løsholter = new Løsholter(sideAmount, gavlAmount, price);

        return løsholter.toString();
    }

    public String getSkurBeklædning(CustomerRequestData customerRequest) {
        int shedLength = getShedLength(customerRequest);
        int shedWidth = getShedWidth(customerRequest);
        int amountInt = (shedLength * 2 + shedWidth * 2) / 80;
        String amount = String.valueOf(amountInt);
        double price = 23 * amountInt;

        SkurBeklædning skurBeklædning = new SkurBeklædning(amount, price);

        return skurBeklædning.toString();
    }

    public String getBræddeBolte(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
        int amountInt;
        if(carportWidth * carportLength / 40000 < 8) {
            amountInt = 12;
        } else {
            amountInt = 18;
        }
        String amount = String.valueOf(amountInt);
        double price = 14.36 * amountInt;

        BræddeBolte bræddeBolte = new BræddeBolte(amount, price);

        return bræddeBolte.toString();
    }

    public String getFirkantSkiver(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
        int amountInt;
        if(carportWidth * carportLength / 40000 < 8) {
            amountInt = 8;
        } else {
            amountInt = 12;
        }
        String amount = String.valueOf(amountInt);
        double price = 7.58 * amountInt;

        Firkantskiver firkantskiver = new Firkantskiver(amount, price);

        return firkantskiver.toString();
    }

    public String getBeklædningSkruerYderst(CustomerRequestData customerRequest) {
        int shedLength = getShedLength(customerRequest);
        int shedWidth = getShedWidth(customerRequest);

        int amountInt = (shedLength * 2 + shedWidth * 2) / 80;
        amountInt = amountInt * 4;

        int roundedAmount = ((amountInt + 399) / 400);
        String amount = String.valueOf(roundedAmount);
        double price = 199 * roundedAmount;

        BeklædningSkruerYderst beklædningSkruerYderst = new BeklædningSkruerYderst(amount, price);

        return beklædningSkruerYderst.toString();
    }

    public String getBeklædningSkruerInderst(CustomerRequestData customerRequest) {
        int shedLength = getShedLength(customerRequest);
        int shedWidth = getShedWidth(customerRequest);

        int amountInt = (shedLength * 2 + shedWidth * 2) / 80;
        amountInt = amountInt * 3;

        int roundedAmount = ((amountInt + 299) / 300);
        String amount = String.valueOf(roundedAmount);

        double price = 109 * roundedAmount;

        BeklædningSkruerInderst beklædningSkruerInderst = new BeklædningSkruerInderst(amount, price);

        return beklædningSkruerInderst.toString();
    }

    public String getStalddørsgreb() {
        double price = 259;
        Stalddørsgreb stalddørsgreb = new Stalddørsgreb(price);

        return stalddørsgreb.toString();
    }

    public String getTHængsel() {
        double price = 89.95;
        THængsel tHængsel = new THængsel(price);

        return tHængsel.toString();
    }

    public String getVinkelBeslag(CustomerRequestData customerRequest) {
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
        double price = 9.95 * totalAmount;

        VinkelBeslag vinkelBeslag = new VinkelBeslag(amount, price);

        return vinkelBeslag.toString();
    }

    public String getSlopeSpær(CustomerRequestData customerRequest) {
        int carportWidth = getCarportWidth(customerRequest);
        int roofSlope = getRoofSlope(customerRequest);
        double slopeA = (180 - (180 - roofSlope)) / 2;
        int slopeSpærLengthInt = (int) (carportWidth / (2 * Math.cos(slopeA)));
        slopeSpærLength = String.valueOf(slopeSpærLengthInt);
        int slopeSpærAmountInt;
        if(!roofTypeCheck(customerRequest)) {
            slopeSpærAmountInt = slopeSpærLengthInt / 90 * 2;
        } else {
            slopeSpærAmountInt = slopeSpærLengthInt / 60 * 2;
        }
        String slopeSpærAmount = String.valueOf(slopeSpærAmountInt);
        double price = 74.95 * slopeSpærLengthInt * slopeSpærAmountInt;

        SlopeSpær slopeSpær = new SlopeSpær(slopeSpærAmount, slopeSpærLength, price);

        return slopeSpær.toString();
    }

    public String getTagLægter(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int slopeSpærLengthInt = Integer.parseInt(slopeSpærLength);
        int tagLægterAmount = slopeSpærLengthInt * 2 * carportLength;
        if(!roofTypeCheck(customerRequest)) {
            tagLægterAmount = tagLægterAmount * 2;
        }
        String amount = String.valueOf(tagLægterAmount);
        double price = 149.85 * tagLægterAmount;

        TagLægter tagLægter = new TagLægter(amount, price);

        return tagLægter.toString();
    }

    public String getVindskeder(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
        int amountInt = (carportLength + carportWidth) * 2 / 270;
        String amount = String.valueOf(amountInt);
        double price = 29.56 * amountInt;

        Vindskeder vindskeder = new Vindskeder(amount, price);

        return vindskeder.toString();
    }

    public String getSlopeStern(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int carportWidth = getCarportWidth(customerRequest);
        int amountInt = (carportLength + carportWidth) * 2 / 300 + 6;
        String amount = String.valueOf(amountInt);
        double price = 32.85 * amountInt;

        SlopeStern slopeStern = new SlopeStern(amount, price);

        return slopeStern.toString();
    }

    public String getEternitPlader(CustomerRequestData customerRequest) {
        String name = customerRequest.getRoofMaterial();
        int carportLength = getCarportLength(customerRequest);
        int spærLength = Integer.parseInt(slopeSpærLength);
        int amountInt = (carportLength * spærLength * 2);
        int roundedAmount = ((amountInt + 1) / 2) * 2;
        String amount = String.valueOf(roundedAmount);
        double price = 199.95 * roundedAmount;

        Eternitplader eternitplader = new Eternitplader(name, amount, price);

        return eternitplader.toString();
    }

    public String getEternitRygninger(CustomerRequestData customerRequest) {
        String name = customerRequest.getRoofMaterial();
        int carportLength = getCarportLength(customerRequest);
        int amountInt = carportLength / 100;
        String amount = String.valueOf(amountInt);
        double price = 299 * amountInt;

        EternitRygninger eternitRygninger = new EternitRygninger(name, amount, price);

        return eternitRygninger.toString();
    }

    public String getBetontagRygninger(CustomerRequestData customerRequest) {
        String name = customerRequest.getRoofMaterial();
        int carportLength = getCarportLength(customerRequest);
        int amountInt = carportLength / 42;
        String amount = String.valueOf(amountInt);
        double price = 119 * amountInt;

        BetontagRygninger betontagRygninger = new BetontagRygninger(name, amount, price);

        return betontagRygninger.toString();
    }

    public String getBetonTagsten(CustomerRequestData customerRequest) {
        String name = customerRequest.getRoofMaterial();
        int carportLength = getCarportLength(customerRequest);
        int slopeSpærLengthInt = Integer.parseInt(slopeSpærLength);
        int amountInt = (int) ((carportLength / 0.404) * (slopeSpærLengthInt / 0.336) * 2);
        int roundedAmount = ((amountInt + 1) / 2) * 2;
        String amount = String.valueOf(roundedAmount);
        double price = 17.95 * roundedAmount;

        BetonTagsten betonTagsten = new BetonTagsten(name, amount, price);

        return betonTagsten.toString();
    }

    public String getTagstenskroge(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int slopeSpærLengthInt = Integer.parseInt(slopeSpærLength);
        int amountInt = (int) ((carportLength / 0.404) * (slopeSpærLengthInt / 0.336) * 2);
        int roundedAmount = ((amountInt + 99) / 100);
        String amount = String.valueOf(roundedAmount);
        double price = 119 * roundedAmount;

        Tagstenskroge tagstenskroge = new Tagstenskroge(amount, price);

        return tagstenskroge.toString();
    }


    public String getEternitSkruer(CustomerRequestData customerRequest) {
        int carportLength = getCarportLength(customerRequest);
        int spærLength = Integer.parseInt(slopeSpærLength);
        int amountInt = (carportLength * spærLength * 2);
        int roundedAmount = ((amountInt + 99) / 100);
        String amount = String.valueOf(roundedAmount);
        double price = 809 * roundedAmount;

        EternitSkruer eternitSkruer = new EternitSkruer(amount, price);

        return eternitSkruer.toString();
    }

    public double getPrice(String material) {
        return Double.parseDouble(material.substring(material.indexOf("Pris: ") + 6, material.length() - 3));
    }

    public String getTotalPrice(CustomerRequestData cr) {
        boolean shed = shedCheck(cr);
        boolean slope = slopeCheck(cr);
        boolean eternitRoof = roofTypeCheck(cr);

        double total = 0;
        double stolperDouble;
        double remDouble;
        double overSternDouble;
        double underSternDouble;
        double vandBrætDouble;
        double vandBrætSkruerDouble;
        double bræddeBolteDouble;
        double firkantSkiverDouble;
        double spærDouble;
        double spærBeslagDouble;
        double hulbåndDouble;
        double beslagskruerDouble;
        double trapezPladerDouble;
        double trapezPladerSkruerDouble;
        double remSkurDouble;
        double dørLægteDouble;
        double løsHolterDouble;
        double skurBeklædningDouble;
        double beklædningSkruerYderstDouble;
        double beklædningSkruerInderstDouble;

        String stolper = getStolper(cr);
        stolperDouble = getPrice(stolper);

        String rem = getRem(cr);
        remDouble = getPrice(rem);

        String overStern = getOverStern(cr);
        overSternDouble = getPrice(overStern);

        String underStern = getUnderStern(cr);
        underSternDouble = getPrice(underStern);

        String vandBræt = getVandBræt(cr);
        vandBrætDouble = getPrice(vandBræt);

        String vandBrætSkruer = getVandBrætSkruer();
        vandBrætSkruerDouble = getPrice(vandBrætSkruer);

        String bræddeBolte = getBræddeBolte(cr);
        bræddeBolteDouble = getPrice(bræddeBolte);

        String firkantskiver = getFirkantSkiver(cr);
        firkantSkiverDouble = getPrice(firkantskiver);

        total = total + stolperDouble + remDouble + underSternDouble + overSternDouble + vandBrætDouble
        + vandBrætSkruerDouble + bræddeBolteDouble + firkantSkiverDouble;
        if(!slope) {
            String spær = getSpær(cr);
            spærDouble = getPrice(spær);

            String spærBeslag = getSpærBeslag();
            spærBeslagDouble = getPrice(spærBeslag);

            total = total + spærDouble + spærBeslagDouble;
        }
        if(shed) {
            String beklædningSkruerInderstPrice = getBeklædningSkruerInderst(cr);
            beklædningSkruerInderstDouble = getPrice(stolper);
            total = total + beklædningSkruerInderstDouble;
        }


        return "Total pris: " + total + "kr.";
    }


    public ArrayList<String> getMaterialList (CustomerRequestData customerRequest) {
        boolean shed = shedCheck(customerRequest);
        boolean slope = slopeCheck(customerRequest);
        boolean eternitRoof = roofTypeCheck(customerRequest);

        ArrayList<String> materialList = new ArrayList<>();

        materialList.add(getStolper(customerRequest));
        materialList.add(getRem(customerRequest));
        materialList.add(getUnderStern(customerRequest));
        materialList.add(getOverStern(customerRequest));
        materialList.add(getVandBræt(customerRequest));
        materialList.add(getVandBrætSkruer());
        materialList.add(getBræddeBolte(customerRequest));
        materialList.add(getFirkantSkiver(customerRequest));
        if(!slope) {
            materialList.add(getSpær(customerRequest));
            materialList.add(getSpærBeslag());
            materialList.add(getHulbånd(customerRequest));
            materialList.add(getBeslagskruer());
            materialList.add(getTrapezPlader(customerRequest));
            materialList.add(getTrapezPladerSkruer(customerRequest));
        }
        if(shed) {
            materialList.add(getRemSkur(customerRequest));
            materialList.add(getDørLægte());
            materialList.add(getLøsholter(customerRequest));
            materialList.add(getSkurBeklædning(customerRequest));
            materialList.add(getBeklædningSkruerYderst(customerRequest));
            materialList.add(getBeklædningSkruerInderst(customerRequest));
            materialList.add(getStalddørsgreb());
            materialList.add(getTHængsel());
            materialList.add(getVinkelBeslag(customerRequest));
        }
        if(slope) {
            materialList.add(getSlopeSpær(customerRequest));
            materialList.add(getTagLægter(customerRequest));
            materialList.add(getVindskeder(customerRequest));
            materialList.add(getSlopeStern(customerRequest));
            if(eternitRoof) {
                materialList.add(getEternitSkruer(customerRequest));
                materialList.add(getEternitPlader(customerRequest));
                materialList.add(getEternitRygninger(customerRequest));
            } else {
                materialList.add(getBetonTagsten(customerRequest));
                materialList.add(getBetontagRygninger(customerRequest));
                materialList.add(getTagstenskroge(customerRequest));
            }
        }
        materialList.add(getTotalPrice(customerRequest));

        return materialList;
    }
}
