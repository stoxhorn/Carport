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

    public static class BeklædningSkruerInderst {
        String name;
        String amount;
        String height;
        String width;
        String unit;
        String description;
    
        public BeklædningSkruerInderst(String amount) {
            this.name = "Skruer, ";
            this.amount = amount;
            this.height = ", Højde: 4,5mm,";
            this.width = " Bredde: 50mm,";
            this.unit = " Enhed: pakke,";
            this.description = " til montering af inderste beklædning kommer i pakker med 300";
        }
    
        @Override
        public String toString() {
            return name + "Antal: " + amount + height + width + unit + description;
        }
    }

    public static class BeklædningSkruerYderst {
        String name;
        String amount;
        String height;
        String width;
        String unit;
        String description;
    
        public BeklædningSkruerYderst(String amount) {
            this.name = "Skruer, ";
            this.amount = amount;
            this.height = ", Højde: 4,5mm,";
            this.width = " Bredde: 70mm,";
            this.unit = " Enhed: pakke,";
            this.description = " til montering af yderste beklædning kommer i pakker med 400";
        }
    
        @Override
        public String toString() {
            return name + "Antal: " + amount + height + width + unit + description;
        }
    }

    public static class Beslagskruer {
    
        String name;
        String amount;
        String height;
        String width;
        String unit;
        String description;
    
        public Beslagskruer(String amount) {
            this.name = "Beslagskruer 4,0 x 50 mm., ";
            this.amount = amount;
            this.height = ", Højde: 50mm,";
            this.width = " Bredde: 4mm,";
            this.unit = " Enhed: pakke,";
            this.description = " Til montering af universalbeslag + hulbånd kommer i pakker af 250";
        }
    
        @Override
        public String toString() {
            return name + "Antal: " + amount + height + width + unit + description;
        }
    }

    public class BræddeBolte {
        String name;
        String amount;
        String height;
        String width;
        String unit;
        String description;
    
        public BræddeBolte(String amount) {
            this.name = "Bræddebolt, ";
            this.amount = amount;
            this.height = ", Højde: 10mm,";
            this.width = " Bredde: 120mm,";
            this.unit = " Enhed: stk.,";
            this.description = " til montering af rem på stolper";
        }
    
        @Override
        public String toString() {
            return name + "Antal: " + amount + height + width + unit + description;
        }
    }

    public class DørLægte {
        String name;
        String amount;
        String height;
        String width;
        String length;
        String unit;
        String description;
    
        public DørLægte() {
            this.name = "Lægte ubh., ";
            this.amount = " Antal: 1,";
            this.height = " Højde: 38mm,";
            this.width = " Bredde: 73mm,";
            this.length = " Længde: 420cm,";
            this.unit = " Enhed: stk.,";
            this.description = " til z på bagside af dør";
        }
    
        @Override
        public String toString() {
            return name + amount + height + width + length + unit + description;
        }
    }

    public class Firkantskiver {
        String name;
        String amount;
        String height;
        String width;
        String length;
        String unit;
        String description;
    
        public Firkantskiver(String amount) {
            this.name = "Firkantskiver, ";
            this.amount = amount;
            this.height = ", Højde: 11mm,";
            this.width = " Brede: 40mm,";
            this.length = " Længde: 40mm,";
            this.unit = " Enhed: stk.,";
            this.description = " til montering af rem på stolper";
        }
    
        @Override
        public String toString() {
            return name + "Antal: " + amount + height + width + length + unit + description;
        }
    }

    public class Hulbånd {
    
        String name;
        String amount;
        String height;
        String width;
        String length;
        String unit;
        String description;
    
        public Hulbånd(String amount, String length) {
            this.name = "Hulbånd 1x20 mm, ";
            this.amount = amount;
            this.height = ", Højde: 1mm,";
            this.width = " Bredde: 20mm,";
            this.length = length;
            this.unit = ", Enhed: Rulle,";
            this.description = " Til vindkryds på spær";
        }
    
        @Override
        public String toString() {
            return  name + "Antal: " + amount + height + width + " Længde: " + length + "m" + unit + description;
        }
    }

    public class Løsholter {
        String name;
        String sideAmount;
        String gavlAmount;
        String height;
        String width;
        String sideLength;
        String gavlLength;
        String unit;
        String description;
    
        public Løsholter(String sideAmount, String gavlAmount) {
            this.name = "Reglar ub. sider og gavl, ";
            this.sideAmount = sideAmount;
            this.gavlAmount = gavlAmount;
            this.height = ", Højde: 45mm,";
            this.width = " Bredde: 95mm,";
            this.sideLength = " Længde sider: 240cm,";
            this.gavlLength = " Længde gavl: 270cm,";
            this.unit = " Enhed: stk.,";
            this.description = " løsholter til skur sider og gavl";
        }
    
        @Override
        public String toString() {
            return name + "Antal sider: " + sideAmount + ", Antal gavl: " + gavlAmount + height + width + sideLength +
                    gavlLength + unit + description;
        }
    }

    public class OverStern {
        String name;
        String sideAmount;
        String frontBackAmount;
        String height;
        String width;
        String sideLength;
        String frontBackLength;
        String unit;
        String description;
    
    
        public OverStern(String frontBackAmount, String sideLength, String frontBackLength) {
            this.name = "Trykimp. bræt. overstern, ";
            this.sideAmount = " 4,";
            this.frontBackAmount = frontBackAmount;
            this.height = ", Højde: 25mm,";
            this.width = " Bredde: 125mm,";
            this.sideLength = sideLength;
            this.frontBackLength = frontBackLength;
            this.unit = " Enhed: stk.,";
            this.description = " Oversternbrædder til forende, bagende og sider";
        }
    
        @Override
        public String toString() {
            return  name + "Antal sider:" +  sideAmount + " Antal for og bagende: " + frontBackAmount +  height +
                    width + " Sider: "+  sideLength + "cm, For og bagende: " + frontBackLength + "cm," + unit +
                    description;
        }
    }

    public class Rem {
    
        String name;
        String amount;
        String height;
        String width;
        String length;
        String unit;
        String description;
    
        public Rem(String length) {
            this.name = "Spærtræ ubh., ";;
            this.amount = " 2,";
            this.height = " Højde: 195mm,";
            this.width = " Bredde: 45mm,";
            this.length = length;
            this.unit = ", Enhed: stk.,";
            this.description = " Remme i sider, sadles ned i stolper";
        }
    
        @Override
        public String toString() {
            return name + "antal: " + amount + height + width + " Længde: " + length + "cm" + unit + description;
        }
    }

    public class RemSkur {
    
        String name;
        String amount;
        String height;
        String width;
        String length;
        String unit;
        String description;
    
        public RemSkur(String length) {
            this.name = "Skur rem spærtræ ubh., ";
            this.amount = " 1";
            this.height = ", Højde: 195mm";
            this.width = ", Bredde: 45mm";
            this.length = length;
            this.unit = " Enhed: stk.,";
            this.description = " Remme i sider, sadles ned i stolper (skur del, deles)";
        }
    
        @Override
        public String toString() {
            return name + "Antal: " + amount + height + width + " Længde: " + length + "cm," + unit + description;
        }
    }

    public class SkurBeklædning {
        String name;
        String amount;
        String height;
        String width;
        String length;
        String unit;
        String description;
    
        public SkurBeklædning(String amount) {
            this.name = "Tryk imp. bræt, ";
            this.amount = amount;
            this.height = ", Højde: 19mm,";
            this.width = " Bredde: 100mm,";
            this.length = " Længde: 210cm,";
            this.unit = " Enhed: stk.,";
            this.description = " til beklædning af skur 1 på 2";
        }
    
        @Override
        public String toString() {
            return name + "Antal: " + amount + height + width + length + unit + description;
        }
    }

    public class Spær {
    
        String name;
        String raftersAmount;
        String height;
        String width;
        String length;
        String unit;
        String description;
    
        public Spær(String amount, String length){
            this.name = "Spærtræ ubh., ";
            this.raftersAmount = amount;
            this.height = ", Højde: 195mm";
            this.width = ", Bredde: 45mm,";
            this.length = length;
            this.unit = ", Enhed: stk.,";
            this.description = " Spær monteres på rem";
        }
    
        @Override
        public String toString(){
            return name + "Antal: " + raftersAmount + height + width + " Længde: " + length + "cm" + unit + description;
        }
    
    }

    public class SpærBeslag {
    
        String name;
        String amount;
        String unit;
        String description;
    
        public SpærBeslag(String amount) {
            this.name = "Universalbeslag 190 mm højre og venstre, ";
            this.amount = amount;
            this.unit = ", Enhed: stk.,";
            this.description = " Spær beslag til montering af spær på rem";
        }
    
        @Override
        public String toString() {
            return name + "Antal: " + amount + unit + description;
        }
    }

    public class Stalddørsgreb {
        String name;
        String amount;
        String height;
        String width;
        String unit;
        String description;
    
        public Stalddørsgreb() {
            this.name = "Stalddørsgreb, ";
            this.amount = " 1,";
            this.height = " Højde: 50mm,";
            this.width = " Bredde: 75mm,";
            this.unit = " Enhed: sæt,";
            this.description = " til lås på skur dør";
        }
    
        @Override
        public String toString() {
            return name + "Antal: " + amount + height + width + unit + description;
        }
    }

    public class Stolpe {
            String name;
            String amount;
            String height;
            String width;
            String unit;
            String description;
            String length;
    
        public Stolpe(String amount) {
            this.name = "Trykimp. stolpe, ";
            this.height = " Højde: 97mm,";
            this.width = " Bredde: 97mm,";
            this.length = " Længde: 300cm,";
            this.unit = " Enhed: stk.,";
            this.description = " stolper nedgraves 90 cm. i jord";
            this.amount = amount;
        }
    
        @Override
            public String toString(){
                return name + "Antal: " + amount + height + width + length + unit + description;
            }
    }

    public class THængsel {
        String name;
        String amount;
        String width;
        String unit;
        String description;
    
        public THængsel() {
            this.name = "Skruer, ";
            this.amount = " 2,";
            this.width = " Bredde: 390mm,";
            this.unit = " Enhed: stk.,";
            this.description = " til skurdør";
        }
    
        @Override
        public String toString() {
            return name + "Antal: " + amount + width + unit + description;
        }
    }

    public class TrapezPlader {
        String name;
        String amount;
        String width;
        String length;
        String unit;
        String description;
    
        public TrapezPlader(String amount, String length) {
            this.name = "Trapezplader, ";
            this.amount = amount;
            this.width = ", Bredde: 110cm,";
            this.length = length;
            this.unit = " Enhed: stk.,";
            this.description = " Plastmo ecolite tagplader monteres på spær";
        }
    
        @Override
        public String toString() {
            return name + "Antal: " + amount + width + " Længde: " + length + "cm," + unit + description;
        }
    }

    public class TrapezPladerSkruer {
        String name;
        String amount;
        String unit;
        String description;
    
        public TrapezPladerSkruer(String amount) {
            this.name = "Trapezplade bundskruer, ";
            this.amount = amount;
            this.unit = ", Enhed: pakke,";
            this.description = " Skruer til plastmo tagplader kommer i pakker af 200 stk.";
        }
    
        @Override
        public String toString() {
            return name + "Antal: " + amount + unit + description;
        }
    }

    public class UnderStern {
        String name;
        String sideAmount;
        String frontBackAmount;
        String height;
        String width;
        String sideLength;
        String frontBackLength;
        String unit;
        String description;
    
    
        public UnderStern(String sideLength, String frontBackLength) {
            this.name = "Trykimp. bræt. understern, ";
            this.sideAmount = " 4";
            this.frontBackAmount = " 4";
            this.height = " Højde: 25mm,";
            this.width = " Bredde: 200mm,";
            this.sideLength = sideLength;
            this.frontBackLength = frontBackLength;
            this.unit = " Enhed: stk.,";
            this.description = " Understernbrædder til forende, bagende og sider";
        }
    
        @Override
        public String toString() {
            return  name + "Antal sider:" +  sideAmount + ", Antal for og bagende:" + frontBackAmount +  height +
                    width + " Sider: "+  sideLength + "cm, For og bagende: " + frontBackLength + "cm," + unit +
                    description;
        }
    }

    public class VandBræt {
        String name;
        String sideAmount;
        String frontBackAmount;
        String height;
        String width;
        String sideLength;
        String frontBackLength;
        String unit;
        String description;
    
        public VandBræt(String frontBackAmount, String sideLength, String frontBackLength) {
            this.name = "Trykimp. vandbræt, ";
            this.sideAmount = " 4, ";
            this.frontBackAmount = frontBackAmount;
            this.height = ", Højde: 19mm,";
            this.width = " Bredde: 100mm, ";
            this.sideLength = sideLength;
            this.frontBackLength = frontBackLength;
            this.unit = " Enhed: stk.,";
            this.description = " Vandbrædt på stern i forende, bagende og sider,";
        }
    
        @Override
        public String toString() {
            return  name + "Antal sider: " +  sideAmount + "Antal for og bagende: " + frontBackAmount +  height +
                    width + "Sider: "+  sideLength + "cm, For og bagende: " + frontBackLength + "cm," + unit +
                    description;
        }
    }

    public class VandBrætSkruer {
        String name;
        String amount;
        String height;
        String width;
        String unit;
        String description;
    
        public VandBrætSkruer() {
            this.name = "Skruer til vandbræt og stern, ";
            this.amount = " Antal: 1,";
            this.height = " Højde: 4,5mm,";
            this.width = " Bredde: 60mm,";
            this.unit = " Enhed: pakke,";
            this.description = " Til montering af vandbræt og stern kommer i pakker med 200";
        }
    
        @Override
        public String toString() {
            return name + amount + height + width + unit + description;
        }
    }

    public class VinkelBeslag {
        String name;
        String amount;
        String unit;
        String description;
    
        public VinkelBeslag(String amount) {
            this.name = "Vinkelbeslag 35, ";
            this.amount = amount;
            this.unit = ", Enhed: stk.,";
            this.description = " til montering af løsholter i skur";
        }
    
        @Override
        public String toString() {
            return name + "antal: " + amount + unit + description;
        }
    
    }
}
